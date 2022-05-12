package fr.eni.demojpa.key1;

import fr.eni.demojpa.key1.Personne;
import fr.eni.demojpa.key1.PersonnePK;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("demo")
public interface PersonnePK1Repository extends CrudRepository<Personne, PersonnePK> {
}
