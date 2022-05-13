package com.eni.demojpa.key1;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("demo")
public interface PersonnePK1Repository extends CrudRepository<Personne, PersonnePK> {
}
