package FuramaResort.services.impl;

import FuramaResort.models.Person.Customer;
import FuramaResort.services.CustomerService;

import java.util.LinkedList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private static List<Customer> customerList = new LinkedList<>();

    @Override
    public List findAll() {
        return customerList;
    }

    @Override
    public void add(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public void edit(Customer customer) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customer.getCustomerID() == customerList.get(i).getCustomerID()){
                customerList.set(i,customer);
                return;
            }
        }
    }
}
