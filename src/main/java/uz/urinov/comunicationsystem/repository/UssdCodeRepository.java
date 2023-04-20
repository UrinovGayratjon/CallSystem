package uz.urinov.comunicationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.urinov.comunicationsystem.entity.UssdCode;

public interface UssdCodeRepository extends JpaRepository<UssdCode, Long> {
    boolean existsByCode(String code);

    boolean existsByCodeAndIdNot(String code, Long id);
}