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
@RequestMapping(value="/cycl")
@RestController
public class CurrentYearCandidatesListController {
	private static final Logger LOGGER=LoggerFactory.getLogger(CurrentYearCandidatesListController.class);
	@Autowired
	ConsumersRepository consumersRepository;
	@GetMapping(value="/currentYearCandidateList")
	public ResponseEntity<List<Consumers>>getCurrentYearCandidates(){
		LOGGER.info("From class CurrentYearCandidatesListController,method : getCurrentYearCandidates()");
		Integer currentYear=Calendar.getInstance().get(Calendar.YEAR);
		List<Consumers>consumers=consumersRepository.getLastYearCandidates(currentYear);
		return ResponseEntity.ok().body(consumers);
	}
}
