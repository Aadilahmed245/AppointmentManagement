package com.project.task.AppointmentManagement.repository;

import com.fasterxml.jackson.databind.DatabindException;
import com.project.task.AppointmentManagement.model.Appointment;
import com.project.task.AppointmentManagement.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
   List<Appointment> findByDoctorAndDate (Doctor doctor, String date);


}
