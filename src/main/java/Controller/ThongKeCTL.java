package Controller;

import java.util.Date;

import DAL.ThanhVienDAL;
import DAL.ThongKeDAL;
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
				if (from.before(model.getNgayXL()) && to.after(model.getNgayXL())) {
					count++;
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
				if (from.before(model.getNgayXL()) && to.after(model.getNgayXL())) {
					count++;
				}
			}
		}
		return count;
	}

//	count violation
	public int countViolationOverTime(Date from, Date to) {
		int count = 0;
		for (XuLyModel model : dal.getListHandle()) {

			if (from.before(model.getNgayXL()) && to.after(model.getNgayXL())) {
				count++;
			}

		}
		return count;
	}

//	count fee
	public int countFeeOverTime(Date from, Date to) {
		int count = 0;
		for (XuLyModel model : dal.getListHandle()) {
			if (model.getSoTien() != null) {
				if (from.before(model.getNgayXL()) && to.after(model.getNgayXL())) {
					count += model.getSoTien();
				}
			}
		}
		return count;
	}

}
