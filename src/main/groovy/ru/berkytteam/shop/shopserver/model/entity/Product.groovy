package ru.berkytteam.shop.shopserver.model.entity

import org.hibernate.annotations.Type

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "products")
class Product {

    @Id
    @Type(type = "pg-uuid")
    UUID id = UUID.randomUUID()
    String name
    String description
    BigInteger price
    String imageUrl
}
