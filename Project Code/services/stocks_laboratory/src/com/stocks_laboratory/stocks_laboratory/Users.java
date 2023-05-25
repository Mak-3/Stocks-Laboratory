/*Copyright (c) 2023-2024 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.stocks_laboratory.stocks_laboratory;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Users generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`users`", uniqueConstraints = {
            @UniqueConstraint(name = "`email`", columnNames = {"`email`"})})
public class Users implements Serializable {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String profilePicture;
    private Long balance = 1000000L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`first_name`", nullable = false, length = 50)
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "`last_name`", nullable = false, length = 50)
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "`email`", nullable = false, length = 100)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "`password`", nullable = false, length = 255)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "`profile_picture`", nullable = true, length = 1024)
    public String getProfilePicture() {
        return this.profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    @Column(name = "`balance`", nullable = true, scale = 0, precision = 19)
    public Long getBalance() {
        return this.balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        final Users users = (Users) o;
        return Objects.equals(getId(), users.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}