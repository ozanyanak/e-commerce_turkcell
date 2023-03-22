package kodllama.io.ecommerce.api.controllers;

import kodllama.io.ecommerce.business.abstracts.ProductService;
import kodllama.io.ecommerce.entities.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductService service;

    public ProductsController(ProductService service) {
        this.service = service;
    }
    @GetMapping
    public List<Product> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id){
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product add(@RequestBody Product product) throws IllegalAccessException {
        return service.add(product);
    }
    @PutMapping("/{id}")
    public Product update(@PathVariable int id, Product product) throws IllegalAccessException {
        return service.update(id,product);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Product update(@PathVariable  int id)  {
        return service.delete(id);
    }
}
