package kodlama.io.eticaret.repository;


import kodlama.io.eticaret.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
