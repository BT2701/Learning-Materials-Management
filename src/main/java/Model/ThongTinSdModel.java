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
@Table(name = "thongtinsd")
public class ThongTinSdModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaTT")
	private Integer maTT;

	@Column(name = "MaTV")
	private Integer maTV;

	@Column(name = "MaTB")
	private Integer maTB;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TGVao")
	private Date tgVao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TGMuon")
	private Date tgMuon;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TGTra")
	private Date tgTra;

	public ThongTinSdModel() {
	}

	public ThongTinSdModel(Integer maTT, Integer maTV, Integer maTB, Date tgVao, Date tgMuon, Date tgTra) {
		this.maTT = maTT;
		this.maTV = maTV;
		this.maTB = maTB;
		this.tgVao = tgVao;
		this.tgMuon = tgMuon;
		this.tgTra = tgTra;
	}

	public Integer getMaTT() {
		return maTT;
	}

	public void setMaTT(Integer maTT) {
		this.maTT = maTT;
	}

	public Integer getMaTV() {
		return maTV;
	}

	public void setMaTV(Integer maTV) {
		this.maTV = maTV;
	}

	public Integer getMaTB() {
		return maTB;
	}

	public void setMaTB(Integer maTB) {
		this.maTB = maTB;
	}

	public Date getTgVao() {
		return tgVao;
	}

	public void setTgVao(Date tgVao) {
		this.tgVao = tgVao;
	}

	public Date getTgMuon() {
		return tgMuon;
	}

	public void setTgMuon(Date tgMuon) {
		this.tgMuon = tgMuon;
	}

	public Date getTgTra() {
		return tgTra;
	}

	public void setTgTra(Date tgTra) {
		this.tgTra = tgTra;
	}

}
