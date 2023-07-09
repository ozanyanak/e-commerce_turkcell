package kodllama.io.ecommerce.business.concretes;

import kodllama.io.ecommerce.business.abstracts.CategoryService;
import kodllama.io.ecommerce.business.dto.request.create.CreateCategoryRequest;
import kodllama.io.ecommerce.business.dto.request.update.UpdateCategoryRequest;
import kodllama.io.ecommerce.business.dto.response.create.CreateCategoryResponse;
import kodllama.io.ecommerce.business.dto.response.get.GetAllCategoriesResponse;
import kodllama.io.ecommerce.business.dto.response.get.GetCategoryResponse;
import kodllama.io.ecommerce.business.dto.response.update.UpdateCategoryResponse;
import kodllama.io.ecommerce.entities.Category;
import kodllama.io.ecommerce.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private ModelMapper mapper;
    private CategoryRepository repository;
    //todo kurallar eklenecek

    @Override
    public List<GetAllCategoriesResponse> getAll() {
        var categories = repository.findAll();
        var response = categories
                .stream()
                .map(category -> mapper.map(category, GetAllCategoriesResponse.class))
                .toList();

        return response;
    }

    @Override
    public GetCategoryResponse getById(int id) {
        Category category = repository.findById(id).orElseThrow();
        GetCategoryResponse response = mapper.map(category, GetCategoryResponse.class);
        return response;
    }

    @Override
    public CreateCategoryResponse add(CreateCategoryRequest request) {

        Category category = mapper.map(request, Category.class);
        category.setId(0);
        repository.save(category);
        CreateCategoryResponse response = mapper.map(category, CreateCategoryResponse.class);

        return response;
    }

    @Override
    public UpdateCategoryResponse update(int id, UpdateCategoryRequest request) {
        Category category = mapper.map(request, Category.class);
        category.setId(id);
        repository.save(category);
        UpdateCategoryResponse response = mapper.map(category, UpdateCategoryResponse.class);
        return response;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
