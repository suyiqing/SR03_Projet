package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the Navigateur database table.
 * 
 */
@Entity
@NamedQuery(name="Navigateur.findAll", query="SELECT n FROM Navigateur n")
public class Navigateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idNavigateur;

	private String navigateur;

	private int prix;

	//bi-directional many-to-one association to Finition
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="finition")
	private Finition finitionBean;

	public Navigateur() {
	}

	public int getIdNavigateur() {
		return this.idNavigateur;
	}

	public void setIdNavigateur(int idNavigateur) {
		this.idNavigateur = idNavigateur;
	}

	public String getNavigateur() {
		return this.navigateur;
	}

	public void setNavigateur(String navigateur) {
		this.navigateur = navigateur;
	}

	public int getPrix() {
		return this.prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public Finition getFinitionBean() {
		return this.finitionBean;
	}

	public void setFinitionBean(Finition finitionBean) {
		this.finitionBean = finitionBean;
	}

}