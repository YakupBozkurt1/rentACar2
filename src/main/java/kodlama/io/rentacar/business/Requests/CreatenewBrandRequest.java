package kodlama.io.rentacar.business.Requests;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatenewBrandRequest {
    //Kullanıcıdan bilgi request ediyorum ve sadece name i istiyorum id onda yok çünkü

    @NotNull
    @NotBlank
    @Size(min = 3 , max = 20)
    private String name;
}
