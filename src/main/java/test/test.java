package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Controller.ThanhVienCTL;
import Model.ThanhVienModel;
import Model.XuLyModel;
import Util.HibernateUtil;

import java.util.Date;

public class test {
    public static void main(String[] args) {
        ThanhVienCTL mem= new ThanhVienCTL();
        for (ThanhVienModel m : mem.getList()) {
			System.out.println(m);
		}
    }
}
