package Controller;

import java.util.ArrayList;

import DAL.ThanhVienDAL;
import Model.ThanhVienModel;

public class ThanhVienCTL {
	private ThanhVienDAL memDAL;
	public ThanhVienCTL() {
		memDAL=new ThanhVienDAL();
	}
	public ArrayList<ThanhVienModel> getListMembers(){
		return memDAL.getListMembers();
	}
}
