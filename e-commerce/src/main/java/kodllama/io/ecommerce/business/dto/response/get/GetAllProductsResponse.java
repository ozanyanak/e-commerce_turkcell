package kodllama.io.ecommerce.business.dto.response.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllProductsResponse {
    private int id;
    private int categoryId;
    private String categoryName;

    private  String name;
    private  int quantify;
    private boolean status;

    private double price;

    private String description;
}

