package com.project.task.AppointmentManagement.service;

import com.project.task.AppointmentManagement.model.Appointment;
import com.project.task.AppointmentManagement.model.Doctor;
import com.project.task.AppointmentManagement.repository.AppointmentRepository;
import com.project.task.AppointmentManagement.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentImpl implements IAppointment{
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;
    public List<String> getDoctorAvailability(Long id,String date) {
        Doctor doctor = doctorRepository.findById(id).orElse(null);
        if (doctor == null) {
            return null; // Handle doctor not found scenario
        }

        List<Appointment> appointments = appointmentRepository.findByDoctorAndDate(doctor, date);
        // Assuming each appointment has a time field
        List<String> bookedSlots = appointments.stream().map(Appointment::getTime).toList();

        // Logic to generate available slots based on doctor's schedule
        List<String> availableSlots = generateAvailableSlots(doctor.getAvailableDays());

        // Remove booked slots from available slots
        availableSlots.removeAll(bookedSlots);

        return availableSlots;
    }
    // Helper method to generate available slots based on doctor's schedule
    private List<String> generateAvailableSlots(List<String> availableDays) {
        List<String> availableSlots = new ArrayList<>();

        for (String day : availableDays) {
            // Assuming the doctor works from 6:00 PM to 9:00 PM (you can adjust as per your requirements)
            int startHour = 18; // 6:00 PM
            int endHour = 21;   // 9:00 PM

            // Generate time slots for each available day
            for (int hour = startHour; hour < endHour; hour++) {
                availableSlots.add(String.format("%02d:00 - %02d:30", hour, hour));
                availableSlots.add(String.format("%02d:30 - %02d:00", hour, hour + 1));
            }
        }

        return availableSlots;
    }
}
