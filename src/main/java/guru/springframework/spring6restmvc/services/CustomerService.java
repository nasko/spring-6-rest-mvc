package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    List<Customer> getAllCustomers();
    Customer getCustomerById(UUID id);
    Customer createCustomer(Customer customer);
}
