package kodllama.io.ecommerce.business.abstracts;

import kodllama.io.ecommerce.business.dto.request.create.CreateProductRequest;
import kodllama.io.ecommerce.business.dto.request.update.UpdateProductRequest;
import kodllama.io.ecommerce.business.dto.response.create.CreateProductResponse;
import kodllama.io.ecommerce.business.dto.response.get.GetAllProductsResponse;
import kodllama.io.ecommerce.business.dto.response.get.GetProductResponse;
import kodllama.io.ecommerce.business.dto.response.update.UpdateProductResponse;

import java.util.List;

public interface ProductService {
    List<GetAllProductsResponse> getAll();

    GetProductResponse getById(int id);

    CreateProductResponse add(CreateProductRequest request);

    UpdateProductResponse update(int id, UpdateProductRequest request);

    void delete(int id);
    void changeQuantity(int id,int number);
}

