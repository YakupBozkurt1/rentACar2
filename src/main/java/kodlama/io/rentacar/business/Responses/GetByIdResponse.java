package kodlama.io.rentacar.business.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdResponse {
    //Kullanıcıya response um ve benden gittiği için hem id hem name var
    private int id;
    private String name;

}