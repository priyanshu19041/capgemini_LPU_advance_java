package fintech.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Fintech.BankAccount;
import Fintech.Card;
import Fintech.Customer;
import Fintech.Main.JPAUtil;

public class CardDAO {

    public void issueCard(Card card, Long accountId) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        BankAccount account = em.find(BankAccount.class, accountId);
        card.setBankAccount(account);
        card.setIsActive(true);
        em.persist(card);
        em.getTransaction().commit();
        em.close();
    }

    public void assignCardToCustomer(Long cardId, Long customerId) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        Card card = em.find(Card.class, cardId);
        Customer customer = em.find(Customer.class, customerId);
        customer.getCards().add(card);
        em.getTransaction().commit();
        em.close();
    }

    public Card findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Card card = em.find(Card.class, id);
        em.close();
        return card;
    }

    public List<Card> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Card> query =
                em.createQuery("SELECT c FROM Card c", Card.class);
        List<Card> list = query.getResultList();
        em.close();
        return list;
    }

    public void deactivateCard(Long cardId) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        Card card = em.find(Card.class, cardId);
        card.setIsActive(false);
        em.getTransaction().commit();
        em.close();
    }
}