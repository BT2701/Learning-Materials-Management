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
		ThietBiModel thongtin= session.get(ThietBiModel.class, id);
		return thongtin;
	}
	public void addModel(ThietBiModel device) {
		session.save(device);
	}
	public void updateModel(ThietBiModel device) {
		session.update(device);
	}
	public void deleteModel(ThietBiModel device) {
		session.delete(device);
	}
}
