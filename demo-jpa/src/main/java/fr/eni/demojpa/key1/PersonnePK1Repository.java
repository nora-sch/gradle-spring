package fr.eni.demojpa.key1;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

public interface PersonnePK1Repository extends CrudRepository<Personne, PersonnePK> {
}
