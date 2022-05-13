package com.eni.demojpa.key2;

import com.eni.demojpa.key1.PersonnePK;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("demo")
public interface PersonnePK2Repository extends CrudRepository<Personne, PersonnePK> {
}
