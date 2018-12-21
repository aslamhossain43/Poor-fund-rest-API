package com.renu.pf_r_api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renu.pf_r_api.models.Consumers;
import com.renu.pf_r_api.repositories.ConsumersRepository;

@CrossOrigin("*")
@RequestMapping(value="/gl")
@RestController
public class GrantedListController {
private static final Logger LOGGER=LoggerFactory.getLogger(GrantedListController.class);
@Autowired
ConsumersRepository consumersRepository;
@GetMapping(value="/grantedList")
public ResponseEntity<List<Consumers>>getGrantedList(){
	LOGGER.info("FROM class GrantedListController, method : getGrantedList()");
	List<Consumers>consumers=consumersRepository.findAll();
	return ResponseEntity.ok().body(consumers);
}
}
