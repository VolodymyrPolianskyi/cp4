package pl.vpolianskyi.ecommerce.payu;

import org.junit.jupiter.api.Test;
import static  org.junit.jupiter.api.Assertions.*;

public class PayUTest {
    @Test
    void itRegisterPayment(){
        PayU payU = ThereIsPayU();

        OrderCreateRequest request = thereIsExampleOrderCreateRequest();
        OrderCreateResponse  response = payU.handle(request);

        assertNotNull(response.getRedirectUri());
        assertNotNull(response.getOrderId());
    }

    private OrderCreateRequest thereIsExampleOrderCreateRequest() {
        return null;
    }

    private PayU ThereIsPayU() {
        return new PayU();
    }
}
