package com.reader.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String email;
    private boolean trusted = false;
    private String password;

    public User() {}

    public User(String email) {
        this.email = email;
    }

    public User(String email,String password) {
        this(email);
        this.password = password;
    }

    public User(String email,String password,boolean trusted) {
        this(email);
        this.password = password;
        this.trusted = trusted;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public boolean isTrusted() {
        return trusted;
    }

    public void setTrusted(boolean trusted) {
        this.trusted = trusted;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", trusted=" + trusted +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        User object;
        try {
            object = (User) obj;
        }catch (ClassCastException e) {
            return false;
        }
        return this.email.equals(object.email) && this.password.equals(object.password);
    }
}
