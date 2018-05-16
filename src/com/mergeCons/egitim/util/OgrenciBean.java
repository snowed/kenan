package com.mergeCons.egitim.util;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

public class OgrenciBean {
	
	private Ogrenci ogrenci=new Ogrenci();
	private List<Ogrenci> ogrenciListesi=new ArrayList<Ogrenci>();
	
	public void kaydet() {
		EntityManager em= EntityUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(ogrenci);
		em.getTransaction().commit();
		ogrenci=new Ogrenci();	
	}
	
	
	

	public Ogrenci getOgrenci() {
		return ogrenci;
	}

	public void setOgrenci(Ogrenci ogrenci) {
		this.ogrenci = ogrenci;
	}

	public List<Ogrenci> getOgrenciListesi() {
		return ogrenciListesi;
	}

	public void setOgrenciListesi(List<Ogrenci> ogrenciListesi) {
		this.ogrenciListesi = ogrenciListesi;
	}

}
