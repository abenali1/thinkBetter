package net.abdelmalek.benali.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.abdelmalek.benali.entities.UserBO;
import net.abdelmalek.benali.params.Register;
import net.abdelmalek.benali.repositories.ClientRepository;
@Service
public class UserService {
	@Autowired
	private ClientRepository clientRepository ;
	
	public void saveUser(Register register) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		UserBO user = new UserBO();
		user.setId(register.getId());
		user.setAdress(register.getAdress());
		user.setBirthDate(DateUtils.parseDate(sdf.format(register.getDateBirth()), "yyyy/MM/dd"));
		user.setCity(register.getTown());
		user.setFirstName(register.getFirstName());
		user.setLastName(register.getLastName());
		user.setMail(register.getEmail());
		user.setZipCode(register.getZipCode());
		user.setBirthDate(register.getDateBirth());
		clientRepository.save(user);
		
	}

}
