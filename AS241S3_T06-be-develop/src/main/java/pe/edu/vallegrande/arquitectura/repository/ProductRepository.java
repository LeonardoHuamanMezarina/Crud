package pe.edu.vallegrande.arquitectura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pe.edu.vallegrande.arquitectura.model.Product;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface ProductRepository  extends JpaRepository<Product, Long> {
    List<Product> findByStatus(String status);
}
