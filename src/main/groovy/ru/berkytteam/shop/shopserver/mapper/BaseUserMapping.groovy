package ru.berkytteam.shop.shopserver.mapper

import org.mapstruct.Mapping
import org.springframework.beans.factory.annotation.Autowired
import ru.berkytteam.shop.shopserver.model.entity.User
import ru.berkytteam.shop.shopserver.repository.UserRepository

trait BaseUserMapping {
    @Autowired
    UserRepository userRepository

    User userIdToUser(UUID userId) {
        if (userId == null) {
            return null
        }

        return userRepository.findById(userId).orElseThrow()
    }

    UUID userToUserId(User user) {
        if (user == null) {
            return null
        }

        return user.id
    }
}