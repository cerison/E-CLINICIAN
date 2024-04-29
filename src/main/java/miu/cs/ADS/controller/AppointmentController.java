package miu.cs.ADS.controller;

import miu.cs.ADS.dto.response.AppointmentDto;
import miu.cs.ADS.model.Appointment;
import miu.cs.ADS.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ads/api/v1/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @GetMapping()
    public List<AppointmentDto> getAllAppointment(){
        return appointmentService.getAllAppointment();
    }

    @PostMapping()
    public void addAppointment(@RequestBody Appointment appointment){
        appointmentService.addAppointment(appointment);
    }

    @GetMapping("/{id}")
    public AppointmentDto getAllAppointment(@PathVariable Integer id){
        return appointmentService.getAppointment(id);
    }
}
