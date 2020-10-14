package com.msglife.insurance.springboot.crudrestfullwebservices.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msglife.insurance.springboot.crudrestfullwebservices.exception.ResourceNotFoundException;
import com.msglife.insurance.springboot.crudrestfullwebservices.model.Country;
import com.msglife.insurance.springboot.crudrestfullwebservices.model.Vehicle;
import com.msglife.insurance.springboot.crudrestfullwebservices.repository.CountryRepository;
import com.msglife.insurance.springboot.crudrestfullwebservices.repository.VehicleRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class CrudController {
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	//COUNTRIES:
	
	//get all countries
	@GetMapping("/countries")
	public List<Country> getAllCountries(){
		return countryRepository.findAll();
	}
	
	//create country
	@PostMapping("/countries")
	public Country createCountry(@Valid @RequestBody Country country) {
		return countryRepository.save(country); 
	}
	
	//get country by id
	@GetMapping("/countries/{id}")
	public ResponseEntity<Country> getCountryById(@PathVariable(value = "id")long countryId) 
			throws ResourceNotFoundException {
		Country country = countryRepository.findById(countryId)
				.orElseThrow(()->new ResourceNotFoundException("Country not found for this id ::"+ countryId));
		return ResponseEntity.ok().body(country);
	}
	
	//update Country
	@PutMapping("/countries/{id}")
	public ResponseEntity<Country> updateCountry(@PathVariable(value = "id")long countryId, @RequestBody Country countryDetails) 
			throws ResourceNotFoundException {
		Country country = countryRepository.findById(countryId)
				.orElseThrow(()->new ResourceNotFoundException("Country not found for this id ::" + countryId));
		
		country.setCountryName(countryDetails.getCountryName());
		country.setDeathRate(countryDetails.getDeathRate());
		country.setCountryCode(countryDetails.getCountryCode());
		countryRepository.save(country);
		
		return ResponseEntity.ok().body(country);
	}
	
	//delete country
	@DeleteMapping("/countries/{id}")
	public ResponseEntity<?> deleteCountry(@PathVariable(value = "id")long countryId) 
			throws ResourceNotFoundException {
		countryRepository.findById(countryId)
			.orElseThrow(()-> new ResourceNotFoundException("Country not found for this id ::"+countryId));
		
		countryRepository.deleteById(countryId);
		return ResponseEntity.ok().build();
	}
	
	//VEHICLES:
	
	//get all vehicles
	@GetMapping("/vehicles")
	public List<Vehicle> getAllVehicles(){
		return vehicleRepository.findAll();
	}
	
	//create vehicle
	@PostMapping("/vehicles")
	public Vehicle createVehicle(@Valid @RequestBody Vehicle vehicle) {
		return vehicleRepository.save(vehicle); 
	}
	
	//get vehicle by id
	@GetMapping("/vehicles/{id}")
	public ResponseEntity<Vehicle> getVehicleById(@PathVariable(value = "id")long vehicleId) 
			throws ResourceNotFoundException {
		Vehicle vehicle = vehicleRepository.findById(vehicleId)
				.orElseThrow(()->new ResourceNotFoundException("Vehicle not found for this id ::"+ vehicleId));
		return ResponseEntity.ok().body(vehicle);
	}
	
	//update vehicle
	@PutMapping("/vehicles/{id}")
	public ResponseEntity<Vehicle> updateVehicle(@PathVariable(value = "id")long vehicleId, @RequestBody Vehicle vehicleDetails) 
			throws ResourceNotFoundException {
		Vehicle vehicle = vehicleRepository.findById(vehicleId)
				.orElseThrow(()->new ResourceNotFoundException("Vehicle not found for this id ::" + vehicleId));
		
		vehicle.setDoorNumber(vehicleDetails.getDoorNumber());
		vehicle.setVehicleName(vehicleDetails.getVehicleName());
		vehicle.setMaxPower(vehicleDetails.getMaxPower());
		vehicle.setMinPower(vehicleDetails.getMinPower());
		vehicleRepository.save(vehicle);
		
		return ResponseEntity.ok().body(vehicle);
	}
	
	//delete vehicle
	@DeleteMapping("/vehicles/{id}")
	public ResponseEntity<?> deleteVehicle(@PathVariable(value = "id")long vehicleId) 
			throws ResourceNotFoundException {
		vehicleRepository.findById(vehicleId)
			.orElseThrow(()-> new ResourceNotFoundException("Vehicle not found for this id ::" + vehicleId));
		
		vehicleRepository.deleteById(vehicleId);
		return ResponseEntity.ok().build();
	}
	
	
	
	
	
	

}
