package kodllama.io.ecommerce.adapters;


import kodllama.io.ecommerce.business.abstracts.PosService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class FakePostServiceAdapter implements PosService {
    @Override
    public void pay() {
        boolean isPaymentSuccesful = new Random().nextBoolean();
        if (!isPaymentSuccesful) throw new RuntimeException();
    }
}