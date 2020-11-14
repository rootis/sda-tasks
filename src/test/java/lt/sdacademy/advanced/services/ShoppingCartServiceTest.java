package lt.sdacademy.advanced.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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

    @Test
    void getTheMostExpensive() {
        Mouse mouse = new Mouse(false, new BigDecimal(25));
        Keyboard keyboard = new Keyboard(false, new BigDecimal(45));
        Monitor monitor = new Monitor(27, new BigDecimal(600));

        shoppingCartService.addDevice(mouse);
        shoppingCartService.addDevice(keyboard);
        shoppingCartService.addDevice(monitor);

        Device device = shoppingCartService.getTheMostExpensive();

        assertEquals(monitor, device);
    }

    @Test
    void getDeviceNames() {
        Mouse mouse = new Mouse(false, new BigDecimal(25));
        Keyboard keyboard = new Keyboard(false, new BigDecimal(45));
        Monitor monitor = new Monitor(27, new BigDecimal(600));

        shoppingCartService.addDevice(mouse);
        shoppingCartService.addDevice(keyboard);
        shoppingCartService.addDevice(monitor);

        List<String> result = shoppingCartService.getDeviceNames();

        assertEquals(3, result.size());
        assertTrue(result.contains(mouse.getName()));
        assertTrue(result.contains(keyboard.getName()));
        assertTrue(result.contains(monitor.getName()));
    }

    @Test
    void getDevicesByName() {
        Mouse mouse = new Mouse(false, new BigDecimal(25));
        Keyboard keyboard = new Keyboard(false, new BigDecimal(45));
        Monitor monitor = new Monitor(27, new BigDecimal(600));

        shoppingCartService.addDevice(mouse);
        shoppingCartService.addDevice(keyboard);
        shoppingCartService.addDevice(monitor);

        List<Device> result = shoppingCartService.getDevicesByName(keyboard.getName());

        assertEquals(1, result.size());
        assertEquals(keyboard, result.get(0));
        assertEquals(keyboard.getPrice(), result.get(0).getPrice());
    }
}
