package lt.sdacademy.advanced.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import lt.sdacademy.advanced.models.devices.Device;
import lt.sdacademy.advanced.models.devices.Keyboard;
import lt.sdacademy.advanced.models.devices.Monitor;
import lt.sdacademy.advanced.models.devices.Mouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShoppingCartServiceTest {

    private ShoppingCartService shoppingCartService;

    @BeforeEach
    void setUp() {
        shoppingCartService = new ShoppingCartService();
    }

    @Test
    void addDevice() {
        Mouse mouse = new Mouse(false, new BigDecimal(25));
        Keyboard keyboard = new Keyboard(false, new BigDecimal(45));
        Monitor monitor = new Monitor(27, new BigDecimal(600));

        shoppingCartService.addDevice(mouse);
        shoppingCartService.addDevice(keyboard);
        shoppingCartService.addDevice(monitor);

        assertEquals(3, shoppingCartService.getDevices().size());
        assertEquals(new HashSet<>(Arrays.asList(mouse, keyboard, monitor)), new HashSet<>(shoppingCartService.getDevices()));
    }
}
