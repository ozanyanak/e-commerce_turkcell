package kodllama.io.ecommerce.business.dto.response.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetProductResponse {
    private int id;
    private int categoryId;

    private  String name;
    private  int quantify;
    private boolean status;

    private double price;

    private String description;
}
