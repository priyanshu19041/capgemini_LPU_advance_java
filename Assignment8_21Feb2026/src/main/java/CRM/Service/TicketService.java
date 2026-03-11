package CRM.Service;

import javax.persistence.EntityManager;

import CRM.application.JPAUtil;
import CRM.application.OrderEntity;
import CRM.application.SupportTicket;

public class TicketService {
    public void raiseTicket(Long orderId, String issue) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        OrderEntity o = em.find(OrderEntity.class, orderId);
        SupportTicket t = new SupportTicket();
        t.setIssueDescription(issue);
        t.setOrder(o);

        em.persist(t);
        em.getTransaction().commit();
        em.close();
    }
}
