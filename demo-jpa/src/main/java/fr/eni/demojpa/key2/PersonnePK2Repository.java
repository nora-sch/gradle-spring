package fr.eni.demojpa.key2;

import fr.eni.demojpa.key2.Personne;
import fr.eni.demojpa.key1.PersonnePK;
import org.springframework.data.repository.CrudRepository;

public interface PersonnePK2Repository extends CrudRepository<Personne, PersonnePK> {
}
