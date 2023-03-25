package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.Requests.CreatenewModelRequest;
import kodlama.io.rentacar.business.Responses.GetAllModelResponse;
import kodlama.io.rentacar.business.abstracts.ModelService;
import kodlama.io.rentacar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentacar.dataaccess.abstracts.ModelRepository;
import kodlama.io.rentacar.entities.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelResponse> getAll() {
        List<Model> models = modelRepository.findAll();

        List<GetAllModelResponse> modelResponses = models.stream().
                map(model -> this.modelMapperService.forResponse().map(models, GetAllModelResponse.class)).collect(Collectors.toList());

        return modelResponses;
    }

    @Override
    public void add(CreatenewModelRequest createnewModelRequest){
        Model model  = this.modelMapperService.forRequest().map(createnewModelRequest, Model.class);
        this.modelRepository.save(model);


    }
}
