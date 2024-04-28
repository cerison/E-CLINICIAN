package miu.cs.ads_datapersisitence.controller;

import jakarta.mail.MessagingException;
import miu.cs.ads_datapersisitence.exception.NotFoundException;
import miu.cs.ads_datapersisitence.service.Impl.MailSenderService;
import miu.cs.ads_datapersisitence.service.Impl.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping(value = "/ads/api/v1/manager")
public class ManagerController {

    @Autowired
    ManagerService managerService;

    @PostMapping("/approve/{patientId}/{appointmentId}")
    public void approveRequest(@PathVariable Integer patientId, @PathVariable Integer appointmentId) throws NotFoundException {
        managerService.approveRequest(patientId, appointmentId);
    }
}