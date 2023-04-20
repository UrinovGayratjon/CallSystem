package uz.urinov.comunicationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.urinov.comunicationsystem.entity.Client;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {
    boolean existsByPassportSerialNumber(String passportSerialNumber);

    Optional<Client> findByPassportSerialNumber(String passportSerialNumber);
}