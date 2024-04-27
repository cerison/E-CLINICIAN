package miu.cs.ads_datapersisitence.service.Impl;

import miu.cs.ads_datapersisitence.model.Patient;
import miu.cs.ads_datapersisitence.repository.PatientRepository;
import miu.cs.ads_datapersisitence.service.PatientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PatientServiceIntegrationTest {

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientServiceImpl patientService; // Using the concrete implementation

    @Test
    public void findPatient() {
        int patientId = 1;
        Patient mockPatient = new Patient();
        mockPatient.setFname("John");
        mockPatient.setPhone("123-456-7890");

        when(patientRepository.findById(patientId)).thenReturn(Optional.of(mockPatient));

        Patient foundPatient = patientService.findPatient(patientId);

        assertNotNull(foundPatient);
        assertEquals("John", foundPatient.getFname());
    }
}