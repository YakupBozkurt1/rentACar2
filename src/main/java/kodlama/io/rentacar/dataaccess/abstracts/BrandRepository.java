package kodlama.io.rentacar.dataaccess.abstracts;

import kodlama.io.rentacar.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    boolean existsByName(String name);


}
