package net.abdelmalek.benali.controller;

import java.awt.image.RGBImageFilter;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.abdelmalek.benali.entities.UserBO;
import net.abdelmalek.benali.params.Register;
import net.abdelmalek.benali.repositories.ClientRepository;


@Controller
public class MainController {
	@Autowired
	private ClientRepository clientRepository ;
	@RequestMapping(value="/")
	public String welcome(Map<String,String> model) {
		model.put("message", "I will be with YOU");
		return "welcome";	
	}
	
	@RequestMapping(value = "/clientList", method = RequestMethod.GET)
	public String getClientList(ModelMap model) {
		
		List<UserBO> clients =  (List<UserBO>) clientRepository.findAll();
		model.addAttribute("clients", clients);
		return "clientList";	
	}
	
	@RequestMapping(value = "/userForm", method = RequestMethod.GET)
	public String getUserForm() {
		
		return "userForm"; 
	}

	

}
