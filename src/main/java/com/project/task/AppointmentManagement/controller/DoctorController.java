package com.project.task.AppointmentManagement.controller;

import com.project.task.AppointmentManagement.model.Doctor;
import com.project.task.AppointmentManagement.repository.DoctorRepository;
import com.project.task.AppointmentManagement.service.IDoctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private IDoctor doctorService;
    @GetMapping
    public List<Doctor> getAllDoctors() {
        return  doctorService.getAllDoctors();
    }
    @PostMapping("/add-doctor")
    public ResponseEntity<String> addDoctor(@RequestBody Doctor doctor)
    {
        boolean saved =   doctorService.addDoctor(doctor);
        if(saved)
        {
            return ResponseEntity.status(HttpStatus.OK).body("Doctor saved successfully in database");
        }
        else
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error in saving doctor!!!");
        }
    }
    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }
}
