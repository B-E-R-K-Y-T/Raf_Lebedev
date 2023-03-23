package ru.berkytteam.shop.shopserver.model.entity

import org.hibernate.annotations.Type

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
class User {

    @Id
    @Type(type = "pg-uuid")
    UUID id = UUID.randomUUID()

    String name
    String email
}
