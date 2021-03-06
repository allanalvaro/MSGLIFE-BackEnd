package com.msglife.insurance.springboot.crudrestfullwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msglife.insurance.springboot.crudrestfullwebservices.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
