package com.renu.pf_r_api.controller;

import java.util.Calendar;
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
@RequestMapping(value="/lycl")
@RestController
public class LastYearCandidatesListController {
private static final Logger LOGGER=LoggerFactory.getLogger(LastYearCandidatesListController.class);
@Autowired
ConsumersRepository consumersRepository;
@GetMapping(value="/lastYearCandidateList")
public ResponseEntity<List<Consumers>>getLastYearCandidates(){
	LOGGER.info("From class LastYearCandidatesListController,method : getLastYearCandidates()");
	Integer currentYear=Calendar.getInstance().get(Calendar.YEAR);
	Integer lastYear=currentYear-1;
	List<Consumers>consumers=consumersRepository.getLastYearCandidates(lastYear);
	return ResponseEntity.ok().body(consumers);
}

}
