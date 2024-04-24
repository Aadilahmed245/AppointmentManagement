package com.project.task.AppointmentManagement.service;

import java.util.List;

public interface IAppointment {
    List<String> getDoctorAvailability(Long id, String date);
}
