package kodlama.io.eticaret.business.concretes;

import kodlama.io.eticaret.business.abstracts.ProductService;
import kodlama.io.eticaret.entities.concretes.Product;
import kodlama.io.eticaret.repository.abstracts.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductManager implements ProductService {
    private final ProductRepository repository;

    @Autowired
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
    public Product add(Product product) {
        validateProduct(product);
        return repository.add(product);
    }
    @Override
    public Product update(int id, Product product) {
        validateProduct(product);
        return repository.update(id, product);
    }
    @Override
    public void delete(int id) {
        repository.delete(id);
    }
    private void validateProduct(Product product){
        checkPriceValid(product);
        checkQuantityValid(product);
        checkDescriptionLength(product);
    }
    private void checkPriceValid(Product product){
     if(product.getPrice()<=0) throw new IllegalArgumentException("0 dan büyük olmalı");
    }
    private void checkQuantityValid(Product product){
        if(product.getQuantity()<0)throw new IllegalArgumentException("0 veya daha büyük olmalı" );
    }
    private void checkDescriptionLength(Product product){
        if(product.getDescription().length()<10 || product.getDescription().length()>50) throw new IllegalArgumentException("uauznluk hatalı");
    }





}


