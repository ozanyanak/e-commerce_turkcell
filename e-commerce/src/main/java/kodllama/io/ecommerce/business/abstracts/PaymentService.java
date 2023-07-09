package kodllama.io.ecommerce.business.abstracts;

import kodllama.io.ecommerce.business.dto.request.create.CreatePaymentRequest;
import kodllama.io.ecommerce.business.dto.request.update.UpdatePaymentRequest;
import kodllama.io.ecommerce.business.dto.response.create.CreatePaymentResponse;
import kodllama.io.ecommerce.business.dto.response.get.GetAllPaymentsResponse;
import kodllama.io.ecommerce.business.dto.response.get.GetPaymentResponse;
import kodllama.io.ecommerce.business.dto.response.update.UpdatePaymentResponse;
import kodllama.io.ecommerce.common.dto.CreateSalePaymentRequest;

import java.util.List;

public interface PaymentService {


    List<GetAllPaymentsResponse> getAll();

    GetPaymentResponse getById(int id);

    CreatePaymentResponse add(CreatePaymentRequest request);

    UpdatePaymentResponse update(int id, UpdatePaymentRequest request);

    void delete(int id);

    //todo process kısmı yazılacak
    void processPayment(CreateSalePaymentRequest request);

}