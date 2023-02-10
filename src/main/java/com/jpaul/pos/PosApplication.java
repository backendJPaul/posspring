package com.jpaul.pos;

import com.jpaul.pos.dao.DAOManager;
import com.jpaul.pos.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PosApplication {

	public static void main(String[] args) {
/*
		DAOManager daoManager = new DAOManager();
		try{
			User user = new User();
			user.setName("paulsabbath");
			user.setPassword("root");
			user.setIdRole(1);
			System.out.println(daoManager.getDAOUser().save(user));
		}
		catch(Exception e){
			System.out.println("falied: " + e.toString());
		}
*/
		SpringApplication.run(PosApplication.class, args);
	}

}
