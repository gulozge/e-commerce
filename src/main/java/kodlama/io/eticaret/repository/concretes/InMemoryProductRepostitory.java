package kodlama.io.eticaret.repository.concretes;

import kodlama.io.eticaret.entities.concretes.Product;
import kodlama.io.eticaret.repository.abstracts.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProductRepostitory implements ProductRepository {
    private List<Product> products;

    public InMemoryProductRepostitory() {
       products=new ArrayList<>();
       products.add(new Product(1,"aaa",120,1400,"aaa"));
       products.add(new Product(2,"bbb",130,1500,"bbb"));
       products.add(new Product(3,"ccc",140,1600,"ccc"));
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product getById(int id) {
        for (Product product : products) {
            if(product.getId()==id){
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
            if(product1.getId()==id){
                product1.setName(product.getName());
                product1.setQuantity(product.getQuantity());
                product1.setPrice(product.getPrice());
                product1.setDescription(product.getDescription());
            }
        }
        return product;
    }

    @Override
    public void delete(int id) {
        for (Product product : products) {
            if(product.getId()==id){
                products.remove(product);
            }
        }
    }
}
