package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import DAL.ThanhVienDAL;
import Model.ThanhVienModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ThanhVienCTL {
	private ThanhVienDAL dal;
	public ThanhVienCTL() {
		dal=new ThanhVienDAL();
	}
	public ArrayList<ThanhVienModel> getList(){
		return dal.getList();
	}
	public ThanhVienModel getModel(int id) {
		return dal.getModel(id);
	}
	public void addModel(ThanhVienModel member) {
		dal.addModel(member);
	}
	public void updateModel(ThanhVienModel updatedThanhVien) {
		dal.updateModel(updatedThanhVien);
	}
	public ArrayList<ThanhVienModel> getListForUpdateMethod() {
		return dal.getListForUpdateMethod();
	}
	public void deleteModel(int id) {
		ThanhVienModel x=getModel(id);
		dal.deleteModel(x);
	}
	public void deleteMultipleModelByCondition(String condition) {
		dal.deleteMultipleModelByCondition(condition);
	}

	public String addModelFromFileExcel(String filePath) {
		try {
			FileInputStream excelFile = new FileInputStream(new File(filePath));
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet sheet = workbook.getSheetAt(0);

			// Kiểm tra định dạng của tệp Excel
			if (isExcelFormatValid(sheet)) {
				dal.addModelFromFileExcel(sheet);
				workbook.close();
				return "Thêm thành viên từ file Excel thành công.";
			} else {
				workbook.close();
				return "Định dạng của tệp Excel không đúng.";
			}
		} catch (IOException e) {
			e.printStackTrace();
			return "Định dạng của tệp Excel không đúng.";
		}
	}

	private boolean isExcelFormatValid(Sheet sheet) {
		// Kiểm tra số cột của dòng đầu tiên (header) có đúng định dạng không
		Row headerRow = sheet.getRow(0);
		int expectedColumnCount = 7; // Số cột mong muốn
		if (headerRow == null || headerRow.getLastCellNum() != expectedColumnCount) {
			return false;
		}

		// Kiểm tra tên các cột có đúng định dạng không
		String[] expectedColumnNames = {"MaTV", "Ho Ten", "Khoa", "Nganh", "SDT", "email", "password"};
		for (int i = 0; i < expectedColumnCount; i++) {
			Cell cell = headerRow.getCell(i);
			if (cell == null || !cell.getStringCellValue().equals(expectedColumnNames[i])) {
				return false;
			}
		}

		return true;
	}
	public Integer login(String username, String password) {
        return dal.login(username, password);
    }
	public ThanhVienModel getModelByName(String name) {
		return dal.getModelByName(name);
	}

}
