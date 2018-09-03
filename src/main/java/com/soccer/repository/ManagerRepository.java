package com.soccer.repository;

import com.soccer.model.Manager;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by karte on 9/3/2018.
 */
public interface ManagerRepository extends CrudRepository<Manager, Integer> {
}
