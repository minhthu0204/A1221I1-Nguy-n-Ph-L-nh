package FuramaResort.controlles;

import FuramaResort.models.Person.Customer;
import FuramaResort.services.CustomerService;
import FuramaResort.services.impl.CustomerServiceImpl;

import java.util.List;

public class CustomerController {
    private CustomerService customerService = new CustomerServiceImpl();

    public void add(Customer customer){
        customerService.add(customer);
    }

    public List<Customer> findAll(){
        return customerService.findAll();
    }
    public void edit(Customer customer){
        customerService.edit(customer);
    }
}
