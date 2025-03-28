package com.cyngofokglobal.patientservice.service;

import com.cyngofokglobal.patientservice.dto.PatientRequestDTO;
import com.cyngofokglobal.patientservice.dto.PatientResponseDTO;
import com.cyngofokglobal.patientservice.mapper.PatientMapper;
import com.cyngofokglobal.patientservice.model.Patient;
import com.cyngofokglobal.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getPatients() {
        List<Patient> patients = patientRepository.findAll();

        return patients.stream()
                .map(PatientMapper::toDTO).toList();
    }

    public  PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO){
        Patient newPatient = patientRepository.save(
                PatientMapper.toModel(patientRequestDTO));

        return PatientMapper.toDTO(newPatient);
    }

}


