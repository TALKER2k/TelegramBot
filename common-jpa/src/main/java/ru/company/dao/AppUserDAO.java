package ru.company.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.entity.AppUser;

public interface AppUserDAO extends JpaRepository<AppUser, Long> {
    AppUser findAppUserByTelegramUserId(Long id);
}
