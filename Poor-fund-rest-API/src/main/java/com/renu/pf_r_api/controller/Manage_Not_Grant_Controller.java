package com.renu.pf_r_api.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.renu.pf_r_api.models.Consumers;
import com.renu.pf_r_api.repositories.ConsumersRepository;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/mng")
public class Manage_Not_Grant_Controller {
	private static final Logger LOGGER = LoggerFactory.getLogger(Manage_Not_Grant_Controller.class);  
	@Autowired
	ConsumersRepository consumersRepository;
	File file;
	String provedCode=null;
	@PostMapping(value = "/addNotGrant")
	public ResponseEntity<?> addNotGrant(@RequestParam("status") String status,
			@RequestParam("notGrantId")Long notGrantId) {
		LOGGER.info("From class Manage_Not_Grant_Controller ,method : addNotGrant()");

	            	 LOGGER.info("From class Manage_Grant_Not_Grant_Controller ,method : addNotGrant().. Id is valid");

	            	 Consumers consumers = consumersRepository.getById(notGrantId);
	            	 this.provedCode=consumers.getPrCode();
	            	 this.file=new File("H:\\NodeJS_Github\\Poor-fund-App\\Poor-fund-App\\src\\assets\\granted-images\\"+this.provedCode+".jpg");
	            		this.file.delete();
	            	
	            				consumers.setStatus(status);
				consumersRepository.save(consumers);
				consumers.setStatus(null);
			return ResponseEntity.ok().body(" status added ");
	      
	}

}
