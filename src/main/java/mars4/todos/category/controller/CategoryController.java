package mars4.todos.category.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import mars4.todos.category.dto.RequestSaveCategoryDto;
import mars4.todos.category.service.CategoryService;
import mars4.todos.coommon.dto.RequestResponseDto;
import org.springframework.web.bind.annotation.*;

@Tag(name="Category", description = "카테고리 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;

    @Operation(summary = "Save First Category", description = "대분류 생성")
    @ApiResponse(responseCode = "400", description = "Parameter type is incorrect")
    @ApiResponse(responseCode = "401", description = "Bad Credentials, JWT token expires")
    @ApiResponse(responseCode = "401", description = "Access denied")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @PostMapping("/first")
    public RequestResponseDto<?> saveFirstCategory(@RequestBody RequestSaveCategoryDto dto) {
        return categoryService.saveFirstCategory(dto);
    }

    @Operation(summary = "Save Second Category", description = "중분류 생성")
    @ApiResponse(responseCode = "400", description = "Parameter type is incorrect")
    @ApiResponse(responseCode = "401", description = "Bad Credentials, JWT token expires")
    @ApiResponse(responseCode = "401", description = "Access denied")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @PostMapping("/second/{id}")
    public RequestResponseDto<?> saveSecondCategory(@RequestBody RequestSaveCategoryDto dto, @PathVariable(name = "id") Long id) {
        return categoryService.saveSecondCategory(dto, id);
    }

    @Operation(summary = "Save Third Category", description = "소분류 생성")
    @ApiResponse(responseCode = "400", description = "Parameter type is incorrect")
    @ApiResponse(responseCode = "401", description = "Bad Credentials, JWT token expires")
    @ApiResponse(responseCode = "401", description = "Access denied")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @PostMapping("/third/{id}")
    public RequestResponseDto<?> saveThirdCategory(@RequestBody RequestSaveCategoryDto dto, @PathVariable(name = "id") Long id) {
        return categoryService.saveThirdCategory(dto, id);
    }

    @Operation(summary = "Find All Category", description = "모든 카테고리 조회")
    @ApiResponse(responseCode = "400", description = "Parameter type is incorrect")
    @ApiResponse(responseCode = "401", description = "Bad Credentials, JWT token expires")
    @ApiResponse(responseCode = "401", description = "Access denied")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @GetMapping()
    public RequestResponseDto<?> getAllCategory() {
        return categoryService.findCategory();
    }

}
