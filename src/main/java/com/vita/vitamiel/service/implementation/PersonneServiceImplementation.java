package com.vita.vitamiel.service.implementation;

import com.vita.vitamiel.model.Personne;
import com.vita.vitamiel.repository.PersonneRepository;
import com.vita.vitamiel.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PersonneServiceImplementation implements PersonneService {

    @Autowired
    private PersonneRepository personneRepository;

    @Override
    public Personne createPersonne(Personne personne) {
        Personne personneCreated = new Personne();

        personneCreated.setNom(personneCreated.getNom());
        personneCreated.setPrenom(personneCreated.getPrenom());
        personneCreated.setPays(personneCreated.getPays());

        return personneRepository.save(personneCreated);

    }

    @Override
    public Personne findPersonne(UUID id) throws Exception {

        Optional<Personne> personneOptional = personneRepository.findById(id);

        if(personneOptional.isPresent()){
            return personneOptional.get();
        }
        throw new  Exception("la personne avec id suivant n'a pas été trouvé " +id);

    }

    @Override
    public Personne updatePersonne(Personne personne, UUID id) throws Exception {

        Personne oldPersonne = findPersonne(id);

        if(oldPersonne.getNom() !=null){
            oldPersonne.setNom(oldPersonne.getNom());
        }

        if(oldPersonne.getPrenom() !=null){

            oldPersonne.setPrenom(oldPersonne.getPrenom());
        }
        if(oldPersonne.getPays() !=null){

            oldPersonne.setPays(oldPersonne.getPays());
        }
        return personneRepository.save(oldPersonne);
    }

    @Override
    public void deletePersonne(UUID id) throws Exception {

        findPersonne(id);

        personneRepository.deleteById(id);

    }
}
