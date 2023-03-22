package kodllama.io.ecommerce.repository.concretes;

import kodllama.io.ecommerce.entities.concretes.Product;
import kodllama.io.ecommerce.repository.abstracts.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class InMemoryProductRepository implements ProductRepository {

    private final List<Product> products; //global değişken oluştu class çinde
    // bunun newlenmesini de constructor içinde yapıcaksın products= new Arraylist<> olarak

    public InMemoryProductRepository() {
        products=new ArrayList<>();
        products.add(new Product(1,"Iphone",10,50000,"aplleProduct"));
        products.add(new Product(2,"Huawei",10,15000,"huawei"));
        products.add(new Product(3,"Playstation 5",10,20000,"sony"));
        products.add(new Product(4,"Xbox",10,20000,"Microsoft"));
        products.add(new Product(5,"Macbook",10,10000,"aplleProduct"));
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product getById(int id) {
        for (Product product : products) {
            if (product.getId()==id){
                return product;
            }
        }
return null;
    }

    @Override
    public Product add(Product product) {

        products.add(product);
        return product;
    }

    @Override
    public Product update(int id, Product product) {

        for (Product product1 : products) {
            if (product1.getId()==id){
                product1.setName(product.getName());
                product1.setDescription(product.getDescription());
                product1.setPrice(product.getPrice());
                product1.setQuantify(product.getQuantify());
                return product1;

            }

        }
        return null;
    }

    @Override
    public void delete(int id) {
        for (Product product : products) {
            if (product.getId()==id){
                products.remove(product);
            }
        }    }
}
