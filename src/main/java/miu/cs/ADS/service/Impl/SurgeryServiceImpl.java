package miu.cs.ADS.service.Impl;

import miu.cs.ADS.exception.NotFoundException;
import miu.cs.ADS.model.Appointment;
import miu.cs.ADS.model.Surgery;
import miu.cs.ADS.repository.AppointmentRepository;
import miu.cs.ADS.repository.SurgeryRepository;
import miu.cs.ADS.service.SurgeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurgeryServiceImpl implements SurgeryService {
    @Autowired
    SurgeryRepository surgeryRepository;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Override
    public List<Surgery> getAllSurgery() {
        return surgeryRepository.findAll();
    }

    @Override
    public Surgery getSurgery(Integer id) {
        return surgeryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Surgery> searchSurgery(String query) {
        return surgeryRepository.findByNameContaining(query);
    }

    @Override
    public void addSurgery(Surgery surgery) {
        surgeryRepository.save(surgery);
    }

    @Override
    public Surgery updateSurgery(Integer id, Surgery surgery) throws NotFoundException {
        Surgery surgery1 = getSurgery(id);
        if(surgery1 == null){
            throw  new NotFoundException("Surgery is not available");
        }
        else{
            surgery.setId(surgery1.getId());
        }
        return surgeryRepository.save(surgery);
    }

    @Override
    public void addAppointment(Integer sid, Integer aid) throws NotFoundException{
        Surgery surgery = getSurgery(sid);
        Appointment appointment = appointmentRepository.findById(aid).orElse(null);
        if(surgery == null){
            throw  new NotFoundException("Surgery is not available");
        }else if(appointment == null){
            throw  new NotFoundException("Appointment is not available");
        } else{
            appointmentRepository.updateSurgeryAppointment(aid,sid);
        }
    }

    @Override
    public void deleteSurgery(Integer id) throws NotFoundException {
        Surgery surgery1 = getSurgery(id);
        if(surgery1 == null){
            throw  new NotFoundException("Surgery is not available");
        }
        else{
            surgeryRepository.deleteById(id);
        }
    }
}