package lt.sdacademy.advanced.models.devices;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Monitor extends AbstractDevice {

    private int screenSize;

    public Monitor(int screenSize, BigDecimal basePrice) {
        super("Monitor", basePrice);
        this.screenSize = screenSize;
    }

    @Override
    public BigDecimal getPrice() {
        return getBasePrice().add(getBasePrice().divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(screenSize)));
    }
}
