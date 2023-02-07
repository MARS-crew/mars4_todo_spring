package mars4.todos.bucket.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import mars4.todos.bucket.dto.RequestUpdateBucketDto;
import mars4.todos.bucket.dto.RequestUpdateStateBucketDto;
import mars4.todos.bucket.service.BucketService;
import mars4.todos.coommon.dto.RequestResponseDto;
import org.springframework.web.bind.annotation.*;

@Tag(name="Bucket List", description = "버킷 리스트")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bucket")
public class BucketController {
    private final BucketService bucketService;

    @Operation(summary = "Save Bucket", description = "버킷 생성하기")
    @ApiResponse(responseCode = "400", description = "Parameter type is incorrect")
    @ApiResponse(responseCode = "401", description = "Bad Credentials, JWT token expires")
    @ApiResponse(responseCode = "401", description = "Access denied")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @PostMapping("/{id}")
    public RequestResponseDto<?> saveBucket(@PathVariable(name = "id") Long id) {
        return bucketService.saveBucket(id);
    }

    @Operation(summary = "Find ALL Bucket", description = "모든 버킷 조회하기")
    @ApiResponse(responseCode = "400", description = "Parameter type is incorrect")
    @ApiResponse(responseCode = "401", description = "Bad Credentials, JWT token expires")
    @ApiResponse(responseCode = "401", description = "Access denied")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @GetMapping("/")
    public RequestResponseDto<?> findAllBucket() {
        return bucketService.findAllBucket();
    }

    @Operation(summary = "Save Bucket", description = "버킷 생성하기")
    @ApiResponse(responseCode = "400", description = "Parameter type is incorrect")
    @ApiResponse(responseCode = "401", description = "Bad Credentials, JWT token expires")
    @ApiResponse(responseCode = "401", description = "Access denied")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @GetMapping("/{id}")
    public RequestResponseDto<?> findBukcetById(@PathVariable(name = "id") Long id) {
        return bucketService.findOneBucket(id);
    }

    @Operation(summary = "Update Bucket", description = "버킷 수정하기")
    @ApiResponse(responseCode = "400", description = "Parameter type is incorrect")
    @ApiResponse(responseCode = "401", description = "Bad Credentials, JWT token expires")
    @ApiResponse(responseCode = "401", description = "Access denied")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @PutMapping("/{id}")
    public RequestResponseDto<?> updateBucket(@RequestBody RequestUpdateBucketDto dto, @PathVariable(name = "id") Long id) {
        return bucketService.updateBucket(dto, id);
    }

    @Operation(summary = "Update Bucket State", description = "버킷 상태 수정하기")
    @ApiResponse(responseCode = "400", description = "Parameter type is incorrect")
    @ApiResponse(responseCode = "401", description = "Bad Credentials, JWT token expires")
    @ApiResponse(responseCode = "401", description = "Access denied")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @PatchMapping("/{id}")
    public RequestResponseDto<?> updateStateBucket(@RequestBody RequestUpdateStateBucketDto dto, @PathVariable(name = "id") Long id) {
        return bucketService.updateStateBucket(dto, id);
    }

    @Operation(summary = "Save Bucket", description = "버킷 생성하기")
    @ApiResponse(responseCode = "400", description = "Parameter type is incorrect")
    @ApiResponse(responseCode = "401", description = "Bad Credentials, JWT token expires")
    @ApiResponse(responseCode = "401", description = "Access denied")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @DeleteMapping("/{id}")
    public RequestResponseDto<?> deleteBucket(@PathVariable(name = "id") Long id) {
        return bucketService.saveBucket(id);
    }
}
