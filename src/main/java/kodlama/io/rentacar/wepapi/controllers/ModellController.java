package kodlama.io.rentacar.wepapi.controllers;

import kodlama.io.rentacar.business.Requests.CreatenewModelRequest;
import kodlama.io.rentacar.business.Responses.GetAllModelResponse;
import kodlama.io.rentacar.business.Responses.GetAllResponse;
import kodlama.io.rentacar.business.abstracts.ModelService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("api/models")
@RestController //annotation
public class ModellController {

    private ModelService modelService;

    @GetMapping
    public List<GetAllModelResponse> getAll(){

        return modelService.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreatenewModelRequest createnewModelRequest){

        this.modelService.add(createnewModelRequest);

    }
}
