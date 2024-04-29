package miu.cs.ADS.service;

import miu.cs.ADS.dto.response.DentistDto;
import miu.cs.ADS.exception.NotFoundException;
import miu.cs.ADS.model.Dentist;

import java.util.List;

public interface DentistService {
    public List<DentistDto> getAllDentist();
    public Dentist getDentist(Integer id);
    List<Dentist> searchDentist(String query);
    public void addDentist(Dentist dentist);
    public Dentist updateDentist(Integer id, Dentist dentist)  throws NotFoundException;
    public void addAppointment(Integer did, Integer aid) throws NotFoundException;
    public void deleteDentist(Integer id)  throws NotFoundException;
}