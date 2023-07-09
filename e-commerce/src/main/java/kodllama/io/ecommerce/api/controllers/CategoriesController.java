package kodllama.io.ecommerce.api.controllers;

import kodllama.io.ecommerce.business.abstracts.CategoryService;
import kodllama.io.ecommerce.business.abstracts.ProductService;
import kodllama.io.ecommerce.business.dto.request.create.CreateCategoryRequest;
import kodllama.io.ecommerce.business.dto.request.create.CreateProductRequest;
import kodllama.io.ecommerce.business.dto.request.update.UpdateCategoryRequest;
import kodllama.io.ecommerce.business.dto.request.update.UpdateProductRequest;
import kodllama.io.ecommerce.business.dto.response.create.CreateCategoryResponse;
import kodllama.io.ecommerce.business.dto.response.create.CreateProductResponse;
import kodllama.io.ecommerce.business.dto.response.get.GetAllCategoriesResponse;
import kodllama.io.ecommerce.business.dto.response.get.GetAllProductsResponse;
import kodllama.io.ecommerce.business.dto.response.get.GetCategoryResponse;
import kodllama.io.ecommerce.business.dto.response.get.GetProductResponse;
import kodllama.io.ecommerce.business.dto.response.update.UpdateCategoryResponse;
import kodllama.io.ecommerce.business.dto.response.update.UpdateProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/categories")
public class CategoriesController {
    private final CategoryService service;

    @GetMapping
    public List<GetAllCategoriesResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetCategoryResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCategoryResponse add(@RequestBody CreateCategoryRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateCategoryResponse update(@PathVariable int id, @RequestBody UpdateCategoryRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

}
