package com.tdd.order;

import com.tdd.ApiTest;
import com.tdd.product.ProductSteps;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderApiTest extends ApiTest {

    @Test
    void 상품주문(){
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        final CreateOrderRequest request = OrderSteps.상품주문요청_생성();
        ExtractableResponse<Response> response = OrderSteps.상품주문요청(request);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());

    }

}
