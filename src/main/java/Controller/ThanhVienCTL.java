package Controller;

import java.util.ArrayList;

import DAL.ThanhVienDAL;
import Model.ThanhVienModel;

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
	public void updateModel(ThanhVienModel member) {
		dal.updateModel(member);
	}
	public void deleteModel(int id) {
		ThanhVienModel x=getModel(id);
		dal.deleteModel(x);
	}
	
}
