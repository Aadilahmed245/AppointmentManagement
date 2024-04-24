package com.project.task.AppointmentManagement.controller;

import com.project.task.AppointmentManagement.model.Doctor;
import com.project.task.AppointmentManagement.repository.AppointmentRepository;
import com.project.task.AppointmentManagement.service.IAppointment;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private IAppointment appointmentService;

    @PostMapping("/book")
    public AppointmentRepository bookAppointment(@RequestBody AppointmentRepository appointment) {
        return null;
    }
    @GetMapping("/{id}/availability")
    public List<String> getDoctorAvailability(@PathVariable Long id, @RequestParam String date) {
       return appointmentService.getDoctorAvailability(id,date);
    }


}
