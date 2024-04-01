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
		session.beginTransaction();
		ThongTinSdModel thongtin= session.get(ThongTinSdModel.class, id);
		session.getTransaction().commit();
		return thongtin;
	}
	public void addModel(ThongTinSdModel infor) {
		session.beginTransaction();
		session.save(infor);
		session.getTransaction().commit();
	}
	public void updateModel(ThongTinSdModel infor) {
		session.beginTransaction();
		session.update(infor);
		session.getTransaction().commit();
	}
	public void deleteModel(ThongTinSdModel infor) {
		session.beginTransaction();
		session.delete(infor);
		session.getTransaction().commit();
	}
}
