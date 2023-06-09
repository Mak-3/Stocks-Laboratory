/*Copyright (c) 2023-2024 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.stocks_laboratory.stocks_laboratory;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * AmericanStockPortfolio generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`american_stock_portfolio`", uniqueConstraints = {
            @UniqueConstraint(name = "`UK_american_stock_portfo9Jfd4`", columnNames = {"`user_id`", "`stock_symbol`"})})
public class AmericanStockPortfolio implements Serializable {

    private Integer id;
    private int userId;
    private String stockSymbol;
    private int sharesOwned;
    private double purchasePrice;
    private Users users;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`user_id`", nullable = false, scale = 0, precision = 10)
    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "`stock_symbol`", nullable = false, length = 10)
    public String getStockSymbol() {
        return this.stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    @Column(name = "`shares_owned`", nullable = false, scale = 0, precision = 10)
    public int getSharesOwned() {
        return this.sharesOwned;
    }

    public void setSharesOwned(int sharesOwned) {
        this.sharesOwned = sharesOwned;
    }

    @Column(name = "`purchase_price`", nullable = false, scale = 2, precision = 10)
    public double getPurchasePrice() {
        return this.purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`user_id`", referencedColumnName = "`id`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`american_stock_portfolio_ibfk_1`"))
    @Fetch(FetchMode.JOIN)
    public Users getUsers() {
        return this.users;
    }

    public void setUsers(Users users) {
        if(users != null) {
            this.userId = users.getId();
        }

        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AmericanStockPortfolio)) return false;
        final AmericanStockPortfolio americanStockPortfolio = (AmericanStockPortfolio) o;
        return Objects.equals(getId(), americanStockPortfolio.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}