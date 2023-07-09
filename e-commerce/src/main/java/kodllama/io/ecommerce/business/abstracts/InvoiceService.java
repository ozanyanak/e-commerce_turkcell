package kodllama.io.ecommerce.business.abstracts;

import kodllama.io.ecommerce.business.dto.request.create.CreateInvoiceRequest;
import kodllama.io.ecommerce.business.dto.request.update.UpdateInvoiceRequest;
import kodllama.io.ecommerce.business.dto.response.create.CreateInvoiceResponse;
import kodllama.io.ecommerce.business.dto.response.get.GetAllInvoicesResponse;
import kodllama.io.ecommerce.business.dto.response.get.GetInvoiceResponse;
import kodllama.io.ecommerce.business.dto.response.update.UpdateInvoiceResponse;

import java.util.List;

public interface InvoiceService {
    List<GetAllInvoicesResponse> getAll();

    GetInvoiceResponse getById(int id);

    CreateInvoiceResponse add(CreateInvoiceRequest request);

    UpdateInvoiceResponse update(int id, UpdateInvoiceRequest request);

    void delete(int id);
}