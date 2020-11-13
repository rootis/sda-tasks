package lt.sdacademy.advanced.models.devices;

import java.math.BigDecimal;

public class Laptop extends AbstractDevice {

    private Mouse mouse;
    private boolean touchscreen;

    public Laptop(Mouse mouse, boolean touchscreen, BigDecimal basePrice) {
        super("Laptop", basePrice);
        this.mouse = mouse;
        this.touchscreen = touchscreen;
    }

    @Override
    public BigDecimal getPrice() {
        return getBasePrice().multiply(BigDecimal.valueOf(touchscreen ? 1.1 : 1.4)).add(mouse.getPrice());
    }
}
