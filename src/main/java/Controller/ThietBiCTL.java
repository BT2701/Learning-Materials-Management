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
	public void addModel(ThietBiModel device) {
		dal.addModel(device);
	}
	public void updateModel(ThietBiModel device) {
		dal.updateModel(device);
	}
	public void deleteModel(int id) {
		ThietBiModel x=getModel(id);
		dal.deleteModel(x);
	}
}
