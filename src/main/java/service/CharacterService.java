package service;

import entities.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CharacterRepository;

import java.util.AbstractCollection;
import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    @Autowired
    CharacterRepository characterRepository;

    //creating a character
    public Actor createActor(Actor actor){
        return characterRepository.save(actor);
    }

    //Find all actors
    public List<Actor> getActors(){
        return characterRepository.findAll();
    }

    //deleting
    public void deleteActor(Long id){
        characterRepository.deleteById(id);
    }

    //update
    public Actor updateActor(Long id,Actor actorDetails){
        Optional<Actor> actorToBeUpdated = characterRepository.findById(id);
        if (actorToBeUpdated != null) {
            Actor gottenActor = actorToBeUpdated.get();
            gottenActor.setName(actorDetails.getName());
            gottenActor.setRace(actorDetails.getRace());
            gottenActor.setStrength(actorDetails.getStrength());
            gottenActor.setDexterity(actorDetails.getDexterity());
            gottenActor.setWisdom(actorDetails.getWisdom());
            characterRepository.save(gottenActor);
        }
        return null;
    }

}
