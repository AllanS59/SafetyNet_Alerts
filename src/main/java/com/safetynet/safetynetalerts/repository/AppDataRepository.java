package com.safetynet.safetynetalerts.repository;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.safetynet.safetynetalerts.model.AppData;

@Repository
public class AppDataRepository {

	public AppData readDatafromJson ( String jsonFileName) {
		
		AppData appData = null;
		
		try {
		    // create Gson instance
		    Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();

		    // create a reader
		    Reader reader = Files.newBufferedReader(Paths.get(jsonFileName));

		    // convert JSON string to User object
		    appData = gson.fromJson(reader,AppData.class);

		    //// print user object
		    //System.out.println(appData);

		    // close reader
		    reader.close();

		} catch (Exception ex) {
		    ex.printStackTrace();
		}
		
		return appData;
	}
	
	
	
}
