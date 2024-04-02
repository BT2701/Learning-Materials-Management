package DAL;

import java.util.ArrayList;

import org.hibernate.Session;

import Model.ThietBiModel;
import Util.HibernateUtil;

public class ThietBiDAL {
	Session session;
	public ThietBiDAL() {
		session= HibernateUtil.getSessionFactory().openSession();
	}
	public ArrayList<ThietBiModel> getList(){
		ArrayList<ThietBiModel> list;
		session.beginTransaction();
		list= (ArrayList<ThietBiModel>) session.createQuery("FROM ThietBiModel",ThietBiModel.class).list();
		session.getTransaction().commit();
		return list;
	}
	public ThietBiModel getModel(int id) {
		session.beginTransaction();
		ThietBiModel thongtin= session.get(ThietBiModel.class, id);
		session.getTransaction().commit();
		return thongtin;
	}
	public void addModel(ThietBiModel device) {
		session.beginTransaction();
		session.save(device);
		session.getTransaction().commit();
	}
	public void updateModel(ThietBiModel device) {
		session.beginTransaction();
		session.update(device);
		session.getTransaction().commit();
	}
	public void deleteModel(ThietBiModel device) {
		session.beginTransaction();
		session.delete(device);
		session.getTransaction().commit();
	}
}
