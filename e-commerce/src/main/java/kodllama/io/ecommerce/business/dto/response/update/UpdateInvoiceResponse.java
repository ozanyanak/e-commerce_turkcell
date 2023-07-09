package kodllama.io.ecommerce.business.dto.response.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public class UpdateInvoiceResponse {
        private String cardHolder;
        private String productName;
        private int modelYear;
        private double totalPrice;
        private int numberOfPurchases;
        private LocalDateTime saledAt;

    }
