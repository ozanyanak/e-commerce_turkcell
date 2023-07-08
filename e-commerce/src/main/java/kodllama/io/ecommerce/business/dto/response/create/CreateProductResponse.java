package kodllama.io.ecommerce.business.dto.response.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CreateProductResponse {
    private int id;
    private  String name;
    private  int quantify;
    private double price;

    private String description;
}
