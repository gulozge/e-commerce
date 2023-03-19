package kodlama.io.eticaret.api.controllers;

import kodlama.io.eticaret.business.abstracts.ProductService;
import kodlama.io.eticaret.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
    @RestController
    @RequestMapping("/api/products")
    public class ProductsController {
       private final ProductService service;
    @Autowired
    public ProductsController(ProductService service) {
            this.service = service;
        }
    @GetMapping
    public List<Product> getAll(){
            return service.getAll();
        }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id){
            return service.getById(id);
        }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product add(@RequestBody Product product){
        return service.add(product);
    }
    @PutMapping("/{id}")
    public Product update(@PathVariable int id,@RequestBody Product product){
       return service.update(id,product);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
        service.delete(id);
    }




}
