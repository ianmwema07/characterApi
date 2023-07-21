package com.example.characterAPI.repositories;

import com.example.characterAPI.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Actor, Long> {
}
