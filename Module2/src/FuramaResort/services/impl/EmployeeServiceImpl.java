package FuramaResort.services.impl;

import FuramaResort.models.Person.Employee;
import FuramaResort.services.EmployeeService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private static List<Employee> employeeList = new ArrayList<>();

    @Override
    public void add(Employee employee) {
        employeeList.add(employee);
    }

    @Override
    public void edit(Employee employee) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employee.getEmployeeID() == employeeList.get(i).getEmployeeID()){
                employeeList.set(i,employee);
                return;
            }
        }
    }

    @Override
    public List<Employee> findAll() {
        return employeeList;
    }
}
