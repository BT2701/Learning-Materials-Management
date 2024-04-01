package Controller;

import java.util.ArrayList;

import DAL.ThongTinSdDAL;
import Model.ThongTinSdModel;

public class ThongTinSdCTL {
	private ThongTinSdDAL dal;
	public ThongTinSdCTL() {
		dal=new ThongTinSdDAL();
	}
	public ArrayList<ThongTinSdModel> getList(){
		return dal.getList();
	}
	public ThongTinSdModel getModel(int id) {
		return dal.getModel(id);
	}
	public void addModel(ThongTinSdModel infor) {
		dal.addModel(infor);
	}
	public void updateModel(ThongTinSdModel infor) {
		dal.updateModel(infor);
	}
	public void deleteModel(int id) {
		ThongTinSdModel x=getModel(id);
		dal.deleteModel(x);
	}
}
