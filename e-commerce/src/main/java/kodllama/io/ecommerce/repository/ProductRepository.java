package kodllama.io.ecommerce.repository;

import kodllama.io.ecommerce.entities.Category;
import kodllama.io.ecommerce.entities.Product;
import kodllama.io.ecommerce.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product,Integer> {


    boolean existsByNameIgnoreCase(String name);
}

