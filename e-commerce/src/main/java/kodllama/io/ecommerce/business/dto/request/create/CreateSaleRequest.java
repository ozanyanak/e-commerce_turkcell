package kodllama.io.ecommerce.business.dto.request.create;

import kodllama.io.ecommerce.business.dto.request.PaymentRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateSaleRequest {
    private int productId;

    private int numberOfPurchases;
    private double unitPrice;

    private PaymentRequest paymentRequest;


}
