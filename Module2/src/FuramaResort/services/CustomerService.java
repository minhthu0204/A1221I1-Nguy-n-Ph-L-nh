package FuramaResort.services;

import FuramaResort.models.Person.Customer;

import java.util.List;

public interface CustomerService extends GeneralService<Customer> {
    @Override
    List<Customer> findAll();

    @Override
    void add(Customer customer);
}
