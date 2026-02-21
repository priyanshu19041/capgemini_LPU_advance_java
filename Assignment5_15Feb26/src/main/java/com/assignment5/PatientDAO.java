
package com.assignment5;

import jakarta.persistence.*;

public class PatientDAO {

    public void savePatient(EntityManager em, Patient patient) {
        em.persist(patient);
    }

    public Patient findPatient(EntityManager em, int id) {
        return em.find(Patient.class, id);
    }

    public void updatePatient(EntityManager em, Patient patient) {
        em.merge(patient);
    }

    public void deletePatient(EntityManager em, Patient patient) {
        em.remove(patient);
    }
}
