package miu.cs.ADS.service.Impl;

import miu.cs.ADS.dto.request.RoleRequest;
import miu.cs.ADS.exception.NotFoundException;
import miu.cs.ADS.repository.AppointmentRepository;
import miu.cs.ADS.repository.PatientRepository;
import miu.cs.ADS.repository.RoleRepository;
import miu.cs.ADS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private MailSenderService mailService;

    public void addRoles(Integer userId, RoleRequest roles) throws NotFoundException {

        var user = userRepository.findById(userId).orElse(null);
        if(user == null){
            throw new NotFoundException("User is not found");
        } else {

            roles.getRoles().stream()
                            .forEach(role -> {
                                var roleId = roleRepository.findByRoleName(role.getRoleName());
                                role.setId(roleId.getId());
                            });

            user.setRoles(roles.getRoles());
            userRepository.save(user);
        }
    }

    public void approveRequest(Integer patientId, Integer appointmentId) throws NotFoundException {
        var patient = patientRepository.findById(patientId).orElse(null);
        var appt = appointmentRepository.findById(appointmentId).orElse(null);
        if(patient == null){
            throw new NotFoundException("Patient is not available");
        } else if (appt == null) {
            throw new NotFoundException("Appointment is not available");
        }else {
            appointmentRepository.updatePatientAppointment(appointmentId,patientId);
            mailService.sendEmail(patient.getEmail(), patient.getFname(), patient.getLname(),appt.getDate(),appt.getTime());
        }
    }
}
