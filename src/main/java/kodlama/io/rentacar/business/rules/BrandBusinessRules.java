package kodlama.io.rentacar.business.rules;

import kodlama.io.rentacar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentacar.dataaccess.abstracts.BrandRepository;
import org.springframework.stereotype.Service;

@Service
public class BrandBusinessRules {

    private BrandRepository brandRepository;
    public void checkIfBrandNameExists(String name){
        if(this.brandRepository.existsByName(name))
            throw new BusinessException("Brand already exists");
    }
}
