package Controller;

import java.util.ArrayList;

import DAL.ThietBiDAL;
import Model.ThietBiModel;

public class ThietBiCTL {
	private ThietBiDAL dal;
	public ThietBiCTL() {
		dal=new ThietBiDAL();
	}
	public ArrayList<ThietBiModel> getList(){
		return dal.getList();
	}
	public ThietBiModel getModel(int id) {
		return dal.getModel(id);
	}
	public String addModel(ThietBiModel device) {
            if(dal.addModel(device)) {
                return "Thêm thành công";
            } else return "Thêm thất bại";
	}
	public String updateModel(ThietBiModel device) {
            if(dal.updateModel(device)) {
                return "Sửa thành công";
            } else return "Sửa thất bại";
	}
	public String deleteModel(int id) {
            ThietBiModel x = getModel(id);
            if(dal.deleteModel(x)) {
                  return "Xóa thành công";
            } else return "Xóa thất bại";
	}
        
        public int getNewestID() {
            ArrayList<ThietBiModel> list = dal.getList();
            int len = list.size();
            int id = list.get(len - 1).getMaTB();
            return id + 1;
        }
        
        public String addListModel(ArrayList<ThietBiModel> list) {
            for(ThietBiModel thietBiModel: list) {
                if(dal.getModel(thietBiModel.getMaTB()) != null) {
                    return "Đã có mã thiết bị " + thietBiModel.getMaTB() + " trong dữ liệu";
                }
            }
            
            if(dal.addListModel(list)) {
                return "Thêm danh sách thành công";
            } else return "Thêm danh sách thất bại";
            
        }
        
        public String deleteListModel(ArrayList<ThietBiModel> list) {
            if(dal.deleteListModel(list)) {
                return "Xóa thành công";
            } else return "Xóa thất bại";           
        }
}
