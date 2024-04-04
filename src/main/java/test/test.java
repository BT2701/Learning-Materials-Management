package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Controller.ThanhVienCTL;
import Controller.ThongKeCTL;
import Model.ThanhVienModel;
import Model.XuLyModel;
import Util.HibernateUtil;

import java.util.Date;
import java.util.Scanner;

public class test {
	static ThanhVienCTL mem= new ThanhVienCTL();
	static ThongKeCTL tk= new ThongKeCTL();
	static Scanner sc= new Scanner(System.in);
    public static void main(String[] args) {
    	for (Integer a : tk.listCountTime(2024)) {
			System.out.println(a);
		}
    	System.out.println("KHOA");
    	for (String string : tk.listDeparment()) {
			System.out.println(string);
		}
    	for (Integer a : tk.listCountDeparment()) {
			System.out.println(a);
		}
    	
    	System.out.println("NGÀNH");
    	for (String string : tk.listBranch()) {
			System.out.println(string);
		}
    	for (Integer a : tk.listCountBranch()) {
			System.out.println(a);
		}
    	
//        while (true) {
//        	System.out.println("1. thêm thành viên");
//        	System.out.println("2. xóa thành viên");
//        	System.out.println("3. sửa thành viên");
//        	System.out.println("4. xem danh sách thành viên");
//        	System.out.println("0. thoát");
//        	System.out.println("Nhập lựa chọn: ");
//        	int choose=Integer.parseInt(sc.nextLine());
//        	if(choose==1) {
//        		insertMember();
//        	}
//        	else if(choose==2) {
//        		deletemMember();
//        	}
//        	else if(choose==3) {
//        		updateMember();
//        	}
//        	else if(choose==4) {
//        		showList();
//        	}
//        	else {
//        		break;
//        	}
//        	
//        }
    }
    public static void insertMember() {
    	ThanhVienModel member= new ThanhVienModel();
    	member.setMaTV(1);
    	System.out.println("họ và tên: ");
    	member.setHoTen(sc.nextLine());
    	System.out.println("khoa: ");
    	member.setKhoa(sc.nextLine());
    	System.out.println("ngành: ");
    	member.setNganh(sc.nextLine());
    	System.out.println("sdt: ");
    	member.setSdt(sc.nextLine());
    	System.out.println("email: ");
    	member.setEmail(sc.nextLine());
    	System.out.println("password: ");
    	member.setPassword(sc.nextLine());
    	mem.addModel(member);
    }
    public static void deletemMember() {
    	System.out.println("id: ");
    	int id=Integer.parseInt(sc.nextLine());
    	mem.deleteModel(id);
    }
    public static void updateMember() {
    	ThanhVienModel member= new ThanhVienModel();
    	member.setMaTV(1);
    	System.out.println("họ và tên: ");
    	member.setHoTen(sc.nextLine());
    	System.out.println("khoa: ");
    	member.setKhoa(sc.nextLine());
    	System.out.println("ngành: ");
    	member.setNganh(sc.nextLine());
    	System.out.println("sdt: ");
    	member.setSdt(sc.nextLine());
    	System.out.println("email: ");
    	member.setEmail(sc.nextLine());
    	System.out.println("password: ");
    	member.setPassword(sc.nextLine());
    	mem.updateModel(member);
    }
    public static void showList() {
    	for (ThanhVienModel m : mem.getList()) {
			System.out.println(m);
		}
    }
}
