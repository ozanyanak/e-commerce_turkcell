package kodllama.io.ecommerce.business.concretes;

import kodllama.io.ecommerce.business.abstracts.InvoiceService;
import kodllama.io.ecommerce.business.dto.request.create.CreateInvoiceRequest;
import kodllama.io.ecommerce.business.dto.request.update.UpdateInvoiceRequest;
import kodllama.io.ecommerce.business.dto.response.create.CreateInvoiceResponse;
import kodllama.io.ecommerce.business.dto.response.get.GetAllInvoicesResponse;
import kodllama.io.ecommerce.business.dto.response.get.GetInvoiceResponse;
import kodllama.io.ecommerce.business.dto.response.update.UpdateInvoiceResponse;
import kodllama.io.ecommerce.entities.Invoice;
import kodllama.io.ecommerce.repository.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class InvoiceManager implements InvoiceService {

    private final InvoiceRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<GetAllInvoicesResponse> getAll() {
        List<Invoice> invoices = repository.findAll();
        List<GetAllInvoicesResponse> response = invoices
                .stream()
                .map(invoice -> mapper.map(invoice, GetAllInvoicesResponse.class))
                .toList();

        return response;
    }

    @Override
    public GetInvoiceResponse getById(int id) {
        Invoice invoice = repository.findById(id).orElseThrow();
        GetInvoiceResponse response = mapper.map(invoice, GetInvoiceResponse.class);

        return response;
    }

    @Override
    public CreateInvoiceResponse add(CreateInvoiceRequest request) {
        Invoice invoice = mapper.map(request, Invoice.class);
        invoice.setId(0);
        invoice.setTotalPrice(getTotalPrice(invoice));
        repository.save(invoice);
        CreateInvoiceResponse response = mapper.map(invoice, CreateInvoiceResponse.class);

        return response;
    }

    @Override
    public UpdateInvoiceResponse update(int id, UpdateInvoiceRequest request) {
        Invoice invoice = mapper.map(request, Invoice.class);
        invoice.setId(id);
        invoice.setTotalPrice(getTotalPrice(invoice));
        repository.save(invoice);
        UpdateInvoiceResponse response = mapper.map(invoice, UpdateInvoiceResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    private double getTotalPrice(Invoice invoice) {
        return invoice.getTotalPrice();
    }


}