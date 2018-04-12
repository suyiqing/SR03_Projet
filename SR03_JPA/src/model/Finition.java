package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Finition database table.
 * 
 */
@Entity
@NamedQuery(name="Finition.findAll", query="SELECT f FROM Finition f")
public class Finition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idFinition;

	private String bluetooth;

	private String climatisation;

	@Column(name="leve_vitre")
	private String leveVitre;

	private String navigation;

	private String radio;

	private String siege;

	public Finition() {
	}

	public int getIdFinition() {
		return this.idFinition;
	}

	public void setIdFinition(int idFinition) {
		this.idFinition = idFinition;
	}

	public String getBluetooth() {
		return this.bluetooth;
	}

	public void setBluetooth(String bluetooth) {
		this.bluetooth = bluetooth;
	}

	public String getClimatisation() {
		return this.climatisation;
	}

	public void setClimatisation(String climatisation) {
		this.climatisation = climatisation;
	}

	public String getLeveVitre() {
		return this.leveVitre;
	}

	public void setLeveVitre(String leveVitre) {
		this.leveVitre = leveVitre;
	}

	public String getNavigation() {
		return this.navigation;
	}

	public void setNavigation(String navigation) {
		this.navigation = navigation;
	}

	public String getRadio() {
		return this.radio;
	}

	public void setRadio(String radio) {
		this.radio = radio;
	}

	public String getSiege() {
		return this.siege;
	}

	public void setSiege(String siege) {
		this.siege = siege;
	}

}