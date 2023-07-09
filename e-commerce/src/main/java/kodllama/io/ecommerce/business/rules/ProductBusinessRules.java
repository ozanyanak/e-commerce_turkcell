package kodllama.io.ecommerce.business.rules;

import kodllama.io.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductBusinessRules {
private final ProductRepository repository;

    public void checkIfProductExist(int id) {
        if (!repository.existsById(id)) throw new RuntimeException("ürün yok");
    }

    public void checkIfProductExistsByName(String name) {
        if (repository.existsByNameIgnoreCase(name)) {
            throw new RuntimeException("ürün yok");
        }
    }

}
