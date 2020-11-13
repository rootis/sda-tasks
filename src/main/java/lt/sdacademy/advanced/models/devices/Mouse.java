package lt.sdacademy.advanced.models.devices;

import java.math.BigDecimal;

public class Mouse extends AbstractDevice {

    private boolean wired;

    public Mouse(boolean wired, BigDecimal basePrice) {
        super("Mouse", basePrice);
        this.wired = wired;
    }

    @Override
    public BigDecimal getPrice() {
        return getBasePrice().multiply(BigDecimal.valueOf(wired ? 1.1 : 1.2));
    }
}
