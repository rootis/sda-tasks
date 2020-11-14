package lt.sdacademy.advanced.models;

import java.math.BigDecimal;

public class Worker extends Human {

    private BigDecimal salary;

    @Override
    public String getName() {
        return "Worker " + super.getName();
    }
}
