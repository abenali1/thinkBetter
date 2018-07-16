package net.abdelmalek.benali.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.abdelmalek.benali.entities.UserBO;
import net.abdelmalek.benali.params.Register;
import net.abdelmalek.benali.services.MailService;
import net.abdelmalek.benali.services.UserService;

@RestController
@CrossOrigin(origins = "*")
public class InscriptionController {
	@Autowired
	private UserService userService;
	@Autowired 
	private MailService mailService;
	@RequestMapping(value = "/saveDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void showUserDetails(@ModelAttribute("register") Register register) throws ParseException {
//			 ModelMap modelMap) {
//		modelMap.put("userName", userName);
//        modelMap.put("userEmail", userEmail);
//		return"showUser";
		String text = new StringBuilder().append("Hello "+register.getLastName()+",\n").append("\n")
				.append( "Thanks a lot for your confidence dear customer on our Team ,\n").append("Your Subscription has been treated you can proceed your shopping aas soon as possible,\n").toString();

		userService.saveUser(register);
		mailService.sendEmail(register.getEmail().trim(), "Registration", text);
		System.out.println(register.getAdress());
	}
}
