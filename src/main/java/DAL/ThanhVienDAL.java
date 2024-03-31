package DAL;

import java.util.ArrayList;

import org.hibernate.Session;

import Model.ThanhVienModel;
import Util.HibernateUtil;

public class ThanhVienDAL {
	Session session;
	public ThanhVienDAL() {
		session= HibernateUtil.getSessionFactory().openSession();
	}
	public ArrayList<ThanhVienModel> getListMembers(){
		ArrayList<ThanhVienModel> list;
		session.beginTransaction();
		list= (ArrayList<ThanhVienModel>) session.createQuery("FROM ThanhVienModel",ThanhVienModel.class).list();
		session.getTransaction().commit();
		return list;
	}
	public ThanhVienModel getMember(int id) {
		ThanhVienModel member= session.get(ThanhVienModel.class, id);
		return member;
	}
	

}
