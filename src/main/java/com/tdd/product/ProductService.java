package com.tdd.product;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public
class ProductService {
    private final ProductPort productPort;

    public ProductService(ProductPort productPort) {
        this.productPort = productPort;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> addProduct(@RequestBody final AddProductRequest request) {
        final Product product = new Product(request.name(), request.price(), request.discountPolicy());

        productPort.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<GetProductResponse> getProduct(@PathVariable  long productId) {
        final Product product = productPort.getProduct(productId);
        GetProductResponse response = new GetProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getDiscountPolicy());
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{productId}")
    @Transactional
    public void updateProduct(
            @PathVariable Long productId,
            @RequestBody UpdateProductRequest request) {
        final Product product = productPort.getProduct(productId);
        product.update(request.name(), request.price(), request.discountPolicy());
        productPort.save(product);
    }
}
