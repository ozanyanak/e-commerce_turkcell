package kodllama.io.ecommerce.api.controllers;

import kodllama.io.ecommerce.business.abstracts.InvoiceService;
import kodllama.io.ecommerce.business.dto.request.create.CreateInvoiceRequest;
import kodllama.io.ecommerce.business.dto.request.update.UpdateInvoiceRequest;
import kodllama.io.ecommerce.business.dto.response.create.CreateInvoiceResponse;
import kodllama.io.ecommerce.business.dto.response.get.GetAllInvoicesResponse;
import kodllama.io.ecommerce.business.dto.response.get.GetInvoiceResponse;
import kodllama.io.ecommerce.business.dto.response.update.UpdateInvoiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/invoices")
public class InvoicesController {
    private final InvoiceService service;

    @GetMapping
    public List<GetAllInvoicesResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetInvoiceResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateInvoiceResponse add(@RequestBody CreateInvoiceRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateInvoiceResponse update(@PathVariable int id, @RequestBody UpdateInvoiceRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}