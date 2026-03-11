package CRM.Service;

import javax.persistence.EntityManager;

import CRM.application.JPAUtil;

public class ReportService {
    public void getEmployeePerformance(Long empId) {
        EntityManager em = JPAUtil.getEntityManager();

        Long count = em.createQuery(
                "SELECT COUNT(l) FROM Lead l WHERE l.employee.id = :id",
                Long.class
        ).setParameter("id", empId).getSingleResult();

        System.out.println(count);
        em.close();
    }
}