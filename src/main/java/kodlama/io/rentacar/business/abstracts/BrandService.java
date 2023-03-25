package kodlama.io.rentacar.business.abstracts;

import kodlama.io.rentacar.business.Requests.CreatenewBrandRequest;
import kodlama.io.rentacar.business.Requests.UpdateBrandRequest;
import kodlama.io.rentacar.business.Responses.GetAllResponse;
import kodlama.io.rentacar.business.Responses.GetByIdResponse;
import kodlama.io.rentacar.entities.Brand;

import java.util.List;

public interface BrandService {
    List<GetAllResponse> getAll();
    GetByIdResponse getbyid(int id);
    void add(CreatenewBrandRequest createnewBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);

}
