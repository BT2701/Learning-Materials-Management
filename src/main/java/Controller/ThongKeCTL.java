package Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import DAL.ThanhVienDAL;
import DAL.ThongKeDAL;
import Model.ThanhVienModel;
import Model.ThongTinSdModel;
import Model.XuLyModel;

public class ThongKeCTL {
	private ThongKeDAL dal;

	public ThongKeCTL() {
		dal = new ThongKeDAL();
	}

//	Data processing

//	count member into learning material center
	public int countMemberIntoMaterial() {
		int count = 0;
		for (ThongTinSdModel model : dal.getListInfor()) {
			if (model.getTgVao() != null) {
				count++;
			}
		}
		return count;
	}

//	count borrowed device
	public int countBorrowedDevice() {
		int count = 0;
		for (ThongTinSdModel model : dal.getListInfor()) {
			if (model.getTgMuon() != null) {
				count++;
			}
		}
		return count;
	}

//	count borrowing device
	public int countBorrowingDevice() {
		int count = 0;
		for (ThongTinSdModel model : dal.getListInfor()) {
			if (model.getTgMuon() != null && model.getTgTra() == null) {
				count++;
			}
		}
		return count;
	}

//	count handled violation
	public int countHandledViolation() {
		int count = 0;
		for (XuLyModel model : dal.getListHandle()) {
			if (model.getTrangThaiXL() == 0) {
				count++;
			}
		}
		return count;
	}

//	count handled violation
	public int countHandlingViolation() {
		int count = 0;
		for (XuLyModel model : dal.getListHandle()) {
			if (model.getTrangThaiXL() != 0) {
				count++;
			}
		}
		return count;
	}

//	count violation
	public int countViolation() {
		int count = 0;
		for (XuLyModel model : dal.getListHandle()) {

			count++;

		}
		return count;
	}

//	count fee
	public int countFee() {
		int count = 0;
		for (XuLyModel model : dal.getListHandle()) {
			if (model.getSoTien() != null) {
				count += model.getSoTien();
			}
		}
		return count;
	}

//	OVERTIME
	public int countIntoMaterialOverTime(Date from, Date to) {
		int count = 0;
		for (ThongTinSdModel model : dal.getListInfor()) {
			if (model.getTgVao() != null) {
				if (from.before(model.getTgVao()) && to.after(model.getTgVao())) {
					count++;
				}
			}
		}
		return count;
	}

	public int countBorrowedDeviceOverTime(Date from, Date to) {
		int count = 0;
		for (ThongTinSdModel model : dal.getListInfor()) {
			if (model.getTgMuon() != null) {
				if (from.before(model.getTgMuon()) && to.after(model.getTgMuon())) {
					count++;
				}
			}
		}
		return count;
	}

//	count borrowing device
	public int countBorrowingDeviceOverTime(Date from, Date to) {
		int count = 0;
		for (ThongTinSdModel model : dal.getListInfor()) {
			if (model.getTgMuon() != null && model.getTgTra() == null) {
				if (from.before(model.getTgMuon()) && to.after(model.getTgMuon())) {
					count++;
				}
			}
		}
		return count;
	}

//	count handled violation
	public int countHandledViolationOverTime(Date from, Date to) {
		int count = 0;
		for (XuLyModel model : dal.getListHandle()) {
			if (model.getTrangThaiXL() == 0) {
				if (model.getNgayXL() != null) {
					if (from.before(model.getNgayXL()) && to.after(model.getNgayXL())) {
						count++;
					}
				}
			}
		}
		return count;
	}

//	count handled violation
	public int countHandlingViolationOverTime(Date from, Date to) {
		int count = 0;
		for (XuLyModel model : dal.getListHandle()) {
			if (model.getTrangThaiXL() != 0) {
				if (model.getNgayXL() != null) {
					if (from.before(model.getNgayXL()) && to.after(model.getNgayXL())) {
						count++;
					}
				}
			}
		}
		return count;
	}

//	count violation
	public int countViolationOverTime(Date from, Date to) {
		int count = 0;
		for (XuLyModel model : dal.getListHandle()) {

			if (model.getNgayXL() != null) {
				if (from.before(model.getNgayXL()) && to.after(model.getNgayXL())) {
					count++;
				}
			}

		}
		return count;
	}

//	count fee
	public int countFeeOverTime(Date from, Date to) {
		int count = 0;
		for (XuLyModel model : dal.getListHandle()) {
			if (model.getSoTien() != null) {
				if (model.getNgayXL() != null) {
					if (from.before(model.getNgayXL()) && to.after(model.getNgayXL())) {
						count += model.getSoTien();
					}
				}
			}
		}
		return count;
	}

//	biểu đồ thống kê số lượng sinh viên ra vào khu tự học
	public ArrayList<Integer> listCountTime(int year) {
		ArrayList<Integer> list = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < 12; i++) {
			for (ThongTinSdModel model : dal.getListInfor()) {
				if (model.getTgVao() != null) {
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(model.getTgVao());
					if ((calendar.get(Calendar.MONTH) + 1) == (i + 1) && calendar.get(Calendar.YEAR) == year) {
						count++;
					}
				}
			}
			list.add(count);
			count = 0;
		}

		return list;
	}
//	end

//	biểu đồ thống kê lượng sinh viên thuộc các khoa
	public ArrayList<Integer> listCountDeparment() {
		ArrayList<Integer> list = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < listDeparment().size(); i++) {
			for (ThongTinSdModel model : dal.getListInfor()) {
				if (model.getTgVao() != null
						&& model.getThanhVien().getKhoa().equalsIgnoreCase(listDeparment().get(i))) {
					count++;
				}
			}
			list.add(count);
			count = 0;
		}

		return list;
	}

	public ArrayList<String> listDeparment() {
		ArrayList<String> list = new ArrayList<>();
		for (ThanhVienModel mem : dal.getListMember()) {
			list.add(mem.getKhoa());
		}
		Set<String> set = new HashSet<>();
		set.addAll(list);
		list = new ArrayList<>(set);
		return list;
	}

//	end

//	biểu đồ thống kê lượng sinh viên thuộc các ngành
	public ArrayList<Integer> listCountBranch() {
		ArrayList<Integer> list = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < listBranch().size(); i++) {
			for (ThongTinSdModel model : dal.getListInfor()) {
				if (model.getTgVao() != null && model.getThanhVien().getNganh().equalsIgnoreCase(listBranch().get(i))) {
					count++;
				}
			}
			list.add(count);
			count = 0;
		}

		return list;
	}

	public ArrayList<String> listBranch() {
		ArrayList<String> list = new ArrayList<>();
		for (ThanhVienModel mem : dal.getListMember()) {
			list.add(mem.getNganh());
		}
		Set<String> set = new HashSet<>();
		set.addAll(list);
		list = new ArrayList<>(set);
		return list;
	}

//	end
//	biểu đồ thống kê lượng thiết bị đã được mượn
	public ArrayList<Integer> listCountDevice(int year, int month) {
		ArrayList<Integer> list = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < listDevice().size(); i++) {
			for (ThongTinSdModel model : dal.getListInfor()) {
				if(model.getTgMuon()!=null) {
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(model.getTgMuon());
					if(calendar.get(Calendar.YEAR)  == year &&(calendar.get(Calendar.MONTH) + 1) == month && model.getThietBi().getTenTB().equalsIgnoreCase(listDevice().get(i))) {
						count++;
					}
				}
			}
			list.add(count);
			count = 0;
		}

		return list;
	}

	public ArrayList<String> listDevice() {
		ArrayList<String> list = new ArrayList<>();
		for (ThongTinSdModel info : dal.getListInfor()) {
			if(info.getThietBi()!=null) {
				list.add(info.getThietBi().getTenTB());
			}
		}
		Set<String> set = new HashSet<>();
		set.addAll(list);
		list = new ArrayList<>(set);
		return list;
	}

//	end
	
//	biểu đồ thống kê lượng thiết bị đang được mượn
	public ArrayList<Integer> listCountCurrent(int year, int month) {
		ArrayList<Integer> list = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < listDevice().size(); i++) {
			for (ThongTinSdModel model : dal.getListInfor()) {
				if(model.getTgMuon()!=null) {
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(model.getTgMuon());
					if(model.getTgTra()==null &&calendar.get(Calendar.YEAR)  == year &&(calendar.get(Calendar.MONTH) + 1) == month && model.getThietBi().getTenTB().equalsIgnoreCase(listDevice().get(i))) {
						count++;
					}
				}
			}
			list.add(count);
			count = 0;
		}

		return list;
	}
//	end
	
//	biểu đồ thống kê xử lý vi phạm
	public ArrayList<Integer> listCountHandle(int year, int month) {
		ArrayList<Integer> list = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < listHandle().size(); i++) {
			for (XuLyModel model : dal.getListHandle()) {
				if(model.getNgayXL()!=null) {
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(model.getNgayXL());
					if(calendar.get(Calendar.YEAR)  == year &&(calendar.get(Calendar.MONTH) + 1) == month  && model.getHinhThucXL().equalsIgnoreCase(listHandle().get(i))) {
						count++;
					}
				}
			}
			list.add(count);
			count = 0;
		}

		return list;
	}

	public ArrayList<String> listHandle() {
		ArrayList<String> list = new ArrayList<>();
		for (XuLyModel handle : dal.getListHandle()) {
			list.add(handle.getHinhThucXL());
		}
		Set<String> set = new HashSet<>();
		set.addAll(list);
		list = new ArrayList<>(set);
		return list;
	}

//	end
}
