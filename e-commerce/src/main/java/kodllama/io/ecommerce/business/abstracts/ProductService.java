package kodllama.io.ecommerce.business.abstracts;

import kodllama.io.ecommerce.entities.Product;

import java.util.List;

public interface ProductService {
        List<Product> getAll();
        Product getById(int id);
        Product add(Product product) throws IllegalAccessException;
        Product update(int id, Product product) throws IllegalAccessException;
        Product delete(int id);
}
