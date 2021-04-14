package ch.demo.gpietro.controllers;

import ch.demo.gpietro.entities.Patient;
import ch.demo.gpietro.services.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        Assert.notNull(patientService, "PatientService must not be null!");
        this.patientService = patientService;
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable("id") long id) {
        Patient patient = patientService.findById(id);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getPatients() {
        List<Patient> patients = patientService.findAll();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @PostMapping("/patients")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> createPatient(@RequestBody Patient patient) {
        Patient createdPatient = patientService.save(patient);
        // Build location URI of the created patient
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(createdPatient.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/patients/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePatient(@PathVariable("id") long id, @RequestBody Patient patient) {
        patient.setId(id);
        patientService.save(patient);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePatient(@PathVariable("id") long id) {
        patientService.delete(patientService.findById(id));
    }

}