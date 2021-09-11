package com.mycompany.myapp.models;

public class Employee {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + "]";
    }
}
