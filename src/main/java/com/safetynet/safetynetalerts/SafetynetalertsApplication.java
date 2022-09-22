//package com.safetynet.safetynetalerts;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class SafetynetalertsApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(SafetynetalertsApplication.class, args);
//	}
//
//}





package com.safetynet.safetynetalerts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.safetynet.safetynetalerts.model.AppData;
import com.safetynet.safetynetalerts.model.Firestation;
import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.repository.Impl.AppDataRepoImpl;
import com.safetynet.safetynetalerts.repository.Impl.FirestationsRepositoryImpl;
import com.safetynet.safetynetalerts.repository.Impl.PersonsRepoImpl;
import com.safetynet.safetynetalerts.service.AppDataService;


@SpringBootApplication
public class SafetynetalertsApplication implements CommandLineRunner  {

	public static void main(String[] args) {
		SpringApplication.run(SafetynetalertsApplication.class, args);
	}
	
	@Autowired
	private AppDataService appDataService;
	
	
	  @Override
	    public void run(String... args) throws Exception {
	        System.out.println("Hello World!");
	        
	        
	        AppDataRepoImpl appDataRepo = new AppDataRepoImpl();
	        PersonsRepoImpl personsRepo = new PersonsRepoImpl();
	        FirestationsRepositoryImpl firestationRepo = new FirestationsRepositoryImpl();
	        
	        
	        AppData appData = appDataService.readDatafromJson("src/main/resources/data.json");
	        
	        Person[] persons = appData.getPersons();
	        Firestation[] firestations = appData.getFirestations();
	        
	        System.out.println(persons[0]);
	        
	        
	       
	        
//	        Person[] personsAddress = personsRepo.getPersonsByAddress(persons, "892 Downing Ct");
//	        System.out.println(personsAddress[0]);
//	        System.out.println(personsAddress[1]);
//	        System.out.println(personsAddress[2]);
//	        
//	        Firestation[] firestationsAddress = firestationRepo.getFirestationsByStation (firestations, 1);
//	        System.out.println(firestationsAddress[0]);
//	        System.out.println(firestationsAddress[1]);
	        
//	        Person[] personsAddress2 = appDataRepo.getPersonsByAddress("892 Downing Ct", appData);
//	        System.out.println(personsAddress2[0]);
//	        System.out.println(personsAddress2[1]);
//	        System.out.println(personsAddress2[2]);
	        
	        
			
	    }

}