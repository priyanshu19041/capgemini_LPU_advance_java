package com.assignment5;

import jakarta.persistence.*;

import java.util.List;

public class AppointmentDAO {

    public void saveAppointment(EntityManager em, Appointment appointment) {
        em.persist(appointment);
    }

    public List<Appointment> findAppointmentByDoctor(EntityManager em, int doctorId) {
        return em.createQuery(
            "select a from Doctor d join d.appointments a where d.id=:id",
            Appointment.class)
            .setParameter("id", doctorId)
            .getResultList();
    }

    public void updateFee(EntityManager em, int id, double fee) {
        Appointment a = em.find(Appointment.class, id);
        a.setFee(fee);
    }
}