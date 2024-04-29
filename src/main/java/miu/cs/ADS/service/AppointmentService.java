package miu.cs.ADS.service;

import miu.cs.ADS.dto.response.AppointmentDto;
import miu.cs.ADS.model.Appointment;

import java.util.List;

public interface AppointmentService {

    public List<AppointmentDto> getAllAppointment();
    public AppointmentDto getAppointment(Integer id);
    public void addAppointment(Appointment appointment);
}
