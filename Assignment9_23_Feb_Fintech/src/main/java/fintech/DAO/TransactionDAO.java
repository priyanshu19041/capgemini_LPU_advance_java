package fintech.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Fintech.BankAccount;
import Fintech.Transaction;
import Fintech.Main.JPAUtil;

public class TransactionDAO {

    public void save(Transaction txn, Long accountId) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        BankAccount account = em.find(BankAccount.class, accountId);
        account.addTransaction(txn);
        em.persist(txn);
        em.getTransaction().commit();
        em.close();
    }

    public List<Transaction> findByAccount(Long accountId) {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Transaction> query =
                em.createQuery(
                        "SELECT t FROM Transaction t WHERE t.bankAccount.accountId = :id",
                        Transaction.class);
        query.setParameter("id", accountId);
        List<Transaction> list = query.getResultList();
        em.close();
        return list;
    }

    public List<Transaction> findByType(Long accountId, String type) {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Transaction> query =
                em.createQuery(
                        "SELECT t FROM Transaction t WHERE t.bankAccount.accountId = :id AND t.txnType = :type ORDER BY t.txnDate DESC",
                        Transaction.class);
        query.setParameter("id", accountId);
        query.setParameter("type", type);
        List<Transaction> list = query.getResultList();
        em.close();
        return list;
    }
}