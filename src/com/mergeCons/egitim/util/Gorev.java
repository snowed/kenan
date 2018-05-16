package com.mergeCons.egitim.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Gorev implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	//@ManyToOne
	private String gorevAdi;
	private String gorevSonTarihi;
	private String gorevAciklamasi;
	private String gorevDurumu;	
	
	//@OneToMany(mappedBy="gorevListesi")
	//private List<Gorev> gorevList=new ArrayList<Gorev>();

	public String getGorevAdi() {
		return gorevAdi;
	}

	public void setGorevAdi(String gorevAdi) {
		this.gorevAdi = gorevAdi;
	}

	public String getGorevSonTarihi() {
		return gorevSonTarihi;
	}

	public void setGorevSonTarihi(String gorevSonTarihi) {
		this.gorevSonTarihi = gorevSonTarihi;
	}

	public String getGorevAciklamasi() {
		return gorevAciklamasi;
	}

	public void setGorevAciklamasi(String gorevAciklamasi) {
		this.gorevAciklamasi = gorevAciklamasi;
	}

	public String getGorevDurumu() {
		return gorevDurumu;
	}

	public void setGorevDurumu(String gorevDurumu) {
		this.gorevDurumu = gorevDurumu;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
/*
	public List<Gorev> getGorevList() {
		return gorevList;
	}

	public void setGorevList(List<Gorev> gorevList) {
		this.gorevList = gorevList;
	}*/

}
