package kodllama.io.ecommerce.api.controllers;

import jakarta.validation.Valid;
import kodllama.io.ecommerce.business.abstracts.ProductService;
import kodllama.io.ecommerce.business.dto.request.create.CreateProductRequest;
import kodllama.io.ecommerce.business.dto.request.update.UpdateProductRequest;
import kodllama.io.ecommerce.business.dto.response.create.CreateProductResponse;
import kodllama.io.ecommerce.business.dto.response.get.GetAllProductsResponse;
import kodllama.io.ecommerce.business.dto.response.get.GetProductResponse;
import kodllama.io.ecommerce.business.dto.response.update.UpdateProductResponse;
import kodllama.io.ecommerce.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor

@RequestMapping("/api/products")
public class ProductsController {
    private final ProductService service;

    @GetMapping
    public List<GetAllProductsResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetProductResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductResponse add(@RequestBody CreateProductRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateProductResponse update(@PathVariable int id, @RequestBody UpdateProductRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

}
