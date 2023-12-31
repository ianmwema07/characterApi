package com.example.characterAPI.controllers;


import com.example.characterAPI.entities.Actor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.characterAPI.service.CharacterService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ActorController {
    //    private static Logger logger = LoggerFactory.getLogger();
    private static Logger logger = LoggerFactory.getLogger(ActorController.class);

    @Autowired
    CharacterService actorService;

    @RequestMapping(value = "/actor", method = RequestMethod.POST)
    public Actor CreateActor(@RequestBody Actor actor) {
        return actorService.createActor(actor);
    }

    @RequestMapping(value = "/actors", method = RequestMethod.GET)
    public List<Actor> allActors() {
        return actorService.getActors();
    }

    @RequestMapping(value = "/actors/{actorId}", method = RequestMethod.PUT)
    public Actor updateActorDetails(@PathVariable(value = "actorId") Long id, @RequestBody Actor actorDetails) {
        try {
            return actorService.updateActor(id, actorDetails);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }

}
