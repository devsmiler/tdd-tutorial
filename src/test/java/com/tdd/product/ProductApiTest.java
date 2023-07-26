package com.tdd.product;

import com.tdd.ApiTest;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;


import static com.tdd.product.ProductSteps.상품등록요청;
import static com.tdd.product.ProductSteps.상품등록요청_생성;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProductApiTest extends ApiTest {
    @Autowired
    ProductRepository productRepository;

    @Test
    void 상품등록(){
        final var request = 상품등록요청_생성();
        final var response = 상품등록요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }
    @Test
    void 상품조회(){
        final var request = ProductSteps.상품등록요청_생성();
        ProductSteps.상품등록요청(request);
        Long productId = 1L;

        final var response = ProductSteps.getExtract(productId);

        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        Assertions.assertThat(response.jsonPath().getString("name")).isEqualTo("상품명");
    }

    @Test
    void 상품수정() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        final long productId = 1L;
        final ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(ProductSteps.상품수정요청_생성())
                .when().patch("/products/{productId}", productId).then().log().all().extract();


        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        Assertions.assertThat(productRepository.findById(1L).get().getName()).isEqualTo("상품 수정");

    }
}
