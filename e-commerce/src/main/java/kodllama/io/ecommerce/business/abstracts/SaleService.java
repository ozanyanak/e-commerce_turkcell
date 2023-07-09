package kodllama.io.ecommerce.business.abstracts;

import kodllama.io.ecommerce.business.dto.request.create.CreateSaleRequest;
import kodllama.io.ecommerce.business.dto.request.update.UpdateSaleRequest;
import kodllama.io.ecommerce.business.dto.response.create.CreateSaleResponse;
import kodllama.io.ecommerce.business.dto.response.get.GetAllSalesResponse;
import kodllama.io.ecommerce.business.dto.response.get.GetSaleResponse;
import kodllama.io.ecommerce.business.dto.response.update.UpdateSaleResponse;

import java.util.List;

public interface SaleService {
    List<GetAllSalesResponse> getAll();

    GetSaleResponse getById(int id);

    CreateSaleResponse add(CreateSaleRequest request);

    UpdateSaleResponse update(int id, UpdateSaleRequest request);

    void delete(int id);
}
