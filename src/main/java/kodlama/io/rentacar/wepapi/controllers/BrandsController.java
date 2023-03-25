package kodlama.io.rentacar.wepapi.controllers;

import kodlama.io.rentacar.business.Requests.CreatenewBrandRequest;
import kodlama.io.rentacar.business.Requests.UpdateBrandRequest;
import kodlama.io.rentacar.business.Responses.GetAllResponse;
import kodlama.io.rentacar.business.Responses.GetByIdResponse;
import kodlama.io.rentacar.business.abstracts.BrandService;
import kodlama.io.rentacar.entities.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Annotation
@RequestMapping("/api/brands")
public class BrandsController {
    private BrandService brandService;

    @Autowired
    public BrandsController(BrandService brandService) {

        this.brandService = brandService;
    }

    @GetMapping()
    public List<GetAllResponse> getAll(){

        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdResponse getById(@PathVariable int id){

        return brandService.getbyid(id);
    }

    @PostMapping()
    @ResponseStatus(code=HttpStatus.CREATED)
    public void add(@RequestBody() CreatenewBrandRequest createnewBrandRequest){
        this.brandService.add(createnewBrandRequest);
    }

    @PutMapping
    public void update(@RequestBody() UpdateBrandRequest updateBrandRequest ){
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);
    }
}
