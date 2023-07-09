package kodllama.io.ecommerce.business.dto.request.create;

import jakarta.validation.constraints.Min;
import kodllama.io.ecommerce.business.dto.request.PaymentRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class CreatePaymentRequest extends PaymentRequest {
    @Min(value = 1)

    private double balance;


}