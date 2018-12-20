package com.renu.pf_r_api.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.renu.pf_r_api.fileupload.FileUpload;
import com.renu.pf_r_api.models.Consumers;
import com.renu.pf_r_api.repositories.ConsumersRepository;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/mgng")
public class Manage_Grant_Not_Grant_Controller {
	private static final Logger LOGGER = LoggerFactory.getLogger(Manage_Grant_Not_Grant_Controller.class);  
	@Autowired
	ConsumersRepository consumersRepository;
	private String provedCode = null;

	@PostMapping(value = "/addGrantNotGrant")
	public ResponseEntity<?> addGrantNotGrant(
			@RequestParam("provedFile") MultipartFile provedFile, @RequestParam("status") String status,
			@RequestParam("grantNotGrantId")Long grantNotGrantId) {

		if (provedFile.getContentType().equals("image/jpeg") 
						|| provedFile.getContentType().equals("image/jpg")
						|| provedFile.getContentType().equals("image/png")
						|| provedFile.getContentType().equals("image/gif")) {

			this.provedCode = "PR" + UUID.randomUUID().toString().substring(26).toUpperCase();
			LOGGER.info(provedCode);
	
				FileUpload.fileUploadForGrantedNotGranted(provedFile,
						this.provedCode);
			
				Consumers consumers = consumersRepository.getById(grantNotGrantId);
				consumers.setStatus(status);
				consumers.setPrCode(this.provedCode);
				consumersRepository.save(consumers);
				consumers.setStatus(null);
				consumers.setPrCode(null);
			LOGGER.info("From class ConsumersController ,method : addGrantNotGrant(),Image uploaded");
			return ResponseEntity.ok().body(" success file upload ");
		} else {
			LOGGER.info(
					"From class ConsumersController ,method : addGrantNotGrant(), File not an image that is rejected");
			return ResponseEntity.badRequest().body(null);

		}

	}

}
