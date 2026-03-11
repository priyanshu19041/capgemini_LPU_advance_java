package fintech.Main;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Fintech.BankAccount;
import Fintech.Card;
import Fintech.Customer;
import Fintech.Transaction;
import Fintech.DAO.BankAccountDAO;
import Fintech.DAO.CardDAO;
import Fintech.DAO.CustomerDAO;
import Fintech.DAO.TransactionDAO;

public class FintechApp {

    static CustomerDAO customerDAO = new CustomerDAO();
    static BankAccountDAO accountDAO = new BankAccountDAO();
    static TransactionDAO transactionDAO = new TransactionDAO();
    static CardDAO cardDAO = new CardDAO();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            System.out.println("1 Add Customer");
            System.out.println("2 View Customers");
            System.out.println("3 Create Account");
            System.out.println("4 Link Account to Customer");
            System.out.println("5 Record Transaction");
            System.out.println("6 View Transactions");
            System.out.println("7 Issue Card");
            System.out.println("8 Assign Card to Customer");
            System.out.println("9 View Cards");
            System.out.println("10 Deactivate Card");
            System.out.println("0 Exit");

            String choice = sc.nextLine();

            switch (choice) {
                case "1": addCustomer(); break;
                case "2": viewCustomers(); break;
                case "3": createAccount(); break;
                case "4": linkAccount(); break;
                case "5": recordTransaction(); break;
                case "6": viewTransactions(); break;
                case "7": issueCard(); break;
                case "8": assignCard(); break;
                case "9": viewCards(); break;
                case "10": deactivateCard(); break;
                case "0":
                    running = false;
                    JPAUtil.close();
                    break;
            }
        }
    }

    static void addCustomer() {
        System.out.println("Name:");
        String name = sc.nextLine();
        System.out.println("Email:");
        String email = sc.nextLine();
        System.out.println("Phone:");
        String phone = sc.nextLine();

        Customer c = new Customer(name, email, phone);
        c.setCards(new ArrayList<>());
        customerDAO.save(c);
    }

    static void viewCustomers() {
        List<Customer> list = customerDAO.findAll();
        for (Customer c : list) {
            System.out.println(c.getCustomerId() + " " + c.getFullName());
        }
    }

    static void createAccount() {
        System.out.println("Account Number:");
        String num = sc.nextLine();
        System.out.println("Type:");
        String type = sc.nextLine();
        System.out.println("Balance:");
        BigDecimal bal = new BigDecimal(sc.nextLine());

        BankAccount acc = new BankAccount(num, type, bal);
        accountDAO.save(acc);
    }

    static void linkAccount() {
        System.out.println("Account ID:");
        Long accId = Long.parseLong(sc.nextLine());
        System.out.println("Customer ID:");
        Long custId = Long.parseLong(sc.nextLine());
        accountDAO.linkToCustomer(accId, custId);
    }

    static void recordTransaction() {
        System.out.println("Account ID:");
        Long accId = Long.parseLong(sc.nextLine());
        System.out.println("Type:");
        String type = sc.nextLine();
        System.out.println("Amount:");
        BigDecimal amt = new BigDecimal(sc.nextLine());
        System.out.println("Description:");
        String desc = sc.nextLine();
        System.out.println("Reference:");
        String ref = sc.nextLine();

        Transaction t = new Transaction();
        t.setTxnType(type);
        t.setAmount(amt);
        t.setDescription(desc);
        t.setReferenceNumber(ref);
        t.setTxnDate(LocalDateTime.now());

        transactionDAO.save(t, accId);
    }

    static void viewTransactions() {
        System.out.println("Account ID:");
        Long accId = Long.parseLong(sc.nextLine());
        List<Transaction> list = transactionDAO.findByAccount(accId);
        for (Transaction t : list) {
            System.out.println(t.getTransactionId() + " " + t.getTxnType() + " " + t.getAmount());
        }
    }

    static void issueCard() {
        System.out.println("Card Number:");
        String num = sc.nextLine();
        System.out.println("Type:");
        String type = sc.nextLine();
        System.out.println("Network:");
        String net = sc.nextLine();
        System.out.println("Expiry (yyyy-mm-dd):");
        LocalDate date = LocalDate.parse(sc.nextLine());
        System.out.println("Account ID:");
        Long accId = Long.parseLong(sc.nextLine());

        Card card = new Card();
        card.setCardNumber(num);
        card.setCardType(type);
        card.setCardNetwork(net);
        card.setExpiryDate(date);

        cardDAO.issueCard(card, accId);
    }

    static void assignCard() {
        System.out.println("Card ID:");
        Long cardId = Long.parseLong(sc.nextLine());
        System.out.println("Customer ID:");
        Long custId = Long.parseLong(sc.nextLine());
        cardDAO.assignCardToCustomer(cardId, custId);
    }

    static void viewCards() {
        List<Card> list = cardDAO.findAll();
        for (Card c : list) {
            System.out.println(c.getCardId() + " " + c.getCardNumber() + " " + c.getIsActive());
        }
    }

    static void deactivateCard() {
        System.out.println("Card ID:");
        Long id = Long.parseLong(sc.nextLine());
        cardDAO.deactivateCard(id);
    }
}
