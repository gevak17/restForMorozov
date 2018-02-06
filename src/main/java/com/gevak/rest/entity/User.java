package com.gevak.rest.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "USER")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "USER_NAME")
    private String username;
    @NotNull
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE_1")
    private String phone1;
    @Column(name = "PHONE_2")
    private String phone2;
    @Column(name = "PHONE_3")
    private String phone3;

    @NotNull
    @Column(name = "NAME")
    private String name;
    @Column(name = "RATE")
    private Float rate;

    @Column(name = "AUTHORITY")
    @Enumerated(EnumType.STRING)
    Auth authority = Auth.ROLE_USER;

    @Column(name = "ACCOUNT_NON_EXPIRED")
    private boolean accountNonExpired;
    @Column(name = "ACCOUNT_NON_LOCKED")
    private boolean accountNonLocked;
    @Column(name = "CREDENTIALS_NON_EXPIRED")
    private boolean credentialsNonExpired;
    @Column(name = "ENABLED")
    private boolean enabled;

    public User() {}

    public User(String username, String password, String email, String phone1, String phone2, String phone3, String name) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.phone3 = phone3;
        this.name = name;
        this.rate = 0.0f;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(authority.name()));
        return authorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getPhone3() {
        return phone3;
    }

    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
