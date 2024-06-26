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

        personneCreated.setNom(personne.getNom());
        personneCreated.setPrenom(personne.getPrenom());
        personneCreated.setPays(personne.getPays());

        return personneRepository.save(personneCreated);

    }

    @Override
    public Personne findPersonne(UUID id) throws Exception {

        Optional<Personne> opt = personneRepository.findById(id);

        if(opt.isPresent()){
            return opt.get();
        }
        throw new  Exception("la personne avec id suivant n'a pas été trouvé " +id);

    }

    @Override
    public Personne updatePersonne(Personne personne, UUID id) throws Exception {

        Personne oldPersonne = findPersonne(id);

        if(oldPersonne.getNom() !=null){
            oldPersonne.setNom(personne.getNom());
        }

        if(oldPersonne.getPrenom() !=null){

            oldPersonne.setPrenom(personne.getPrenom());
        }
        if(oldPersonne.getPays() !=null){

            oldPersonne.setPays(personne.getPays());
        }
        return personneRepository.save(oldPersonne);
    }

    @Override
    public void deletePersonne(UUID id) throws Exception {

        findPersonne(id);

        personneRepository.deleteById(id);

    }
}
