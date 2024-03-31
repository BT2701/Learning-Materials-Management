package DAL;

import java.util.ArrayList;

import org.hibernate.Session;

import Model.ThanhVienModel;
import Model.ThongTinSdModel;
import Util.HibernateUtil;

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
		ThongTinSdModel thongtin= session.get(ThongTinSdModel.class, id);
		return thongtin;
	}
	public void addModel(ThongTinSdModel infor) {
		session.save(infor);
	}
	public void updateModel(ThongTinSdModel infor) {
		session.update(infor);
	}
	public void deleteModel(ThongTinSdModel infor) {
		session.delete(infor);
	}
}
