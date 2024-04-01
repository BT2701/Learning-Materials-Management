package Controller;

import DAL.ThanhVienDAL;
import DAL.ThongKeDAL;
import Model.ThongTinSdModel;
import Model.XuLyModel;

public class ThongKeCTL {
	private ThongKeDAL dal;
	public ThongKeCTL() {
		dal=new ThongKeDAL();
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
		int count=0;
		for (XuLyModel model : dal.getListHandle()) {
			if(model.getSoTien()!=null) {
				count+=model.getSoTien();
			}
		}
		return count;
	}
	
}
