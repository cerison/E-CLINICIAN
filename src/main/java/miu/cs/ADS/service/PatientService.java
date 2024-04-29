package miu.cs.ADS.service;

import miu.cs.ADS.dto.response.PatientAppointmentDto;
import miu.cs.ADS.exception.NotFoundException;
import miu.cs.ADS.model.Appointment;
import miu.cs.ADS.model.Patient;

import java.util.List;

public interface PatientService {
    public List<Patient> getAllPatient();
    public PatientAppointmentDto getPatient(Integer id);
    public Patient findPatient(Integer id);
    List<Patient> searchPatient(String query);
    public void addPatient(Patient patient);
    public void requestAppointment(Integer pid, Appointment appointment)  throws NotFoundException;
    public Patient updatePatient(Integer id, Patient patient)  throws NotFoundException;
    public void deletePatient(Integer id)  throws NotFoundException;
}
