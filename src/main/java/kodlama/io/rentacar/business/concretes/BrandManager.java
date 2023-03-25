package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.Requests.CreatenewBrandRequest;
import kodlama.io.rentacar.business.Requests.UpdateBrandRequest;
import kodlama.io.rentacar.business.Responses.GetAllResponse;
import kodlama.io.rentacar.business.Responses.GetByIdResponse;
import kodlama.io.rentacar.business.abstracts.BrandService;
import kodlama.io.rentacar.business.rules.BrandBusinessRules;
import kodlama.io.rentacar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentacar.dataaccess.abstracts.BrandRepository;
import kodlama.io.rentacar.entities.Brand;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service    //bu sınıf bir business nesnesidir
@AllArgsConstructor
public class BrandManager implements BrandService {

    @Autowired
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;


    @Override
    public List<GetAllResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();

        List<GetAllResponse> response = brands.stream().map(brand -> this.modelMapperService.forResponse().map(brand, GetAllResponse.class)).collect(Collectors.toList());
        return response;
    }

    @Override
    public GetByIdResponse getbyid(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        GetByIdResponse response = this.modelMapperService.forResponse().map(brand, GetByIdResponse.class);

        return response;
    }

    @Override
    public void add(CreatenewBrandRequest createnewBrandRequest) {
        brandBusinessRules.checkIfBrandNameExists(createnewBrandRequest.getName());
        Brand brand = this.modelMapperService.forRequest().map(createnewBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        brandRepository.deleteById(id);
    }
}
