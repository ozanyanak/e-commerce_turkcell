package kodllama.io.ecommerce.business.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class PaymentRequest {
    @NotBlank(message = "Kart numarası alanı boş olmamalı.")
    @Length(min = 16, max = 16, message = "Kart numarası 16 haneden oluşmalıdır.")
    private String cardNumber; // 16 haneli

    @NotBlank(message = "Kart sahibi bilgisi boş olmamalı.")
    @Length(min = 5, message = "Kart sahibi bilgisi 5 karakterden az olamaz")
    private String cardHolder;

    @NotNull(message = "Kart son kullanma yılı boş bırakılamaz.")
    @Min(value = 2023, message = "son kullanma tarihi geçmiş kartlar kullanılamaz.")
    private int cardExpirationYear; // minimum 2023

    @NotNull
    @Max(value = 12)
    @Min(value = 1)
    private int cardExpirationMonth; // 1 ile 12

    @NotBlank
    @Length(min = 3, max = 3)
    private String cardCvv; // 3 haneli olmalı
}