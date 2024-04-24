package com.project.task.AppointmentManagement.service;

import com.project.task.AppointmentManagement.model.Doctor;

import java.util.List;

public interface IDoctor {
    List<Doctor> getAllDoctors();

    Doctor getDoctorById(Long id);

    boolean addDoctor(Doctor doctor);
}
