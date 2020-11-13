package lt.sdacademy.advanced.models.devices;

import java.math.BigDecimal;

public class Keyboard extends AbstractDevice {

    private boolean wired;

    public Keyboard(boolean wired, BigDecimal basePrice) {
        super("Keyboard", basePrice);
        this.wired = wired;
    }

    @Override
    public BigDecimal getPrice() {
        return getBasePrice().multiply(BigDecimal.valueOf(wired ? 1.1 : 1.5));
    }
}
