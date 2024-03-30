package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "thietbi")
public class ThietBiModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaTB")
	private Integer maTB;
	@Column(name = "TenTB")
	private String tenTB;
	@Column(name = "MoTaTB")
	private String moTaTB;

	public ThietBiModel() {
	}

	public ThietBiModel(Integer maTB, String tenTB, String moTaTB) {
		this.maTB = maTB;
		this.tenTB = tenTB;
		this.moTaTB = moTaTB;
	}

	public Integer getMaTB() {
		return maTB;
	}

	public void setMaTB(Integer maTB) {
		this.maTB = maTB;
	}

	public String getTenTB() {
		return tenTB;
	}

	public void setTenTB(String tenTB) {
		this.tenTB = tenTB;
	}

	public String getMoTaTB() {
		return moTaTB;
	}

	public void setMoTaTB(String moTaTB) {
		this.moTaTB = moTaTB;
	}

}
