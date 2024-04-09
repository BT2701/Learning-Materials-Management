package DAL;

import Model.ThanhVienModel;
import java.util.ArrayList;

import org.hibernate.Session;

import Model.XuLyModel;
import Util.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class XuLyDAL {
	private SessionFactory factory;

	public XuLyDAL() {
		factory = new Configuration().configure().buildSessionFactory();
	}

	public List<XuLyModel> getList() {
		List<XuLyModel> list = new ArrayList();
		try (Session session = factory.openSession()) {
			session.beginTransaction();
			list = (ArrayList<XuLyModel>) session.createQuery("FROM XuLyModel", XuLyModel.class).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public XuLyModel getModel(int id) {
		XuLyModel result = new XuLyModel();
		try (Session session = factory.openSession()) {
			session.beginTransaction();
			result = session.get(XuLyModel.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void addModel(XuLyModel handle) {
		try (Session session = factory.openSession()) {
			if (handle.getSoTien() == 0)
				handle.setSoTien(null);
			session.beginTransaction();
			handle.setNgayXL(null);
			session.save(handle);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateModel(XuLyModel handle) {
		try (Session session = factory.openSession()) {
			if (handle.getSoTien() == 0)
				handle.setSoTien(null);
			session.beginTransaction();
			session.update(handle);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<XuLyModel> findByCondition(String type, String condition) {
		List<XuLyModel> result = new ArrayList();
		try (Session session = factory.openSession()) {
			session.beginTransaction();
			String hql = "FROM XuLyModel WHERE " + type + " like CONCAT('%', :name, '%')";
			Query<XuLyModel> query = session.createQuery(hql, XuLyModel.class);
			query.setParameter("name", condition);
			result = query.getResultList();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<XuLyModel> getListByName(String name) {
		List<XuLyModel> results = new ArrayList();
		try (Session session = factory.openSession()) {
			session.beginTransaction();
			String hql = "SELECT xl " + "FROM XuLyModel xl " + "JOIN xl.thanhVien tv " + "WHERE tv.hoTen LIKE :pattern";
			Query<XuLyModel> query = session.createQuery(hql, XuLyModel.class);
			query.setParameter("pattern", "%" + name + "%");
			results = query.getResultList();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return results;
	}

	public List<XuLyModel> getListByTinhTrang(int con) {
		List<XuLyModel> result = new ArrayList();
		try (Session session = factory.openSession()) {
			session.beginTransaction();
			String hql = "FROM XuLyModel WHERE TrangThaiXL = :name";
			Query<XuLyModel> query = session.createQuery(hql, XuLyModel.class);
			query.setParameter("name", con);
			result = query.getResultList();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return result;
	}

	public void updateTinhTrang(int id, int handle) {
		List<XuLyModel> results = new ArrayList<>();
		try (Session session = factory.openSession()) {
			session.beginTransaction();
			java.util.Date now = new Date();
			XuLyModel xuly = session.get(XuLyModel.class, id);
			if (xuly != null && xuly.getTrangThaiXL() == 0) {
				xuly.setTrangThaiXL(handle);
				xuly.setNgayXL(now);
				session.update(xuly);
				session.getTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteModel(XuLyModel handle) {
		try (Session session = factory.openSession()) {
			session.beginTransaction();
			session.delete(handle);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
