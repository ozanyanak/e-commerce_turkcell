package kodllama.io.ecommerce.business.concretes;

import kodllama.io.ecommerce.business.abstracts.SaleService;
import kodllama.io.ecommerce.business.dto.request.create.CreateSaleRequest;
import kodllama.io.ecommerce.business.dto.request.update.UpdateSaleRequest;
import kodllama.io.ecommerce.business.dto.response.create.CreateSaleResponse;
import kodllama.io.ecommerce.business.dto.response.get.GetAllSalesResponse;
import kodllama.io.ecommerce.business.dto.response.get.GetSaleResponse;
import kodllama.io.ecommerce.business.dto.response.update.UpdateSaleResponse;
import kodllama.io.ecommerce.entities.Sale;
import kodllama.io.ecommerce.repository.SaleRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Service
@AllArgsConstructor
public class SaleManager implements SaleService {
    //todo kurallar eklenecek ve fiyat ayaları yapılacak

    private ModelMapper mapper;
    private SaleRepository repository;

    @Override
    public List<GetAllSalesResponse> getAll() {
        var sales= repository.findAll();
        var response= sales.stream()
                .map(sale -> mapper.map(sale,GetAllSalesResponse.class))
                .toList();

        return response;
    }

    @Override
    public GetSaleResponse getById(int id) {
        Sale sale= repository.findById(id).orElseThrow();
        GetSaleResponse response = mapper.map(sale,GetSaleResponse.class);
        return response;
    }

    @Override
    public CreateSaleResponse add(CreateSaleRequest request) {
        Sale sale = mapper.map(request, Sale.class);
        sale.setId(0);
        sale.setTotalPrice(sale.getUnitPrice()*sale.getNumberOfPurchases());
        sale.setDateOfPurchase(LocalDateTime.now());
        repository.save(sale);
        CreateSaleResponse response = mapper.map(sale, CreateSaleResponse.class);

        return response;
    }

    @Override
    public UpdateSaleResponse update(int id, UpdateSaleRequest request) {
        Sale sale = mapper.map(request, Sale.class);
        sale.setId(id);
        sale.setTotalPrice(sale.getUnitPrice()*sale.getNumberOfPurchases());

        repository.save(sale);
        UpdateSaleResponse response = mapper.map(sale, UpdateSaleResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}