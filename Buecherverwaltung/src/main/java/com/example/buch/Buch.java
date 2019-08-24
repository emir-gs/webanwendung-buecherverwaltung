package com.example.buch;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Buch {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int buchid;
	private String titel;
	private String autor;
	private double preis;
	private long ean;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date erscheinungsdatum;
	private String typ;
	
	
	public int getBuchid() {
		return buchid;
	}
	public void setBuchid(int buchid) {
		this.buchid = buchid;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public double getPreis() {
		return preis;
	}
	public void setPreis(double preis) {
		this.preis = preis;
	}
	public long getEan() {
		return ean;
	}
	public void setEan(long ean) {
		this.ean = ean;
	}
	public Date getErscheinungsdatum() {
		return erscheinungsdatum;
	}
	public void setErscheinungsdatum(Date erscheinungsdatum) {
		this.erscheinungsdatum = erscheinungsdatum;
	}
	public String getTyp() {
		return typ;
	}
	public void setTyp(String typ) {
		this.typ = typ;
	}
	
	@Override
	public String toString() {
		return "Buch [buchid=" + buchid + ", titel=" + titel + ", autor=" + autor + ", preis=" + preis + ", ean=" + ean
				+ ", erscheinungsdatum=" + erscheinungsdatum + ", typ=" + typ + "]";
	}
	
	

}
