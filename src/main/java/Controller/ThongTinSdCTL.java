package Controller;

import java.util.ArrayList;
import java.util.List;

import DAL.ThongTinSdDAL;
import Model.ThongTinSdModel;

import javax.persistence.Query;

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
	public ThongTinSdModel getModelByMaTVAndMaTB(int matv, int matb) {
        return dal.getModelByMaTVAndMaTB(matv, matb);
    };
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
