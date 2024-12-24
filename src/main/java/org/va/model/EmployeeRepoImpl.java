package org.va.model;

public class EmployeeRepoImpl implements EmployeeRepo{
    @Override
    public String getEmployee() {
        System.out.println("In dummy impl 🥸");
        return "fake emp {empId: 000-000-000-0000}";
    }
}
