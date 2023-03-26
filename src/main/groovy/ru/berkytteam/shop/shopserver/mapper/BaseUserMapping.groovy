package ru.berkytteam.shop.shopserver.mapper


import org.springframework.beans.factory.annotation.Autowired
import ru.berkytteam.shop.shopserver.exception.EntityNotFoundException
import ru.berkytteam.shop.shopserver.model.entity.User
import ru.berkytteam.shop.shopserver.repository.UserRepository

trait BaseUserMapping {
    @Autowired
    UserRepository userRepository

    User userIdToUser(UUID userId) {
        if (userId == null) {
            return null
        }

        return userRepository.findById(userId)
                .orElseThrow({new EntityNotFoundException(User, "id: $userId")})
    }

    UUID userToUserId(User user) {
        if (user == null) {
            return null
        }

        return user.id
    }
}