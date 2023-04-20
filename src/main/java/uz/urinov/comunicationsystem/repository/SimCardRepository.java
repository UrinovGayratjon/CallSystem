package uz.urinov.comunicationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.urinov.comunicationsystem.entity.SimCard;

import java.util.Optional;
import java.util.UUID;

public interface SimCardRepository extends JpaRepository<SimCard, UUID> {
    Optional<SimCard> findByCodeAndNumber(String code, String number);

    boolean existsByCodeAndNumber(String code, String number);
}