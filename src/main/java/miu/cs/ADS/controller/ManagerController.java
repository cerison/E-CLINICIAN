package miu.cs.ADS.controller;

import miu.cs.ADS.dto.request.RoleRequest;
import miu.cs.ADS.exception.NotFoundException;
import miu.cs.ADS.service.Impl.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/ads/api/v1/manager")
public class ManagerController {

    @Autowired
    ManagerService managerService;
    @PostMapping("/addRole/{userId}")
    public void addRoles(@PathVariable Integer userId, @RequestBody RoleRequest roles) throws NotFoundException {
        managerService.addRoles(userId, roles);
    }
    @PostMapping("/approve/{patientId}/{appointmentId}")
    public void approveRequest(@PathVariable Integer patientId, @PathVariable Integer appointmentId) throws NotFoundException {
        managerService.approveRequest(patientId, appointmentId);
    }
}