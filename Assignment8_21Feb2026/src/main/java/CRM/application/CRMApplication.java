package CRM.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import CRM.applicationService.CustomerService;
import CRM.applicationService.LeadService;
import CRM.applicationService.OrderService;
import CRM.applicationService.ProductService;
import CRM.applicationService.ReportService;
import CRM.applicationService.TicketService;

public class CRMApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CustomerService customerService = new CustomerService();
        LeadService leadService = new LeadService();
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();
        TicketService ticketService = new TicketService();
        ReportService reportService = new ReportService();

        while (true) {
            System.out.println("1 Register Customer");
            System.out.println("2 Add Address");
            System.out.println("3 Create Lead");
            System.out.println("4 Assign Lead");
            System.out.println("5 Add Product");
            System.out.println("6 Place Order");
            System.out.println("7 Raise Ticket");
            System.out.println("8 Employee Report");
            System.out.println("9 Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.next();
                    System.out.print("Email: ");
                    String email = sc.next();
                    System.out.print("Phone: ");
                    String phone = sc.next();
                    customerService.registerCustomer(name, email, phone);
                    break;

                case 2:
                    System.out.print("Customer ID: ");
                    Long cid = sc.nextLong();
                    Address a = new Address();
                    a.setStreet(sc.next());
                    a.setCity(sc.next());
                    a.setState(sc.next());
                    a.setZipCode(sc.next());
                    customerService.addAddressToCustomer(cid, a);
                    break;

                case 3:
                    leadService.createLead(sc.next(), sc.next(), sc.next());
                    break;

                case 4:
                    leadService.assignLeadToEmployee(sc.nextLong(), sc.nextLong());
                    break;

                case 5:
                    productService.addProduct(sc.next(), sc.nextDouble());
                    break;

                case 6:
                    System.out.print("Customer ID: ");
                    Long custId = sc.nextLong();
                    System.out.print("Product count: ");
                    int n = sc.nextInt();
                    List<Long> ids = new ArrayList<>();
                    for (int i = 0; i < n; i++) ids.add(sc.nextLong());
                    orderService.placeOrder(custId, ids);
                    break;

                case 7:
                    ticketService.raiseTicket(sc.nextLong(), sc.next());
                    break;

                case 8:
                    reportService.getEmployeePerformance(sc.nextLong());
                    break;

                case 9:
                    sc.close();
                    return;
            }
        }
    }
}