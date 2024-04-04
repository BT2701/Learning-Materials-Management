package DAL;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.hibernate.Session;

import Model.ThanhVienModel;
import javax.persistence.Query;
import org.apache.poi.ss.usermodel.*;
import Util.HibernateUtil;
import org.hibernate.Transaction;

import javax.persistence.Query;

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

}
