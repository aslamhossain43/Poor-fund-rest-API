package com.renu.pf_r_api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renu.pf_r_api.models.MobileMessage;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@CrossOrigin("*")
@RequestMapping(value = "/msg")
@RestController
public class EmailAndMobileMessages {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailAndMobileMessages.class);
	/*
	 * private static final String SID="ACbf152064a7cf9493abd5f5fe04b199e9"; private
	 * static final String TOKEN="e95ec5af2d6a70ecb054dfe32390e917";
	 */
	private static final String SID = "ACe84a26ed289f729bee58f6194b08b898";
	private static final String TOKEN = "6fc267fbb15b6e833bc97963d613aba2";

	@RequestMapping(value = "/message")
	public ResponseEntity<?> sendMessage(@RequestBody MobileMessage mobileMessage) {
		LOGGER.info("FROM  class EmailAndMobileMessages,method: sendMessage()--ENTER-- ");
		Twilio.init(SID, TOKEN);
		Message message = Message.creator(new PhoneNumber(mobileMessage.getDestinationNumber()),
				new PhoneNumber(mobileMessage.getSourceNumber()), "Kmn aso ! gf kmn ase").create();

		return ResponseEntity.ok().body("Messgae has been sent to" + mobileMessage.getDestinationNumber());

	}
}
