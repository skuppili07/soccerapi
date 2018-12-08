package com.soccer.repository;


import com.soccer.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    @Query(value = "select * from  player pl where pl.first_name like :playerName", nativeQuery = true)
    public List<Player> fetchPlayerByName(@Param("playerName") String playerName);
}