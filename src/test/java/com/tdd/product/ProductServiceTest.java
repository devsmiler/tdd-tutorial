package com.tdd.product;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductPort productPort;

    @Test
    void 상품수정(){
        productService.addProduct(ProductSteps.상품등록요청_생성());

        final Long productId = 1L;
        final UpdateProductRequest request = ProductSteps.상품수정요청_생성();
//        Mockito.when(productPort.getProduct(productId)).thenReturn(product);
//        productPort.getProduct_will_return = product;

        productService.updateProduct(productId, request);

        ResponseEntity<GetProductResponse> response = productService.getProduct(productId);
        GetProductResponse body = response.getBody();

        assertThat(body.name()).isEqualTo("상품 수정");
        assertThat(body.price()).isEqualTo(2000);

    }


//    private static class StubProductPort implements ProductPort {
//        public Product getProduct_will_return;
//
//        @Override
//        public void save(Product product) {
//
//        }
//
//        @Override
//        public Product getProduct(long productId) {
//            return getProduct_will_return;
//        }
//    }
}
