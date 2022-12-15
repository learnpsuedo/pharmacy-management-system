package com.Drug.Drugs.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.Drug.Drugs.exception.CustomException;
//import com.Drug.Drugs.models.Cart;
import com.Drug.Drugs.models.Drugs;
//import com.Drug.Drugs.models.Inventory;
//import com.Drug.Drugs.models.Supplier;
import com.Drug.Drugs.repository.DrugsRepository;

@Service
public class DrugsService {

	@Autowired
	private DrugsRepository drugsRepository;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

//	@Autowired
//	private RestTemplate restTemplate;

	private static final Logger LOGGER = LoggerFactory.getLogger(DrugsService.class);

	public Drugs saveDrugsDetails(Drugs drugs, MultipartFile[] file) throws CustomException, Exception{
		 //Set<Photo> images = uploadImage(file);
			//drugs.setProductImages(images);
			LOGGER.info("Sucessfully Registered new Drug");
		drugs.setDrugId(Integer.valueOf(sequenceGeneratorService.generateSequence(drugs.SEQUENCE_NAME)));
		Drugs save = this.drugsRepository.save(drugs);

		return save;

	}

	public List<Drugs> getAllDetails() {
		return drugsRepository.findAll();
	}

	public Optional<Drugs> getDrugsByID(int drugId) throws CustomException, Exception {
		Optional<Drugs> drugs = Optional.empty();
		try {
			if (drugsRepository.existsByDrugId(drugId)) {
				drugs = drugsRepository.findById(drugId);
			} else {
				throw new CustomException("The mentioned ID is not listed");
			}
		} catch (CustomException e) {
			LOGGER.error("The mentioned ID is not listed" + e);
		}
		return drugs;
	}

	public List<Drugs> getDrugsBySupplierName(String supplierName) {
		return drugsRepository.findBySupplierName(supplierName);
	}

	public List<Drugs> getDrugsByName(String drugsName) {
		return drugsRepository.findByDrugsName(drugsName);
	}

	public List<Drugs> getDrugsByCategory(String categories) {
		return drugsRepository.findBycategories(categories);
	}

	/*
	 * public Inventory getDrugsWithSupplierDetails(String supplierName) throws
	 * CustomException, Exception { String name = null; Inventory response = new
	 * Inventory(); try { if (drugsRepository.existsBySupplierName(supplierName)) {
	 * List<Drugs> drugs = drugsRepository.findBySupplierName(supplierName); for
	 * (Drugs var : drugs) { name = var.getSupplierName(); }
	 *
	 * Supplier supplier =
	 * restTemplate.getForObject("http://SUPPLIER-SERVICE/supplier/details/" + name,
	 * Supplier.class); response.setDrugs(drugs); response.setSupplier(supplier); }
	 * else { LOGGER.error("The result could not be fetched"); throw new
	 * CustomException("The supplierName couldn't be fetched"); } } catch
	 * (CustomException e) { LOGGER.error("The supplierName couldn't be fetched" +
	 * e); }
	 *
	 * return response;
	 *
	 * }
	 */

	/*
	 * public Drugs updateDrugsByCart(String username, String drugsId, Drugs drugs)
	 * {
	 *
	 * Cart cart = restTemplate
	 * .getForObject("http://DRUGS-MICROSERVICE/drugs/cart/username/" + drugsId +
	 * "/" + username, Cart.class); int x = cart.getDrugsQty();
	 *
	 * Drugs drugs1 = restTemplate.getForObject("http://DRUGS-MICROSERVICE/drugs/" +
	 * drugsId, Drugs.class); int y = drugs1.getStockQty();
	 *
	 * int z = y - x;
	 *
	 * drugs.setStockQty(z);
	 *
	 * drugsRepository.save(drugs);
	 *
	 * return drugs;
	 */

	//}

	public Drugs updateDrugsDetails(int drugId,Drugs drugs) throws CustomException, Exception {
		   Drugs    updateddrugs=drugsRepository.findById(drugId).orElseThrow(()-> new CustomException());

		updateddrugs.setCategories(drugs.getCategories());
        updateddrugs.setDrugsDescription(drugs.getDrugsDescription());

        updateddrugs.setDrugsCost(drugs.getDrugsCost());
        updateddrugs.setDrugId(drugs.getDrugId());
        updateddrugs.setDrugsName(drugs.getDrugsName());
        updateddrugs.setStockQty(drugs.getStockQty());
        updateddrugs.setSupplierName(drugs.getSupplierName());
        updateddrugs.setDateOfExpiration(drugs.getDateOfExpiration());


        final Drugs finalUpdateddrugs= drugsRepository.save(updateddrugs);
		return finalUpdateddrugs;
		// Drugs updatedDrugs=DrugsRepository.findById(drugsId).orElseThrow(() -> new
		// DrugNotFoundException();)
	}

	public String deleteDrugs(int drugId) {
		drugsRepository.deleteById(drugId);
		return "Deleted Successfully";
	}


	public Drugs saveDrugsDetails(Drugs drugs) {

		return drugs;
	}

	public Drugs addNewDrug(Drugs drug) {
		drug.setDrugId(sequenceGeneratorService.generateSequence(Drugs.SEQUENCE_NAME));
		return drugsRepository.save(drug);
	}



}
