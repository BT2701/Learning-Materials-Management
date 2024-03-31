package DAL;

import java.util.ArrayList;

import org.hibernate.Session;

import Model.ThanhVienModel;
import Model.ThietBiModel;
import Model.ThongTinSdModel;
import Model.XuLyModel;
import Util.HibernateUtil;

public class ThongKeDAL {
	Session session;

	public ThongKeDAL() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	public ArrayList<ThanhVienModel> getListMember() {
		ArrayList<ThanhVienModel> list;
		session.beginTransaction();
		list = (ArrayList<ThanhVienModel>) session.createQuery("FROM ThanhVienModel", ThanhVienModel.class).list();
		session.getTransaction().commit();
		return list;
	}

	public ArrayList<ThietBiModel> getListDevice() {
		ArrayList<ThietBiModel> list;
		session.beginTransaction();
		list = (ArrayList<ThietBiModel>) session.createQuery("FROM ThietBiModel", ThietBiModel.class).list();
		session.getTransaction().commit();
		return list;
	}

	public ArrayList<ThongTinSdModel> getListInfor() {
		ArrayList<ThongTinSdModel> list;
		session.beginTransaction();
		list = (ArrayList<ThongTinSdModel>) session.createQuery("FROM ThongTinSdModel", ThongTinSdModel.class).list();
		session.getTransaction().commit();
		return list;
	}

	public ArrayList<XuLyModel> getListHandle() {
		ArrayList<XuLyModel> list;
		session.beginTransaction();
		list = (ArrayList<XuLyModel>) session.createQuery("FROM XuLyModel", XuLyModel.class).list();
		session.getTransaction().commit();
		return list;
	}

	
}
