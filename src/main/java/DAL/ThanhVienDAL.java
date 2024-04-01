package DAL;

import java.util.ArrayList;

import org.hibernate.Session;

import Model.ThanhVienModel;
import Model.ThanhVienModel;
import Util.HibernateUtil;

public class ThanhVienDAL {
	Session session;
	public ThanhVienDAL() {
		session= HibernateUtil.getSessionFactory().openSession();
	}
	public ArrayList<ThanhVienModel> getList(){
		ArrayList<ThanhVienModel> list;
		session.beginTransaction();
		list= (ArrayList<ThanhVienModel>) session.createQuery("FROM ThanhVienModel",ThanhVienModel.class).list();
		session.getTransaction().commit();
		return list;
	}
	public ThanhVienModel getModel(int id) {
		session.beginTransaction();
		ThanhVienModel thongtin= session.get(ThanhVienModel.class, id);
		session.getTransaction().commit();
		return thongtin;
	}
	public void addModel(ThanhVienModel member) {
		session.beginTransaction();
		session.save(member);
		session.getTransaction().commit();
	}
	public void updateModel(ThanhVienModel member) {
		session.beginTransaction();
		session.update(member);
		session.getTransaction().commit();
	}
	public void deleteModel(ThanhVienModel member) {
		session.beginTransaction();
		session.delete(member);
		session.getTransaction().commit();
	}
	

}
