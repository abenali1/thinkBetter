package net.abdelmalek.benali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.abdelmalek.benali.services.MailService;

@RestController
public class MailController {
	@Autowired	
	private MailService instanceMailService;

	@RequestMapping("/sendMail")
	public void MailSender() {
		instanceMailService.sendEmail("abdelmalek.engineering@gmail.com", "Success", "You have been chosen to assist to the Ceremony");	
		
	}
	
}
