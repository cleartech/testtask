package db;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDataHolder {

    private List<Employee> employeeData = new ArrayList<>();

    public EmployeeDataHolder() {
    }

    public void addEmployee(Employee employee) {
        employeeData.add(employee);
    }

    public List<Employee> getEmployeeData() {
        return employeeData;
    }
}
