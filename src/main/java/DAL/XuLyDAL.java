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
		XuLyModel thongtin= session.get(XuLyModel.class, id);
		return thongtin;
	}
	public void addModel(XuLyModel handle) {
		session.save(handle);
	}
	public void updateModel(XuLyModel handle) {
		session.update(handle);
	}
	public void deleteModel(XuLyModel handle) {
		session.delete(handle);
	}
}
