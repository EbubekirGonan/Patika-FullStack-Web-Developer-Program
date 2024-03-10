package dev.patika.api;

import dev.patika.business.abstracts.ICategoryService;
import dev.patika.core.config.modelMapper.IModelMapperService;
import dev.patika.core.result.Result;
import dev.patika.core.result.ResultWithData;
import dev.patika.core.utilities.ResultHelper;
import dev.patika.dto.request.category.CategorySaveRequest;
import dev.patika.dto.request.category.CategoryUpdateRequest;
import dev.patika.dto.response.CursorResponse;
import dev.patika.dto.response.category.CategoryResponse;
import dev.patika.entities.Category;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {
    private final ICategoryService categoryService;
    private final IModelMapperService modelMapper;

    //CRUD
    public CategoryController(ICategoryService categoryService, IModelMapperService modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultWithData<CategoryResponse> save(@Valid @RequestBody CategorySaveRequest categorySaveRequest){
        Category category = this.modelMapper.forRequest().map(categorySaveRequest, Category.class);
        this.categoryService.save(category);
        return ResultHelper.success(this.modelMapper.forResponse().map(category, CategoryResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<CategoryResponse> get(@PathVariable ("id") int id){
        Category category = this.categoryService.get(id);
        return ResultHelper.success(this.modelMapper.forResponse().map(category, CategoryResponse.class));
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<CategoryResponse> update(@Valid @RequestBody CategoryUpdateRequest categoryUpdateRequest){
        Category category = this.modelMapper.forRequest().map(categoryUpdateRequest, Category.class);
        this.categoryService.update(category);
        return ResultHelper.success(this.modelMapper.forResponse().map(category, CategoryResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable ("id") int id){
        this.categoryService.delete(id);
        return ResultHelper.ok();
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<CursorResponse<CategoryResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ){
        Page<Category> categoryPage = this.categoryService.cursor(page, pageSize);
        Page<CategoryResponse> categoryResponses = categoryPage.map(category -> this.modelMapper.forResponse().map(category, CategoryResponse.class));
        return ResultHelper.cursor(categoryResponses);
    }
}
