package DAL;

import java.util.ArrayList;

import org.hibernate.Session;

import Model.XuLyModel;
import Util.HibernateUtil;

public class XuLyDAL {
	Session session;
	public XuLyDAL() {
		session= HibernateUtil.getSessionFactory().openSession();
	}
	public ArrayList<XuLyModel> getList(){
		ArrayList<XuLyModel> list;
		session.beginTransaction();
		list= (ArrayList<XuLyModel>) session.createQuery("FROM XuLyModel",XuLyModel.class).list();
		session.getTransaction().commit();
		return list;
	}
	public XuLyModel getModel(int id) {
		session.beginTransaction();
		XuLyModel thongtin= session.get(XuLyModel.class, id);
		session.getTransaction().commit();
		return thongtin;
	}
	public void addModel(XuLyModel handle) {
		session.beginTransaction();
		session.save(handle);
		session.getTransaction().commit();
	}
	public void updateModel(XuLyModel handle) {
		session.beginTransaction();
		session.update(handle);
		session.getTransaction().commit();
	}
	public void deleteModel(XuLyModel handle) {
		session.beginTransaction();
		session.delete(handle);
		session.getTransaction().commit();
	}
}
