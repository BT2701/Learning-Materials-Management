package Controller;

import java.util.ArrayList;

import DAL.XuLyDAL;
import Model.XuLyModel;

public class XuLyCTL {
	private XuLyDAL dal;
	public XuLyCTL() {
		dal=new XuLyDAL();
	}
	public ArrayList<XuLyModel> getList(){
		return dal.getList();
	}
	public XuLyModel getModel(int id) {
		return dal.getModel(id);
	}
	public void addModel(XuLyModel handle) {
		dal.addModel(handle);
	}
	public void updateModel(XuLyModel handle) {
		dal.updateModel(handle);
	}
	public void deleteModel(int id) {
		XuLyModel x=getModel(id);
		dal.deleteModel(x);
	}
}
