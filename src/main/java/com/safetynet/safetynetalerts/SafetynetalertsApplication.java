package com.safetynet.safetynetalerts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SafetynetalertsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SafetynetalertsApplication.class, args);
	}

}
//
//
//
//
//
//package com.safetynet.safetynetalerts;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import com.safetynet.safetynetalerts.model.AppData;
//import com.safetynet.safetynetalerts.model.Person;
//import com.safetynet.safetynetalerts.repository.AppDataRepository;
//import com.safetynet.safetynetalerts.repository.PersonsRepository;
//import com.safetynet.safetynetalerts.service.PersonsService;
//
//@SpringBootApplication
//public class SafetynetalertsApplication implements CommandLineRunner  {
//
//	public static void main(String[] args) {
//		SpringApplication.run(SafetynetalertsApplication.class, args);
//	}
//	
//	  @Override
//	    public void run(String... args) throws Exception {
//	        System.out.println("Hello World!");
//	        
//	        AppDataRepository appDataRepo = new AppDataRepository();
//	        AppData appData = appDataRepo.readDatafromJson("src/main/resources/data.json");
//	        
//	        Person[] persons = appData.getPersons();
//	        System.out.println(persons[0]);
//	        
//	        PersonsService personsService = new PersonsService();
//			Person person = personsService.getPersonByFirstNameAndLastName(persons, "Jonanathan", "Marrack");
//			
////			PersonsRepository personsRepository = new PersonsRepository() ;
////			String firstName = "Jonanathan";
////			String lastName = "Marrack";
////			Person person = personsRepository.getPersonByFirstNameAndLastName (persons, firstName, lastName);
//			
//			 System.out.println(person);
//	    }
//
//}