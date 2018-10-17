package com.lin.spring1.service;

import com.lin.spring1.bean.Employee;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class EmployeeService implements InitializingBean, DisposableBean {

    private Employee employee;

    public EmployeeService(Employee employee) {
        this.employee = employee;
    }

    public EmployeeService() {
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("EmployeeService destroy ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init EmployeeService");
        if(employee.getName() == null){
            employee.setName("helloEmployee");
        }
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
