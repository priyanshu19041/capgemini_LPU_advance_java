package fintech.DAO;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Fintech.BankAccount;
import Fintech.Customer;
import Fintech.Main.JPAUtil;

public class BankAccountDAO {

    public void save(BankAccount account) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(account);
        em.getTransaction().commit();
        em.close();
    }

    public BankAccount findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        BankAccount account = em.find(BankAccount.class, id);
        em.close();
        return account;
    }

    public BankAccount findByAccountNumber(String accNumber) {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<BankAccount> query =
                em.createQuery("SELECT b FROM BankAccount b WHERE b.accountNumber = :acc",
                        BankAccount.class);
        query.setParameter("acc", accNumber);
        BankAccount account;
        try {
            account = query.getSingleResult();
        } catch (Exception e) {
            account = null;
        }
        em.close();
        return account;
    }

    public void linkToCustomer(Long accountId, Long customerId) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        BankAccount account = em.find(BankAccount.class, accountId);
        Customer customer = em.find(Customer.class, customerId);
        account.setCustomer(customer);
        customer.setBankAccount(account);
        em.getTransaction().commit();
        em.close();
    }

    public void updateBalance(Long accountId, BigDecimal balance) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        BankAccount account = em.find(BankAccount.class, accountId);
        account.setBalance(balance);
        em.getTransaction().commit();
        em.close();
    }

    public List<BankAccount> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<BankAccount> query =
                em.createQuery("SELECT b FROM BankAccount b", BankAccount.class);
        List<BankAccount> list = query.getResultList();
        em.close();
        return list;
    }
}