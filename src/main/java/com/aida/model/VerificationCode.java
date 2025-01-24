package com.aida.model;

import jakarta.persistence.*;

@Entity
public class VerificationCode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String otp;

    private String email;

    @OneToOne
    private User user;

    @OneToOne
    private Seller seller;

    // No-argument constructor
    public VerificationCode() {
    }

    // All-argument constructor
    public VerificationCode(Long id, String otp, String email, User user, Seller seller) {
        this.id = id;
        this.otp = otp;
        this.email = email;
        this.user = user;
        this.seller = seller;
    }

    // Getter for id
    public Long getId() {
        return id;
    }

    // Setter for id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for otp
    public String getOtp() {
        return otp;
    }

    // Setter for otp
    public void setOtp(String otp) {
        this.otp = otp;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for user
    public User getUser() {
        return user;
    }

    // Setter for user
    public void setUser(User user) {
        this.user = user;
    }

    // Getter for seller
    public Seller getSeller() {
        return seller;
    }

    // Setter for seller
    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    // Override equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VerificationCode that = (VerificationCode) o;

        if (!id.equals(that.id)) return false;
        if (!otp.equals(that.otp)) return false;
        if (!email.equals(that.email)) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return seller != null ? seller.equals(that.seller) : that.seller == null;
    }

    // Override hashCode method
    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + otp.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (seller != null ? seller.hashCode() : 0);
        return result;
    }
}
