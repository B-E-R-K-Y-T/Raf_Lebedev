package ru.berkytteam.shop.shopserver.model.entity

import org.hibernate.annotations.Type

import javax.persistence.*

@Entity
@Table(name = "carts")
class Cart {
    @Id
    @Type(type = "pg-uuid")
    UUID id = UUID.randomUUID()

    @OneToOne
    @JoinColumn
    User user

    @Column(name = "user_id", insertable = false, updatable = false)
    private UUID userId

    @ManyToMany
    Set<Product> products
}
