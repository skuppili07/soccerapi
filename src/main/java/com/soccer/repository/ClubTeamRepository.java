package com.soccer.repository;

import com.soccer.model.ClubTeam;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Team Gryffindor on 9/3/2018.
 */
public interface ClubTeamRepository extends CrudRepository<ClubTeam, Integer> {
}
