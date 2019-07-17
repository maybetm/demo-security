package com.example.demosecurity.controller;

import com.example.demosecurity.dao.EmployeeDAO;
import com.example.demosecurity.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zebzeev-sv
 * @version 17.07.2019 11:36
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class MainRESTController
{
  @Autowired
  private EmployeeDAO employeeDAO;

  @RequestMapping("/")
  @ResponseBody
  public String welcome() {
    return "Welcome to Spring Boot + REST + JWT Example.";
  }

  @RequestMapping("/test")
  public String test() {
    return "{\"greeting\": \"Hello\"}";
  }

  // URL:
  // http://localhost:8080/employees
  @GetMapping (value = "/employees")
  public List<Employee> getEmployees()
  {
    List<Employee> list = employeeDAO.getAllEmployees();
    return list;
  }

  // URL:
  // http://localhost:8080/employee/{empNo}
  @GetMapping(value = "/employee/{empNo}")
  @ResponseBody
  public Employee getEmployee(@PathVariable("empNo") String empNo) {
    return employeeDAO.getEmployee(empNo);
  }


  // http://localhost:8080/employee
  @PostMapping(value = "/employee")
  @ResponseBody
  public Employee addEmployee(@RequestBody Employee emp) {

    System.out.println("(Service Side) Creating employee: " + emp.getEmpNo());

    return employeeDAO.addEmployee(emp);
  }

  // URL:
  // http://localhost:8080/employee
  @PutMapping(value = "/employee")
  @ResponseBody
  public Employee updateEmployee(@RequestBody Employee emp) {
    System.out.println("(Service Side) Editing employee: " + emp.getEmpNo());
    return employeeDAO.updateEmployee(emp);
  }

  // URL:
  // http://localhost:8080/employee/{empNo}
  @DeleteMapping(value = "/employee/{empNo}")
  @ResponseBody
  public void deleteEmployee(@PathVariable("empNo") String empNo) {

    System.out.println("(Service Side) Deleting employee: " + empNo);
    employeeDAO.deleteEmployee(empNo);
  }

}
