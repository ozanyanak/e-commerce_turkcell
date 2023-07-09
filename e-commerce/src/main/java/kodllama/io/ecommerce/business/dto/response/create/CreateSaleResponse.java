package kodllama.io.ecommerce.business.dto.response.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateSaleResponse {

    private int id;

    private int productId;

    private int numberOfPurchases;
    private double unitPrice;
    private double totalPrice;
    private LocalDateTime dateOfPurchase;
}
