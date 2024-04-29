package miu.cs.ADS.service.Impl;

import miu.cs.ADS.model.Patient;
import miu.cs.ADS.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PatientServiceImplUnitTest {

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientServiceImpl patientService;

    @Test
    public void findPatient() {
        int patientId = 4;
        when(patientRepository.findById(patientId)).thenReturn(Optional.of(new Patient()));
        Patient patient = patientService.findPatient(patientId);
        assertNotNull(patient);
    }
}
