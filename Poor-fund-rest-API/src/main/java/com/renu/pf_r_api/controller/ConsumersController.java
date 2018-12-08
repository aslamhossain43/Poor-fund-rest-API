package com.renu.pf_r_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.renu.pf_r_api.fileupload.FileUpload;
@CrossOrigin("*")
@RestController
@RequestMapping(value="/consumers")
public class ConsumersController {
private static final Logger LOGGER=LoggerFactory.getLogger(ConsumersController.class);
@Autowired
 FileUpload fileUpload;
private static List<String> files = new ArrayList<String>();
	@PostMapping(value="/addFile")
	public static ResponseEntity<String>addConsumersFile(@RequestParam("piFile") MultipartFile piFile) {
		LOGGER.info("From class ConsumersController ,method : ResponseEntity<String>addConsumersFile()");
		String message = "";
		try {
			FileUpload.piFileUpload(piFile);
			files.add(piFile.getOriginalFilename());
 
			message = "You successfully uploaded " + piFile.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "FAIL to upload " + piFile.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
		
							
		
	}
	
	
	
}
