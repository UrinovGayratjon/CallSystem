package uz.urinov.comunicationsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.urinov.comunicationsystem.payload.request.PayDTO;
import uz.urinov.comunicationsystem.service.PaymentService;

@RestController
@RequestMapping("/api/pay")
public class PaymentController {
    private final PaymentService service;

    @Autowired
    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @Secured({"ROLE_DIRECTOR", "ROLE_MANAGER"})
    @GetMapping
    public ResponseEntity<?> getAllHistory(
            @RequestParam(name = "sort", defaultValue = "id") String sort,
            @RequestParam(name = "filter", defaultValue = "desc") String filter,
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "size", defaultValue = "10") Integer size
    ) {
        return service.getAll(page, size, sort, filter);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/types")
    public ResponseEntity<?> getPayTypes() {
        return service.getPayTypes();
    }

    @Secured({"ROLE_CLIENT"})
    @GetMapping("/sim/{code}-{number}")// http://localhost:8080/api/pay/sim/90-1234567
    public ResponseEntity<?> getOneOneSimCardHistory(@PathVariable(name = "code") String code, @PathVariable(name = "number") String number) {
        return service.getSimCardHistory(code, number);
    }

    @Secured({"ROLE_CLIENT"})
    @PostMapping
    public ResponseEntity<?> savePay(@RequestBody PayDTO payDTO) {
        return service.addNewPay(payDTO);
    }
}
