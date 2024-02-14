package com.tms.shop.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@Entity
@Table(name = "orders")
public class Order extends BaseEntity implements Serializable {

    @Column(name = "PRICE")
    private int price;
    //@Column(name = "DATE")
    //private Date date;
    @ManyToOne
    private User user;
    @ManyToMany
    @JoinTable(name = "orders_products", joinColumns = @JoinColumn(name = "ORDER_ID"),
               inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
    private List<Product> productList;
}