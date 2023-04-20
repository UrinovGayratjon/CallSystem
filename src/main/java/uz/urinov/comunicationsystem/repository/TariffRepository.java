package uz.urinov.comunicationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.urinov.comunicationsystem.entity.Tariff;

public interface TariffRepository extends JpaRepository<Tariff, Long> {
    boolean existsByName(String name);
    boolean existsByNameAndIdNot(String name, Long id);
}