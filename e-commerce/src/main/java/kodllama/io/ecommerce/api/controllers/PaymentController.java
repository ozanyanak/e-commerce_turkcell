package kodllama.io.ecommerce.api.controllers;

import jakarta.validation.Valid;
import kodllama.io.ecommerce.business.abstracts.PaymentService;
import kodllama.io.ecommerce.business.dto.request.create.CreatePaymentRequest;
import kodllama.io.ecommerce.business.dto.request.update.UpdatePaymentRequest;
import kodllama.io.ecommerce.business.dto.response.create.CreatePaymentResponse;
import kodllama.io.ecommerce.business.dto.response.get.GetAllPaymentsResponse;
import kodllama.io.ecommerce.business.dto.response.get.GetPaymentResponse;
import kodllama.io.ecommerce.business.dto.response.update.UpdatePaymentResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService service;

    @GetMapping
    public List<GetAllPaymentsResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetPaymentResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public CreatePaymentResponse add(@Valid @RequestBody CreatePaymentRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdatePaymentResponse update(@PathVariable int id, @Valid @RequestBody UpdatePaymentRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
