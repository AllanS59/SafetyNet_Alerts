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

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.safetynet.safetynetalerts.model.AppData;
import com.safetynet.safetynetalerts.model.Firestation;
import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.repository.AppDataRepository;
import com.safetynet.safetynetalerts.repository.FirestationsRepository;
import com.safetynet.safetynetalerts.repository.PersonsRepository;


@SpringBootApplication
public class SafetynetalertsApplication implements CommandLineRunner  {

	public static void main(String[] args) {
		SpringApplication.run(SafetynetalertsApplication.class, args);
	}
	
	  @Override
	    public void run(String... args) throws Exception {
	        System.out.println("Hello World!");
	        
	        AppDataRepository appDataRepo = new AppDataRepository();
	        PersonsRepository personsRepo = new PersonsRepository();
	        FirestationsRepository firestationRepo = new FirestationsRepository();
	        
	        
	        AppData appData = appDataRepo.readDatafromJson("src/main/resources/data.json");
	        
	        Person[] persons = appData.getPersons();
	        Firestation[] firestations = appData.getFirestations();
	        
	        System.out.println(persons[0]);
	        
	        
	       
	        
	        Person[] personsAddress = personsRepo.getPersonsByAddress(persons, "892 Downing Ct");
	        System.out.println(personsAddress[0]);
	        System.out.println(personsAddress[1]);
	        System.out.println(personsAddress[2]);
	        
	        Firestation[] firestationsAddress = firestationRepo.getFirestationsByStation (firestations, 1);
	        System.out.println(firestationsAddress[0]);
	        System.out.println(firestationsAddress[1]);
	        
//	        Person[] personsAddress2 = appDataRepo.getPersonsByAddress("892 Downing Ct", appData);
//	        System.out.println(personsAddress2[0]);
//	        System.out.println(personsAddress2[1]);
//	        System.out.println(personsAddress2[2]);
	        
	        
			//appDataRepo.writeDataInJson(appData, "src/main/resources/data2.json");
	    }

}