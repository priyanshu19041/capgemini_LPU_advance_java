package com.assignment5;

import jakarta.persistence.EntityManager;

import java.util.List;

public class HospitalService {

    PatientDAO patientDAO = new PatientDAO();
    DoctorDAO doctorDAO = new DoctorDAO();
    AppointmentDAO appointmentDAO = new AppointmentDAO();

    public void registerPatient(EntityManager em, Patient p, MedicalRecord m) {
        em.persist(m);              
        p.setMedicalRecord(m);
        patientDAO.savePatient(em, p);
    }

    public void addAppointmentsToDoctor(EntityManager em, Doctor d, List<Appointment> apps) {
        for (Appointment a : apps) { 
            em.persist(a);
        }
        d.setAppointments(apps);
        doctorDAO.saveDoctor(em, d);
    }

    public void assignAppointmentToPatient(EntityManager em, Appointment a, Patient p) {
        em.persist(p); 
        a.setPatient(p);
        appointmentDAO.saveAppointment(em, a);
    }

    public void updateAppointmentFee(EntityManager em, int id, double fee) {
        appointmentDAO.updateFee(em, id, fee);
    }

    public Doctor fetchDoctor(EntityManager em, int id) {
        return doctorDAO.findDoctor(em, id);
    }
}