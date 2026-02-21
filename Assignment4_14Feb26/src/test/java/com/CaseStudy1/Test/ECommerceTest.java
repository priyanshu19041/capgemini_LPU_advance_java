package com.CaseStudy1.Test;

import com.CaseStudy1.*;
import com.CaseStudy1Service.ECommerceService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class ECommerceTest {

    @Test
    public void basicFlowTest() {

        ECommerceService service = new ECommerceService();

        Profile profile = new Profile();
        profile.setPhone("9999999999");
        profile.setAddress("Hyderabad");
        service.saveProfile(profile);

        PurchaseOrder o1 = new PurchaseOrder();
        o1.setOrderDate(LocalDate.now());
        o1.setTotalAmount(1000);

        PurchaseOrder o2 = new PurchaseOrder();
        o2.setOrderDate(LocalDate.now());
        o2.setTotalAmount(2000);

        service.saveOrder(o1);
        service.saveOrder(o2);

        User user = new User();
        user.setName("Rahul");
        user.setEmail("rahul@gmail.com");
        user.setProfile(profile);
        user.setOrders(List.of(o1, o2));
        service.saveUser(user);

        
        Payment payment = new Payment();
        payment.setMode("CARD");
        payment.setAmount(1000);
        payment.setOrder(o1);
        service.savePayment(payment);
    }
}