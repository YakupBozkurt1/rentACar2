package kodlama.io.rentacar.business.abstracts;

import kodlama.io.rentacar.business.Requests.CreatenewModelRequest;
import kodlama.io.rentacar.business.Responses.GetAllModelResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelResponse> getAll();
    void add(CreatenewModelRequest createnewModelRequest);
}
