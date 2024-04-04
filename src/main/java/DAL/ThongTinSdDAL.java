package DAL;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import Model.ThanhVienModel;
import Model.ThongTinSdModel;
import Util.HibernateUtil;

import javax.persistence.Query;

public class ThongTinSdDAL {
	Session session;
	public ThongTinSdDAL() {
		session= HibernateUtil.getSessionFactory().openSession();
	}
	public ArrayList<ThongTinSdModel> getList(){
		ArrayList<ThongTinSdModel> list;
		session.beginTransaction();
		list= (ArrayList<ThongTinSdModel>) session.createQuery("FROM ThongTinSdModel",ThongTinSdModel.class).list();
		session.getTransaction().commit();
		return list;
	}
	public ThongTinSdModel getModel(int id) {
		session.beginTransaction();
		ThongTinSdModel thongtin= session.get(ThongTinSdModel.class, id);
		session.getTransaction().commit();
		return thongtin;
	}
	public ThongTinSdModel getModelByMaTVAndMaTB(int matv, int matb) {
		session.beginTransaction();
		String queryCondition = "";
		if(matv != -1) {
			queryCondition += queryCondition.isEmpty() ? " MaTV = " + matv : " AND MaTV = " + matv;
		}
		if (matb != -1) {
			queryCondition += queryCondition.isEmpty() ? " MaTB = " + matb : " AND MaTB = " + matb;
		}
		Query query = session.createQuery("FROM ThongTinSdModel WHERE " + queryCondition);
		List<ThongTinSdModel> resultList = query.getResultList();
		session.getTransaction().commit();

		if (resultList.isEmpty()) {
			return null;
		} else {
			return resultList.get(0);
		}
	}
	public void addModel(ThongTinSdModel infor) {
		session.beginTransaction();
		session.save(infor);
		session.getTransaction().commit();
	}
	public void updateModel(ThongTinSdModel infor) {
		session.beginTransaction();
		ThongTinSdModel oldInfor =  session.get(ThongTinSdModel.class, infor.getMaTT());
		oldInfor.setTgDatCho(infor.getTgDatCho());
		oldInfor.setTgDatCho(infor.getTgDatCho());
		oldInfor.setTgMuon(infor.getTgMuon());
		oldInfor.setTgTra(infor.getTgTra());
		oldInfor.setTgVao(infor.getTgVao());
		oldInfor.setThietBi(infor.getThietBi());
		oldInfor.setThanhVien(infor.getThanhVien());
		session.update(oldInfor);
		session.getTransaction().commit();
	}
	public void deleteModel(ThongTinSdModel infor) {
		session.beginTransaction();
		session.delete(infor);
		session.getTransaction().commit();
	}
}
