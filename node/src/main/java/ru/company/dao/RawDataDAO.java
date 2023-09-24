package ru.company.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.entity.RawData;

public interface RawDataDAO extends JpaRepository<RawData, Long> {
}
