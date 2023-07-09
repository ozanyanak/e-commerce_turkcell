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
public class UpdateInvoiceRequest {
    private String cardHolder;
    private String productName;
    private double totalPrice;
    private int numberOfPurchases;
    private LocalDateTime saledAt;

}
