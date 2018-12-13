package com.renu.pf_r_api.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.renu.pf_r_api.fileupload.FileUpload;
import com.renu.pf_r_api.models.Consumers;
import com.renu.pf_r_api.repositories.ConsumersRepository;

@CrossOrigin("*")
@RequestMapping(value = "/consumers")
@RestController
public class ConsumersController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsumersController.class);
	@Autowired
	FileUpload fileUpload;
	@Autowired
	ConsumersRepository consumersRepository;
	public String piCode = null;
	public String apiCode = null;
	@PostMapping(value = "/addConsumers")
	public ResponseEntity<?> addConsumers(@RequestBody Consumers consumers) {
		LOGGER.info("From class ConsumersController, method : addConsumers() ");
		if (consumers.getId() == null) {
			consumers.setPiCode(this.piCode);
			consumers.setApiCode(this.apiCode);
			consumersRepository.save(consumers);
			this.piCode=null;
			this.apiCode=null;
            new Consumers(null, null, null, null, null, null, null, null, null, null, null);	
			return ResponseEntity.ok().body("Operation success !");

		} else {
			consumersRepository.save(consumers);
			new Consumers(null, null, null, null, null, null, null, null, null, null, null);
			return ResponseEntity.ok().body(null);
		}
	}

	@PostMapping(value = "/addFile")
	public ResponseEntity<?> addConsumersFile(@RequestParam("piFile") MultipartFile piFile,
			@RequestParam("apiFile") MultipartFile apiFile) {
		LOGGER.info("From class ConsumersController ,method : ResponseEntity<String>addConsumersFile()");
		      if ((piFile.getContentType().equals("image/jpeg")
		    		|| piFile.getContentType().equals("image/jpg")
		    		|| piFile.getContentType().equals("image/png")
		    		|| piFile.getContentType().equals("image/gif"))
		    		  && 
		    		  (apiFile.getContentType().equals("image/jpeg")
		    		|| apiFile.getContentType().equals("image/jpg")
		    		|| apiFile.getContentType().equals("image/png")
		    		|| apiFile.getContentType().equals("image/gif"))) {
		    	  
		    	  this.piCode = "PI" + UUID.randomUUID().toString().substring(26).toUpperCase();
		  		  this.apiCode = "API" + UUID.randomUUID().toString().substring(26).toUpperCase();
		  		
		    	  
		    	  FileUpload.fileUpload(piFile, this.piCode, apiFile, this.apiCode);
		    	  LOGGER.info("From class ConsumersController ,method : ResponseEntity<String>addConsumersFile(),Image uploaded");
					return ResponseEntity.ok().body(" success file upload ");
			}else {
				LOGGER.info("From class ConsumersController ,method : ResponseEntity<String>addConsumersFile(), File not an image that is rejected");
				
				return ResponseEntity.badRequest().body(null);
				
			
			}
		

	}

}

