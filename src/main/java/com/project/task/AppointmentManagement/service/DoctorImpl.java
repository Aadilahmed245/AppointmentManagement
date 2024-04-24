package com.project.task.AppointmentManagement.service;

import com.project.task.AppointmentManagement.model.Doctor;
import com.project.task.AppointmentManagement.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorImpl implements IDoctor{
    @Autowired
    private DoctorRepository doctorRepository;
    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).get();
    }

    @Override
    public boolean addDoctor(Doctor doctor) {
          Doctor save= doctorRepository.save(doctor);
          return save!=null;
    }
}
