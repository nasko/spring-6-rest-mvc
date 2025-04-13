package guru.springframework.spring6restmvc.controller;

import guru.springframework.spring6restmvc.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerControllerTest {

    @Autowired
    CustomerController controller;
    List<Customer> customers;

    @BeforeEach
    void setUp() {
        customers = controller.listCustomers();
    }

    @Test
    void listCustomers() {
        System.out.println("Customer count: " + customers.size());
    }

    @Test
    void getCustomerById() {
        System.out.println(controller.getCustomerById(customers.getFirst().getId()));
    }
}