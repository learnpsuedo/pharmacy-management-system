package com.Drug.Drugs.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;


import com.Drug.Drugs.exception.CustomException;

import com.Drug.Drugs.models.Drugs;
//import com.Drug.Drugs.models.Inventory;
import com.Drug.Drugs.service.DrugsService;


@RestController
@RequestMapping("/drugs")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class DrugsController {

	@Autowired
	private DrugsService service;
	//Service



	@PostMapping("/add")
	public ResponseEntity<Drugs> addDrug (@RequestBody Drugs drug)
	{
		Drugs addDrugs = service.addNewDrug(drug);
		return new ResponseEntity<>(addDrugs,HttpStatus.CREATED);
	}

	//Get all the list of drugs available
	@GetMapping("/list")
	public List<Drugs> getDetails(){
		return service.getAllDetails();
	}

	/*
	 * @GetMapping("/category/{categories}") public List<Drugs>
	 * getDrugsByCategory(@PathVariable("categories") String categories){ return
	 * service.getDrugsByCategory(categories); }
	 */

	//Fetch a particular drugs using the drugs id as Path Variable
	//@GetMapping("/{id}")
	//public Optional<Drugs> getDrugsById(@PathVariable("id") int drugsId) throws CustomException, Exception{
		//return service.getDrugsByID(drugsId);
	//}


	@GetMapping("/{drugsId}")
	  public List<Drugs> getDrugsBydrugsId(@PathVariable("drugsId") int drugsId){
	      return service.getDrugsById(drugsId);
	  }





	//Get the details of the drugs having supplier Name as it Path Variable
	/*
	 * @GetMapping("/name/{id}") public List<Drugs>
	 * getDrugsBySupplierName(@PathVariable("id") String supplierName){ return
	 * service.getDrugsBySupplierName(supplierName); }
	 *
	 * @GetMapping("/drugs-name/{id}") public List<Drugs>
	 * getDrugsByName(@PathVariable("id") String drugsName){ return
	 * service.getDrugsByName(drugsName); }
	 */

	//For updating the drugs to its respective attribute
	@PutMapping("/{id}")
	public ResponseEntity<Drugs> updateDrugsDetails( @PathVariable("id") int id,@Valid @RequestBody Drugs drugs) throws CustomException, Exception {
		return ResponseEntity.ok(service.updateDrugsDetails(id,drugs));
	}

	//Deleting the drugs respective to the specified drugs id
	@DeleteMapping("/{id}")
	public String deleteDrugs(@PathVariable("id") int drugsId) {

		return service.deleteDrugs(drugsId);


	}


}
