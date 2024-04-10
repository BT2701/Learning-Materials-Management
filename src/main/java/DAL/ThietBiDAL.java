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
		list = (ArrayList<ThietBiModel>) session.createQuery("FROM ThietBiModel",ThietBiModel.class).list();
		session.getTransaction().commit();
		return list;
	}
        
	public ThietBiModel getModel(int id) {
		session.beginTransaction();
		ThietBiModel thongtin= session.get(ThietBiModel.class, id);
		session.getTransaction().commit();
		return thongtin;
	}
        
	public boolean addModel(ThietBiModel device) {
            try {
                session.beginTransaction();
                session.save(device);
                session.getTransaction().commit();
                return true; // Trả về true khi thêm thành công
            } catch (Exception ex) {
                return false; // Trả về false khi có lỗi
            }
        }

	public boolean updateModel(ThietBiModel device) {
            try {
                session.beginTransaction();
		session.update(device);
		session.getTransaction().commit();
                return true; // Trả về true khi thêm thành công
            } catch (Exception ex) {
                return false; // Trả về false khi có lỗi
            }
		
	}
        
	public boolean deleteModel(ThietBiModel device) {            
            try {
                session.beginTransaction();
		session.delete(device);
		session.getTransaction().commit();
                return true; // Trả về true khi thêm thành công
            } catch (Exception ex) {
                return false; // Trả về false khi có lỗi
            }
	}
        
        public boolean addListModel(ArrayList<ThietBiModel> list) {
            try {
                for(ThietBiModel device: list) {
                    session.beginTransaction();
                    session.save(device);
                    session.getTransaction().commit();
                }
                return true; // Trả về true khi thêm thành công
            } catch (Exception ex) {
                return false; // Trả về false khi có lỗi
            }
        }
        
        public boolean deleteListModel(ArrayList<ThietBiModel> list) {
            try {
                for(ThietBiModel device: list) {
                    session.beginTransaction();
                    session.delete(device);
                    session.getTransaction().commit();
                }
                return true; // Trả về true khi thêm thành công
            } catch (Exception ex) {
                return false; // Trả về false khi có lỗi
            }
        }
        
}
