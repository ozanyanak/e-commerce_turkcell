package kodllama.io.ecommerce.business.concretes;

import kodllama.io.ecommerce.business.abstracts.ProductService;
import kodllama.io.ecommerce.entities.concretes.Product;
import kodllama.io.ecommerce.repository.abstracts.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private final ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getAll() {
        return repository.getAll();
    }

    @Override
    public Product getById(int id) {
        return repository.getById(id);
    }

    @Override
    public Product add(Product product) throws IllegalAccessException {
        validateProduct(product);
            return repository.add(product);
    }

    @Override
    public Product update(int id, Product product) throws IllegalAccessException {
        validateProduct(product);

        return repository.update(id,product);
    }

    @Override
    public Product delete(int id) {
    repository.delete(id);
        return null;
    }
    private void checkIfPriceValid(Product product) throws IllegalAccessException {
        if (product.getPrice() <= 0) throw new IllegalAccessException("fiyat sıfırdan az veya eşit olamaz");
    }
    private void checkIfQUantityValid(Product product) throws IllegalAccessException {
        if (product.getPrice()<0) throw  new IllegalAccessException("miktar 0'dan az olamaz");

    }
    private void checkIfDescriptionValid(Product product) throws IllegalAccessException {
        if (product.getDescription().length()<10 ||product.getDescription().length()>50)throw new IllegalAccessException("açıklama 10 karakterden az veya 50 den fazla olamaz");

    }
    private void validateProduct(Product product) throws IllegalAccessException {
        checkIfDescriptionValid(product);
        checkIfPriceValid(product);
        checkIfQUantityValid(product);
    }
}
