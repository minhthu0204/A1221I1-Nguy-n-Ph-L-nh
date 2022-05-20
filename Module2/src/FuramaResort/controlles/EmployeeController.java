package FuramaResort.controlles;

import FuramaResort.models.Person.Employee;
import FuramaResort.services.EmployeeService;
import FuramaResort.services.impl.EmployeeServiceImpl;

import java.util.List;

public class EmployeeController {
    private EmployeeService employeeService= new EmployeeServiceImpl();

    public void add(Employee employee){
        employeeService.add(employee);
    }

    public void edit(Employee employee){
        employeeService.edit(employee);
    }

    public List<Employee> findAll(){
        return employeeService.findAll();
    }
}
