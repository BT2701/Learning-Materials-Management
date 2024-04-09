package DAL;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Model.ThanhVienModel;
import javax.persistence.Query;
import org.apache.poi.ss.usermodel.*;
import Util.HibernateUtil;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class ThanhVienDAL {
	Session session;
	private SessionFactory factory= new Configuration().configure().buildSessionFactory();
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
	public ArrayList<ThanhVienModel> getListForUpdateMethod() {
		// vì khi update thì dữ liệu kh thay đổi về size() nên nếu dùng chung 1 session thì sẽ không được gọi lại vì dữ liệu cũ đã được cache trong bộ nhớ của hibernate
		ArrayList<ThanhVienModel> list;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();

			Query query = session.createQuery("FROM ThanhVienModel", ThanhVienModel.class);

			list = (ArrayList<ThanhVienModel>) query.getResultList();

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			list = new ArrayList<>();
		} finally {
			session.close();
		}

		// Trả về danh sách thành viên
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
	public void updateModel(ThanhVienModel updatedThanhVien) {
		session.beginTransaction();
		ThanhVienModel oldThanhVien =  session.get(ThanhVienModel.class, updatedThanhVien.getMaTV());
		oldThanhVien.setHoTen(updatedThanhVien.getHoTen());
		oldThanhVien.setKhoa(updatedThanhVien.getKhoa());
		oldThanhVien.setNganh(updatedThanhVien.getNganh());
		oldThanhVien.setSdt(updatedThanhVien.getSdt());
		session.update(oldThanhVien);
		session.getTransaction().commit();
	}
	public void deleteModel(ThanhVienModel member) {
		session.beginTransaction();
		session.delete(member);
		session.getTransaction().commit();
	}

	public void deleteMultipleModelByCondition(String condition) {
		session.beginTransaction();
		String hql = "DELETE FROM ThanhVienModel WHERE " + condition;
		Query query = session.createQuery(hql);
		query.executeUpdate();
		session.getTransaction().commit();
	}

	public void addModelFromFileExcel(Sheet sheet) {
		// Đọc dữ liệu từ Excel và thêm thành viên
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row currentRow = sheet.getRow(i);
			if (currentRow != null) {
				int id = (int) currentRow.getCell(0).getNumericCellValue();
				String hoTen = getCellValueAsString(currentRow.getCell(1));
				String khoa = getCellValueAsString(currentRow.getCell(2));
				String nganh = getCellValueAsString(currentRow.getCell(3));
				String sdt = getCellValueAsString(currentRow.getCell(4));
				String email = getCellValueAsString(currentRow.getCell(5));
				String password = getCellValueAsString(currentRow.getCell(6));
				ThanhVienModel newThanhVien = new ThanhVienModel(id, hoTen, khoa, nganh, sdt, email, password);
				this.addModel(newThanhVien);
			}
		}
	}

	private String getCellValueAsString(Cell cell) {
		if (cell == null) {
			return null;
		}
		switch (cell.getCellType()) {
			case STRING:
				return cell.getStringCellValue();
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					return df.format(cell.getDateCellValue());
				} else {
					return String.valueOf((int) cell.getNumericCellValue());
				}
			case BOOLEAN:
				return String.valueOf(cell.getBooleanCellValue());
			case FORMULA:
				return cell.getCellFormula();
			default:
				return null;
		}
	}
	public Integer login(String username, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        ThanhVienModel userByEmail = session.createQuery("FROM ThanhVienModel WHERE email = :username AND password = :password", ThanhVienModel.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .uniqueResult();
        if (userByEmail != null) {
            session.getTransaction().commit();
            session.close();
            return userByEmail.getMaTV(); // Trả về maTV nếu đăng nhập thành công
        }

        // Thử tìm bằng mã thành viên nếu username là một số nguyên hợp lệ
        try {
            int maTV = Integer.parseInt(username);
            ThanhVienModel userByMaTV = session.createQuery("FROM ThanhVienModel WHERE maTV = :maTV AND password = :password", ThanhVienModel.class)
                    .setParameter("maTV", maTV)
                    .setParameter("password", password)
                    .uniqueResult();

            session.getTransaction().commit();
            session.close();

            if (userByMaTV != null) {
                return userByMaTV.getMaTV(); // Trả về maTV nếu đăng nhập thành công
            }
        } catch (NumberFormatException e) {
            // Nếu username không phải là một số nguyên hợp lệ, tiếp tục tìm bằng email
        }

        session.getTransaction().commit();
        session.close();
        return null; // Trả về null nếu không đăng nhập thành công
    }
	public ThanhVienModel getModelByName(String name) {
        ThanhVienModel result = new ThanhVienModel();
        try(Session session = factory.openSession()){
            session.beginTransaction();
            String hql = "FROM ThanhVienModel WHERE HoTen = :name";
            org.hibernate.Query<ThanhVienModel> query = session.createQuery(hql, ThanhVienModel.class);
            query.setParameter("name", name);
            result = query.uniqueResult();
            session.getTransaction().commit();
        }catch (HibernateException e){
            e.printStackTrace();
        } 
        return result;
}

}
