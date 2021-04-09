package ch.demo.gpietro.repositories;

import ch.demo.gpietro.entities.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

    @Override
    List<Patient> findAll();
}
