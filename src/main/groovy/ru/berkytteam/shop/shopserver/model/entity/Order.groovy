package ru.berkytteam.shop.shopserver.model.entity

import org.hibernate.annotations.Type

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "orders")
class Order {
    @Id
    @Type(type = "pg-uuid")
    UUID id = UUID.randomUUID()

    @ManyToOne
    @JoinColumn
    User user

    @Column(name = "user_id", insertable = false, updatable = false)
    private UUID userId

    BigInteger totalPrice

    @ManyToMany
    Set<Product> products
}
