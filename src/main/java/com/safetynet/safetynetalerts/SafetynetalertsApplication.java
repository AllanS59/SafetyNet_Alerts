package com.safetynet.safetynetalerts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SafetynetalertsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SafetynetalertsApplication.class, args);
	}
}


//package com.safetynet.safetynetalerts;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
//
//import com.safetynet.safetynetalerts.model.AppData;
//import com.safetynet.safetynetalerts.model.Firestation;
//import com.safetynet.safetynetalerts.model.MedicalRecord;
//import com.safetynet.safetynetalerts.model.Person;
//import com.safetynet.safetynetalerts.repository.impl.AppDataRepoImpl;
//import com.safetynet.safetynetalerts.repository.impl.FirestationsRepositoryImpl;
//import com.safetynet.safetynetalerts.repository.impl.MedicalRecordsRepoImpl;
//import com.safetynet.safetynetalerts.repository.impl.PersonsRepoImpl;
//import com.safetynet.safetynetalerts.service.impl.AppDataServiceImpl;
//
//
//@SpringBootApplication
//public class SafetynetalertsApplication implements CommandLineRunner  {
//
//	public static void main(String[] args) {
//		SpringApplication.run(SafetynetalertsApplication.class, args);
//	}
//	
//	@Autowired
//	private AppDataServiceImpl appDataService;
//	
//	
//	  @Override
//	    public void run(String... args) throws Exception {
//	        System.out.println("Hello World!");
//	        
//	        
//	        AppDataRepoImpl appDataRepo = new AppDataRepoImpl();
//	        PersonsRepoImpl personsRepo = new PersonsRepoImpl();
//	        FirestationsRepositoryImpl firestationRepo = new FirestationsRepositoryImpl();
//	       MedicalRecordsRepoImpl MRRepo = new MedicalRecordsRepoImpl();
//	        
//	        
//	        AppData appData = appDataService.readDatafromJson();
//	        
//	        Person[] persons = appData.getPersons();
//	        Firestation[] firestations = appData.getFirestations();
//	        MedicalRecord[] medicalRecords = appData.getMedicalrecords();
//	        
//	        System.out.println(persons[0]);
//	        
//	        
//	        MedicalRecord testMR = new MedicalRecord();
//	        
//	        testMR.setFirstName("Jean");
//	        testMR.setLastName("Test");
//	        testMR.setAllergies(null);
//	        testMR.setMedications(null);
//
//	        String dateString = "06/10/2004";
//	        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//	        Date date = df.parse(dateString);
//	        
//	        testMR.setBirthdate(date);
//	   int ageTest = MRRepo.getAge(testMR);
//	        
//	        System.out.println(testMR);
//	        System.out.println("age: " + ageTest);
//
////	        Person[] personsAddress = personsRepo.getPersonsByAddress(persons, "892 Downing Ct");
////	        System.out.println(personsAddress[0]);
////	        System.out.println(personsAddress[1]);
////	        System.out.println(personsAddress[2]);
////	        
////	        Firestation[] firestationsAddress = firestationRepo.getFirestationsByStation (firestations, 1);
////	        System.out.println(firestationsAddress[0]);
////	        System.out.println(firestationsAddress[1]);
////
////	        Person[] personsAddress2 = appDataRepo.getPersonsByAddress("892 Downing Ct", appData);
////	        System.out.println(personsAddress2[0]);
////	        System.out.println(personsAddress2[1]);
////	        System.out.println(personsAddress2[2]);
//
//}
//
//}