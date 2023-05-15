package com.citi.converted.testdrivendevelopment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citi.converted.testdrivendevelopment.entity.Convert;

@Repository
public interface TtdCrudRepository extends JpaRepository<Convert, String> {

	Convert findByName(String convertedUnit);

}
