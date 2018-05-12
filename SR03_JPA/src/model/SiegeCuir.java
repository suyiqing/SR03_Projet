package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SiegeCuir database table.
 * 
 */
@Entity
@NamedQuery(name="SiegeCuir.findAll", query="SELECT s FROM SiegeCuir s")
public class SiegeCuir implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idSiegeCuir;

	private int prix;

	@Column(name="siege_cuir")
	private byte siegeCuir;

	//bi-directional many-to-one association to Finition
	@ManyToOne
	@JoinColumn(name="finition")
	private Finition finitionBean;

	public SiegeCuir() {
	}

	public int getIdSiegeCuir() {
		return this.idSiegeCuir;
	}

	public void setIdSiegeCuir(int idSiegeCuir) {
		this.idSiegeCuir = idSiegeCuir;
	}

	public int getPrix() {
		return this.prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public byte getSiegeCuir() {
		return this.siegeCuir;
	}

	public void setSiegeCuir(byte siegeCuir) {
		this.siegeCuir = siegeCuir;
	}

	public Finition getFinitionBean() {
		return this.finitionBean;
	}

	public void setFinitionBean(Finition finitionBean) {
		this.finitionBean = finitionBean;
	}

}