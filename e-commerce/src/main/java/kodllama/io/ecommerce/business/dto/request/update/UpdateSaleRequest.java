package kodllama.io.ecommerce.business.dto.request.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateSaleRequest {

    private int productId;

    private int numberOfPurchases;
    private double unitPrice;
    private LocalDateTime dateOfPurchase;

}
