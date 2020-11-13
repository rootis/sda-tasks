package lt.sdacademy.advanced.models.devices;

import java.math.BigDecimal;

public abstract class AbstractDevice implements Device {

    private String name;
    private BigDecimal basePrice;

    public AbstractDevice(String name, BigDecimal basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    @Override
    public String getName() {
        return name;
    }

    protected BigDecimal getBasePrice() {
        return basePrice;
    }
}
