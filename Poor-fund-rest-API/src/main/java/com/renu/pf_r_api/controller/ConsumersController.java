package com.renu.pf_r_api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String piCode;
	public String apiCode;
	@PostMapping(value = "/addConsumers")
	public ResponseEntity<?> addConsumers(@RequestBody Consumers consumers) {
		LOGGER.info("From class ConsumersController, method : addConsumers() ");
		if (consumers.getId() == null) {
			this.piCode = consumers.getPiCode();
			this.apiCode = consumers.getApiCode();
			consumersRepository.save(consumers);
            consumers.setId(null);			
			return ResponseEntity.ok().body("your operation has been completed successfully");

		} else {
			consumersRepository.save(consumers);
			consumers.setId(null);
			return ResponseEntity.ok().body("your operation has been completed successfully");
		}
	}

	@PostMapping(value = "/addFile")
	public ResponseEntity<?> addConsumersFile(@RequestParam("piFile") MultipartFile piFile,
			@RequestParam("apiFile") MultipartFile apiFile) {
		LOGGER.info("From class ConsumersController ,method : ResponseEntity<String>addConsumersFile()");
		try {
			FileUpload.fileUpload(piFile, this.piCode, apiFile, this.apiCode);
			this.piCode = null;
			this.apiCode = null;
			return ResponseEntity.ok().body("file is uploaded !");
		} catch (Exception e) {
			return ResponseEntity.ok().body("file is not uploaded !");
		}

	}

}
