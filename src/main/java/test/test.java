package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Model.XuLyModel;
import Util.HibernateUtil;

import java.util.Date;

public class test {
    public static void main(String[] args) {
        // Tạo phiên làm việc từ SessionFactory
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        // Tạo một đối tượng XuLyModel mới
        XuLyModel xuLyModel = new XuLyModel();
        xuLyModel.setMaTV(1120150184); // Đặt giá trị cho các trường
        xuLyModel.setHinhThucXL("Hủy thẻ");
        xuLyModel.setNgayXL(new Date());
        xuLyModel.setTrangThaiXL(1);

        // Bắt đầu giao dịch
        Transaction transaction = session.beginTransaction();

        try {
            // Lưu đối tượng xuLyModel vào cơ sở dữ liệu
            session.save(xuLyModel);

            // Commit giao dịch
            transaction.commit();
            System.out.println("Đã thêm dòng mới vào cơ sở dữ liệu thành công.");
        } catch (Exception e) {
            // Nếu xảy ra lỗi, rollback giao dịch
            transaction.rollback();
            e.printStackTrace();
            System.out.println("Thêm dòng mới vào cơ sở dữ liệu thất bại.");
        } finally {
            // Đóng phiên làm việc
            session.close();
            HibernateUtil.shutdown();
        }
    }
}
