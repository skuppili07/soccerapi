package com.soccer.repository;

import com.soccer.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Team Gryffindor on 9/3/2018.
 */
public interface ClubRepository extends JpaRepository<Club, Integer> {
}
