package ru.berkytteam.shop.shopserver.mapper

import org.springframework.beans.factory.annotation.Autowired
import ru.berkytteam.shop.shopserver.exception.EntityNotFoundException
import ru.berkytteam.shop.shopserver.model.entity.Product
import ru.berkytteam.shop.shopserver.repository.ProductRepository

trait BaseProductMapping {
    @Autowired
    ProductRepository productRepository

    UUID productToProductId(Product product) {
        if (product == null) {
            return null
        }

        return product.id
    }

    Product productIdToProduct(UUID productId) {
        if (productId == null) {
            return null
        }

        return productRepository.findById(productId)
                .orElseThrow({ new EntityNotFoundException(Product, "id: $productId")})
    }
}