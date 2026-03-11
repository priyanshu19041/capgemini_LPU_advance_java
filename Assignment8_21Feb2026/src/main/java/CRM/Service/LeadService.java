package CRM.Service;

import javax.persistence.EntityManager;

import CRM.application.JPAUtil;
import CRM.application.Lead;
import CRM.application.SalesEmployee;

public class LeadService {
    public void createLead(String name, String source, String contact) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        Lead l = new Lead();
        l.setName(name);
        l.setSource(source);
        l.setContactInfo(contact);

        em.persist(l);
        em.getTransaction().commit();
        em.close();
    }

    public void assignLeadToEmployee(Long leadId, Long empId) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        Lead l = em.find(Lead.class, leadId);
        SalesEmployee e = em.find(SalesEmployee.class, empId);
        l.setEmployee(e);

        em.getTransaction().commit();
        em.close();
    }
}