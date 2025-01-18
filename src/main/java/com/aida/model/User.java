package com.aida.model;

import com.aida.domain.USER_ROLE;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String email;

    private String fullName;

    private String mobile;

    private USER_ROLE role;

    @OneToMany
    private Set<Address> addresses = new HashSet<>();

    @ManyToMany
    @JsonIgnore
    private Set<Coupon> usedCoupons = new HashSet<>();

    public User() {
    }

    public User(Long id, String password, String email, String fullName, String mobile, USER_ROLE role, Set<Address> addresses, Set<Coupon> usedCoupons) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.mobile = mobile;
        this.role = role;
        this.addresses = addresses;
        this.usedCoupons = usedCoupons;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public USER_ROLE getRole() {
        return role;
    }

    public void setRole(USER_ROLE role) {
        this.role = role;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Coupon> getUsedCoupons() {
        return usedCoupons;
    }

    public void setUsedCoupons(Set<Coupon> usedCoupons) {
        this.usedCoupons = usedCoupons;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", role=" + role +
                ", addresses=" + addresses +
                ", usedCoupons=" + usedCoupons +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) &&
                password.equals(user.password) &&
                email.equals(user.email) &&
                fullName.equals(user.fullName) &&
                mobile.equals(user.mobile) &&
                role == user.role &&
                addresses.equals(user.addresses) &&
                usedCoupons.equals(user.usedCoupons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password, email, fullName, mobile, role, addresses, usedCoupons);
    }
}








