package com.renu.pf_r_api.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Donors {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
}
