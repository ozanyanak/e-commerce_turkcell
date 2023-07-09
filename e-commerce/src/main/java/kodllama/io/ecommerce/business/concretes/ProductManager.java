package kodllama.io.ecommerce.business.concretes;

import kodllama.io.ecommerce.business.abstracts.ProductService;
import kodllama.io.ecommerce.business.dto.request.create.CreateProductRequest;
import kodllama.io.ecommerce.business.dto.request.update.UpdateProductRequest;
import kodllama.io.ecommerce.business.dto.response.create.CreateProductResponse;
import kodllama.io.ecommerce.business.dto.response.get.GetAllProductsResponse;
import kodllama.io.ecommerce.business.dto.response.get.GetProductResponse;
import kodllama.io.ecommerce.business.dto.response.update.UpdateProductResponse;
import kodllama.io.ecommerce.business.rules.ProductBusinessRules;
import kodllama.io.ecommerce.entities.Product;
import kodllama.io.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

    private ModelMapper mapper;
    private ProductRepository repository;
    private ProductBusinessRules rules;
    @Override
    public List<GetAllProductsResponse> getAll() {
        var products = repository.findAll();
        var response = products
                .stream()
                .map(product -> mapper.map(product, GetAllProductsResponse.class))
                .toList();

        return response;
    }

    @Override
    public GetProductResponse getById(int id) {
        rules.checkIfProductExist(id);
        Product product = repository.findById(id).orElseThrow();
        GetProductResponse response = mapper.map(product, GetProductResponse.class);
        return response;
    }

    @Override
    public CreateProductResponse add(CreateProductRequest request) {

        rules.checkIfProductExistsByName(request.getName());
        Product product = mapper.map(request, Product.class);
        product.setId(0);

        repository.save(product);
        CreateProductResponse response = mapper.map(product, CreateProductResponse.class);

        return response;
    }

    @Override
    public UpdateProductResponse update(int id, UpdateProductRequest request) {
        rules.checkIfProductExist(id);
        Product product = mapper.map(request, Product.class);
        product.setId(id);
        repository.save(product);
        UpdateProductResponse response = mapper.map(product, UpdateProductResponse.class);
        return response;
    }

    @Override
    public void delete(int id) {
        rules.checkIfProductExist(id);
        repository.deleteById(id);
    }
}
