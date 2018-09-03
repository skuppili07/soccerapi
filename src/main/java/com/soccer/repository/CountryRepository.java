package com.soccer.repository;

import com.soccer.model.Country;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by karte on 9/3/2018.
 */
public interface CountryRepository extends CrudRepository<Country, Integer> {
}
