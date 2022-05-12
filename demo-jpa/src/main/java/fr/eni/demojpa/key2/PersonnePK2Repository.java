package fr.eni.demojpa.key2;

import fr.eni.demojpa.key2.Personne;
import fr.eni.demojpa.key1.PersonnePK;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("demo")
public interface PersonnePK2Repository extends CrudRepository<Personne, PersonnePK> {
}
