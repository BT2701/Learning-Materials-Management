package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "thanhvien")
public class ThanhVienModel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaTV")
	private Integer maTV;
	
	@Column(name = "HoTen")	
	private String hoTen;
	
	@Column(name = "Khoa")
	private String khoa;
	
	@Column(name = "Ngành")
	private String nganh;
	
	@Column(name = "SDT")
	private Integer sdt;
	
	
	public ThanhVienModel() {
	}


	public ThanhVienModel(Integer maTV, String hoTen, String khoa, String nganh, Integer sdt) {
		this.maTV = maTV;
		this.hoTen = hoTen;
		this.khoa = khoa;
		this.nganh = nganh;
		this.sdt = sdt;
	}


	public Integer getMaTV() {
		return maTV;
	}


	public void setMaTV(Integer maTV) {
		this.maTV = maTV;
	}


	public String getHoTen() {
		return hoTen;
	}


	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}


	public String getKhoa() {
		return khoa;
	}


	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}


	public String getNganh() {
		return nganh;
	}


	public void setNganh(String nganh) {
		this.nganh = nganh;
	}


	public Integer getSdt() {
		return sdt;
	}


	public void setSdt(Integer sdt) {
		this.sdt = sdt;
	}
	
	
	
}
