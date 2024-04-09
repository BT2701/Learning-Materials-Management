package Controller;

import java.util.ArrayList;

import DAL.XuLyDAL;
import Model.XuLyModel;
import java.util.List;

public class XuLyCTL {
	private XuLyDAL dal;
	public XuLyCTL() {
		dal=new XuLyDAL();
	}
	public List<XuLyModel> getList(){
		return dal.getList();
	}
	public XuLyModel getModel(int id) {
		return dal.getModel(id);
	}
	public String addModel(XuLyModel handle) {
            try{
		dal.addModel(handle);
                return "Thêm thành công !!!";
            }catch(Exception e){
                return e.toString();
            }
	}
        public List<XuLyModel> findByCondition(String type,String condition){
            return dal.findByCondition(type, condition);
        }
	public String updateModel(XuLyModel handle) {
            try{
                dal.updateModel(handle);
                return "Cập nhật thành công!";
            }catch(Exception e){
                return e.toString();
            }
		
	}
        
        public List<XuLyModel> findListByName(String name){
            return dal.getListByName(name);
        }
        
        public String updateTinhTrang(int id,int handle) {
            try{
                dal.updateTinhTrang(id,handle);
                return "Đã cập nhật xử lý vi phạm thành công!";
            }catch(Exception e){
                return e.toString();
            }
        }
        
        public List<XuLyModel> findListByTinhTrang(int con){
            return dal.getListByTinhTrang(con);
        }
        
	public String deleteModel(int id) {
            try{
		XuLyModel x=getModel(id);
		dal.deleteModel(x);
                return "Đã xoá thành công !!!";
            }catch(Exception e){
                return e.toString();
            }
	}
        
public static void main(String[] args){
    XuLyCTL xuly = new XuLyCTL();
    XuLyModel list = xuly.getModel('3');
    System.out.println(list.getSoTien()+", "+list.getThanhVien().getHoTen());
    
}
}
