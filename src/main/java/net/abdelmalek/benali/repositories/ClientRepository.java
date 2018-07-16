package net.abdelmalek.benali.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import net.abdelmalek.benali.entities.UserBO;

public interface ClientRepository extends CrudRepository<UserBO, String>{
	
	List<UserBO> findByFirstName(String firstName);
	
	

}
