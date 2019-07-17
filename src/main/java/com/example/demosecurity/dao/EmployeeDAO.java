package com.example.demosecurity.dao;

import com.example.demosecurity.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @author zebzeev-sv
 * @version 17.07.2019 11:34
 */
@Repository
public class EmployeeDAO
{
  private static final Map<String, Employee> empMap = new HashMap<>();

  static {
    initEmps();
  }

  private static void initEmps() {
    Employee emp1 = new Employee("E01", "Smith", "Clerk");
    Employee emp2 = new Employee("E02", "Allen", "Salesman");
    Employee emp3 = new Employee("E03", "Jones", "Manager");

    empMap.put(emp1.getEmpNo(), emp1);
    empMap.put(emp2.getEmpNo(), emp2);
    empMap.put(emp3.getEmpNo(), emp3);
  }

  public Employee getEmployee(String empNo) {
    return empMap.get(empNo);
  }

  public Employee addEmployee(Employee emp) {
    empMap.put(emp.getEmpNo(), emp);
    return emp;
  }

  public Employee updateEmployee(Employee emp) {
    empMap.put(emp.getEmpNo(), emp);
    return emp;
  }

  public void deleteEmployee(String empNo) {
    empMap.remove(empNo);
  }

  public List<Employee> getAllEmployees() {
    Collection<Employee> c = empMap.values();
    List<Employee> list = new ArrayList<>();
    list.addAll(c);
    return list;
  }

}
