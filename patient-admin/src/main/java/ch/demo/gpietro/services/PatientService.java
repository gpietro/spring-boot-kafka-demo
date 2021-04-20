package ch.demo.gpietro.services;

import ch.demo.gpietro.entities.Patient;
import ch.demo.gpietro.repositories.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        Assert.notNull(patientRepository, "PatientRepository must not be null!");
        this.patientRepository = patientRepository;
    }

    public List<Patient> findAll() {
        List<Patient> patients = patientRepository.findAll();
        return patients;
    }

    public Patient findById(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        Assert.isTrue(patient.isPresent(), "Patient not found!");
        return patient.get();
    }

    public Patient save(final Patient patient) {
        Assert.notNull(patient, "Patient must not be null");
        return patientRepository.save(patient);
    }

    @Transactional(readOnly = false)
    public void delete(Patient patient) {
        patientRepository.delete(patient);
    }
}
