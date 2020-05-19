package com.cigna.assessment.specialityfinder.services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cigna.assessment.specialityfinder.model.Results;
import com.cigna.assessment.specialityfinder.model.Specialty;
import com.google.gson.Gson;

@RestController
public class SpecialtyFinderResource {

	@GetMapping("/specialsts")
	public ArrayList<Specialty> getSpecialty() {

		JSONParser parser = new JSONParser();
		Results res = null;
		try {
			JSONObject a = (JSONObject) parser.parse(new FileReader("src/main/resources/data.json"));
			Gson g = new Gson();
			res = g.fromJson(a.toString(), Results.class);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return res.getResults();
	}

}
