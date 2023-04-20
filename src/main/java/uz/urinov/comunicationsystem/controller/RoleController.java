package uz.urinov.comunicationsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.urinov.comunicationsystem.repository.RoleRepository;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    private final RoleRepository repository;

    @Autowired
    public RoleController(RoleRepository repository) {
        this.repository = repository;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }
}
