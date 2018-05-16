package com.mergeCons.egitim.util;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.persistence.CascadeType;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class giris {

	private Roles rol = new Roles();
	private List<Roles> kullaniciListesi = new ArrayList<Roles>();

	private Gorev gorev = new Gorev();
	private List<Gorev> gorevListesi = new ArrayList<Gorev>();
	private List<String> secilenGorevDurumu = new ArrayList<String>();

	// @OneToMany(mappedBy = "gorevAdi", cascade = CascadeType.ALL,
	// fetch=FetchType.LAZY)
	// tabloda 'sec' ve 'sil' linkleri için yazýldý bu annotation ama iþe
	// yaramadý
	public List<Gorev> gorevGetir() {
		EntityManager em = EntityUtil.getEntityManager();
		return em.createNativeQuery("SELECT * FROM gorev g").getResultList();
	}

	/*
	 * Admin Ekranýna userlar ve görevlerini getirmek için public List<Gorev>
	 * userGorev() { EntityManager em = EntityUtil.getEntityManager(); return
	 * em.createNativeQuery("SELECT * FROM roles r JOIN ON roles.id=gorev.id "
	 * ).getResultList(); }
	 */

	public int userSayisi() {
		EntityManager em = EntityUtil.getEntityManager();
		return em.createNativeQuery("SELECT count(*) FROM roles r")
				.getResultList().size();
	}

	public List<Roles> userGetir() {
		EntityManager em = EntityUtil.getEntityManager();
		return em.createNativeQuery("SELECT * FROM roles r").getResultList();
	}

	private Integer girilenYetki;
	private String girilenUserId;
	private String girilensifre;

	public void userEkle() {
		EntityManager em = EntityUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(rol);
		em.getTransaction().commit();
		rol = new Roles();
	}

	public void userSil() {
		EntityManager em = EntityUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(rol);
		em.getTransaction().commit();
		rol = new Roles();
	}

	public void userEdit() {
		EntityManager em = EntityUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(rol);
		em.getTransaction().commit();
		rol = new Roles();
	}

	public void gorevOlustur() {
		EntityManager em = EntityUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(gorev);
		em.getTransaction().commit();
		gorev = new Gorev();
	}

	public void gorevKaldir() {
		EntityManager em = EntityUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(gorev);
		em.getTransaction().commit();
		gorev = new Gorev();
	}

	public void gorevEdit() {
		EntityManager em = EntityUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(gorev);
		em.getTransaction().commit();
		gorev = new Gorev();
	}

	public giris() {
		secilenGorevDurumu.add("TAMAMLANDI");
		secilenGorevDurumu.add("ÝPTAL EDÝLDÝ");
		secilenGorevDurumu.add("ERTELENDÝ");
		secilenGorevDurumu.add("YAPILACAK");

		Roles r1 = new Roles();
		r1.setAd("kenan");
		r1.setSoyad("karyagdi");
		r1.setUserId("61");
		r1.setSifre("1234");
		r1.setYetki(1);

		kullaniciListesi.add(r1);

		Roles r2 = new Roles();
		r2.setAd("alperen");
		r2.setSoyad("karyagdi");
		r2.setUserId("28");
		r2.setSifre("1111");
		r2.setYetki(0);

		kullaniciListesi.add(r2);

	}

	public void kullaniciEkle() {
		kullaniciListesi.add(rol);
		rol = new Roles();
	}

	public void kullaniciSil() {
		kullaniciListesi.remove(rol);
		rol = new Roles();
	}

	public void kullaniciEdit() {
		rol = new Roles();
	}

	public void gorevEkle() {
		gorevListesi.add(gorev);
		gorev = new Gorev();
	}

	public void gorevSil() {
		gorevListesi.remove(gorev);
		gorev = new Gorev();
	}

	public void gorevDuzenle() {
		gorev = new Gorev();
	}

	public String girisYap() {
		int searchListLength = kullaniciListesi.size(); // kullaniciListesi.size() var
												// TEKRAR TEKRAR DENE
		for (int i = 0; i < searchListLength; i++) {

			if (((girilenYetki == 1) && girilenYetki.equals(kullaniciListesi
					.get(i).getYetki()))
					&& girilenUserId
							.equals(kullaniciListesi.get(i).getUserId())
					&& girilensifre.equals(kullaniciListesi.get(i).getSifre())) {
				return "admin";
			}

			else if (((girilenYetki == 0) && girilenYetki
					.equals(kullaniciListesi.get(i).getYetki()))
					&& girilenUserId
							.equals(kullaniciListesi.get(i).getUserId())
					&& girilensifre.equals(kullaniciListesi.get(i).getSifre())) {
				return "kullanici";
			}
		}
		return null;

	}

	public Roles getRol() {
		return rol;
	}

	public void setRol(Roles rol) {
		this.rol = rol;
	}

	public List<Roles> getKullaniciListesi() {
		return kullaniciListesi;
	}

	public void setKullaniciListesi(List<Roles> kullaniciListesi) {
		this.kullaniciListesi = kullaniciListesi;
	}

	public Integer getGirilenYetki() {
		return girilenYetki;
	}

	public void setGirilenYetki(Integer girilenYetki) {
		this.girilenYetki = girilenYetki;
	}

	public String getGirilenUserId() {
		return girilenUserId;
	}

	public void setGirilenUserId(String girilenUserId) {
		this.girilenUserId = girilenUserId;
	}

	public String getGirilensifre() {
		return girilensifre;
	}

	public void setGirilensifre(String girilensifre) {
		this.girilensifre = girilensifre;
	}

	public Gorev getGorev() {
		return gorev;
	}

	public void setGorev(Gorev gorev) {
		this.gorev = gorev;
	}

	public List<Gorev> getGorevListesi() {
		return gorevListesi;
	}

	public void setGorevListesi(List<Gorev> gorevListesi) {
		this.gorevListesi = gorevListesi;
	}

	public List<String> getSecilenGorevDurumu() {
		return secilenGorevDurumu;
	}

	public void setSecilenGorevDurumu(List<String> secilenGorevDurumu) {
		this.secilenGorevDurumu = secilenGorevDurumu;
	}

}
