package com.Drug.Drugs.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Drug.Drugs.models.Drugs;

@Repository
public interface DrugsRepository extends MongoRepository<Drugs, Integer>{


	//Custom method for finding the drugs with respective to the provided supplier Name

	List<Drugs> findByDrugsName(String drugsName);


	List<Drugs> findBySupplierName(String supplierName);

	Boolean existsBySupplierName(String supplierName);
	Boolean existsByDrugId(int drugId);


	List<Drugs> findBycategories(String categories);

}
