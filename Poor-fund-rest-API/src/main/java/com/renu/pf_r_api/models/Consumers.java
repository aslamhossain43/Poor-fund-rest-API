package com.renu.pf_r_api.models;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Entity
public class Consumers extends BaseConsumers<Long> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String piCode;
	private String apiCode;
	@NotBlank(message = "Enter your  name")
	private String name;
	@NotBlank(message = "Your country")
	private String country;
	@NotBlank(message = "Enter your zela")
	private String zela;
	@NotBlank(message = "Enter your upozela")
	private String upozela;
	@NotBlank(message = "Enter your union")
	private String union;
	@NotBlank(message = "Enter your work")
	private String work;
	@NotNull
	private Long contact;
	@NotNull
	private Long bkash;
	@Override
	public Long getId() {
		return id;
	}
	
	
	public Consumers() {
		this.piCode = "PI" + UUID.randomUUID().toString().substring(26).toUpperCase();
		this.apiCode = "API" + UUID.randomUUID().toString().substring(26).toUpperCase();
		
	}






	public Consumers(Long id, String piCode, String apiCode, @NotBlank(message = "Enter your  name") String name,
			@NotBlank(message = "Your country") String country, @NotBlank(message = "Enter your zela") String zela,
			@NotBlank(message = "Enter your upozela") String upozela,
			@NotBlank(message = "Enter your union") String union, @NotBlank(message = "Enter your work") String work,
			@NotNull Long contact, @NotNull Long bkash) {
		super();
		this.id = id;
		this.piCode = piCode;
		this.apiCode = apiCode;
		this.name = name;
		this.country = country;
		this.zela = zela;
		this.upozela = upozela;
		this.union = union;
		this.work = work;
		this.contact = contact;
		this.bkash = bkash;
	}


	public String getPiCode() {
		return piCode;
	}


	public void setPiCode(String piCode) {
		this.piCode = piCode;
	}


	public String getApiCode() {
		return apiCode;
	}


	public void setApiCode(String apiCode) {
		this.apiCode = apiCode;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getZela() {
		return zela;
	}


	public void setZela(String zela) {
		this.zela = zela;
	}


	public String getUpozela() {
		return upozela;
	}


	public void setUpozela(String upozela) {
		this.upozela = upozela;
	}


	public String getUnion() {
		return union;
	}


	public void setUnion(String union) {
		this.union = union;
	}


	public String getWork() {
		return work;
	}


	public void setWork(String work) {
		this.work = work;
	}






	public Long getContact() {
		return contact;
	}


	public void setContact(Long contact) {
		this.contact = contact;
	}


	public Long getBkash() {
		return bkash;
	}


	public void setBkash(Long bkash) {
		this.bkash = bkash;
	}


	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Consumers [id=" + id + ", piCode=" + piCode + ", apiCode=" + apiCode + ", name=" + name + ", country="
				+ country + ", zela=" + zela + ", upozela=" + upozela + ", union=" + union + ", work=" + work
				+ ", contact=" + contact + ", bkash=" + bkash + "]";
	}


	
	
	
	
}
