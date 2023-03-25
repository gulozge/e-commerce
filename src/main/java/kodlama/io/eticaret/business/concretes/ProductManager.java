package kodlama.io.eticaret.business.concretes;

import kodlama.io.eticaret.business.abstracts.ProductService;
import kodlama.io.eticaret.entities.Product;
import kodlama.io.eticaret.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private final ProductRepository repository;

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }
    @Override
    public Product getById(int id) {
       return repository.findById(id).orElseThrow();
    }

    @Override
    public Product add(Product product) {
        validateProduct(product);
        return repository.save(product);
    }
    @Override
    public Product update(int id, Product product) {
        validateProduct(product);
        product.setId(id);
        return repository.save(product);
    }
    @Override
    public void delete(int id) {
        repository.deleteById(id);
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


