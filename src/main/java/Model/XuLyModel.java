package Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "xuly")
public class XuLyModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaXL")
	private Integer maXL;

	@Column(name = "MaTv")
	private Integer maTV;

	@Column(name = "HinhThucXL")
	private String hinhThucXL;

	@Column(name = "SoTien")
	private Integer soTien;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "NgayXL")
	private Date ngayXL;

	@Column(name = "TrangThaiXL")
	private Integer trangThaiXL;

	public XuLyModel() {
	}

	public XuLyModel(Integer maXL, Integer maTV, String hinhThucXL, Integer soTien, Date ngayXL, Integer trangThaiXL) {
		this.maXL = maXL;
		this.maTV = maTV;
		this.hinhThucXL = hinhThucXL;
		this.soTien = soTien;
		this.ngayXL = ngayXL;
		this.trangThaiXL = trangThaiXL;
	}

	public Integer getMaXL() {
		return maXL;
	}

	public void setMaXL(Integer maXL) {
		this.maXL = maXL;
	}

	public Integer getMaTV() {
		return maTV;
	}

	public void setMaTV(Integer maTV) {
		this.maTV = maTV;
	}

	public String getHinhThucXL() {
		return hinhThucXL;
	}

	public void setHinhThucXL(String hinhThucXL) {
		this.hinhThucXL = hinhThucXL;
	}

	public Integer getSoTien() {
		return soTien;
	}

	public void setSoTien(Integer soTien) {
		this.soTien = soTien;
	}

	public Date getNgayXL() {
		return ngayXL;
	}

	public void setNgayXL(Date ngayXL) {
		this.ngayXL = ngayXL;
	}

	public Integer getTrangThaiXL() {
		return trangThaiXL;
	}

	public void setTrangThaiXL(Integer trangThaiXL) {
		this.trangThaiXL = trangThaiXL;
	}

}
