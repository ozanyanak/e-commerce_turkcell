package kodllama.io.ecommerce.business.concretes;

import kodllama.io.ecommerce.business.abstracts.PaymentService;
import kodllama.io.ecommerce.business.abstracts.PosService;
import kodllama.io.ecommerce.business.dto.request.create.CreatePaymentRequest;
import kodllama.io.ecommerce.business.dto.request.update.UpdatePaymentRequest;
import kodllama.io.ecommerce.business.dto.response.create.CreatePaymentResponse;
import kodllama.io.ecommerce.business.dto.response.get.GetAllPaymentsResponse;
import kodllama.io.ecommerce.business.dto.response.get.GetPaymentResponse;
import kodllama.io.ecommerce.business.dto.response.update.UpdatePaymentResponse;
import kodllama.io.ecommerce.common.dto.CreateSalePaymentRequest;
import kodllama.io.ecommerce.entities.Payment;
import kodllama.io.ecommerce.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {
    private ModelMapper mapper;
    private PaymentRepository repository;
    private PosService posService;
    @Override
    public List<GetAllPaymentsResponse> getAll() {
        List<Payment> payments = repository.findAll();
        List<GetAllPaymentsResponse> response = payments
                .stream()
                .map(payment -> mapper.map(payment, GetAllPaymentsResponse.class))
                .toList();

        return response;
    }

    @Override
    public GetPaymentResponse getById(int id) {
        Payment payment = repository.findById(id).orElseThrow();
        GetPaymentResponse response = mapper.map(payment, GetPaymentResponse.class);

        return response;
    }

    @Override
    public CreatePaymentResponse add(CreatePaymentRequest request) {
        Payment payment = mapper.map(request, Payment.class);
        payment.setId(0);
        repository.save(payment);
        CreatePaymentResponse response = mapper.map(payment, CreatePaymentResponse.class);

        return response;
    }

    @Override
    public UpdatePaymentResponse update(int id, UpdatePaymentRequest request) {
        Payment payment = mapper.map(request, Payment.class);
        payment.setId(id);
        repository.save(payment);
        UpdatePaymentResponse response = mapper.map(payment, UpdatePaymentResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void processSalePayment(CreateSalePaymentRequest request) {
        Payment payment = repository.findByCardNumber(request.getCardNumber());
        posService.pay(); // fake pos service
        payment.setBalance(payment.getBalance() - request.getPrice());
        repository.save(payment);
    }
}
