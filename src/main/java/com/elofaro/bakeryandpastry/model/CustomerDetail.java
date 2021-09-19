package com.elofaro.bakeryandpastry.model;

import javax.persistence.*;

@Entity
@Table(name = "customer_detail")
public class CustomerDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_detail_id", nullable = false)
    private int customerDetailId;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "address")
    private String address;

    public CustomerDetail() {
    }

    public CustomerDetail(String firstname,
                          String lastname, String address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
    }

    public int getCustomerDetailId() {
        return customerDetailId;
    }

    public void setCustomerDetailId(int customerDetailId) {
        this.customerDetailId = customerDetailId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
