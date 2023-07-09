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
public class CreateInvoiceResponse {
    private String cardHolder;
    private String productName;
    private double totalPrice;
    private int numberOfPurchases;
    private LocalDateTime saledAt;

}
