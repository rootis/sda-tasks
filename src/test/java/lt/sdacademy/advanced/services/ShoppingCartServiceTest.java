package lt.sdacademy.advanced.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
        shoppingCartService.addDevices(mouse, keyboard, monitor);

        assertEquals(3, shoppingCartService.getDevices().size());
        assertEquals(new HashSet<>(Arrays.asList(mouse, keyboard, monitor)), new HashSet<>(shoppingCartService.getDevices()));
    }

    @Test
    void getTheMostExpensive() {
        Mouse mouse = new Mouse(false, new BigDecimal(25));
        Keyboard keyboard = new Keyboard(false, new BigDecimal(45));
        Monitor monitor = new Monitor(27, new BigDecimal(600));
        shoppingCartService.addDevices(mouse, keyboard, monitor);

        Device device = shoppingCartService.getTheMostExpensive();

        assertEquals(monitor, device);
    }

    @Test
    void getDeviceNames() {
        Mouse mouse = new Mouse(false, new BigDecimal(25));
        Keyboard keyboard = new Keyboard(false, new BigDecimal(45));
        Monitor monitor = new Monitor(27, new BigDecimal(600));
        shoppingCartService.addDevices(mouse, keyboard, monitor);

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
        shoppingCartService.addDevices(mouse, keyboard, monitor);

        List<Device> result = shoppingCartService.getDevicesByName(keyboard.getName());

        assertEquals(1, result.size());
        assertEquals(keyboard, result.get(0));
        assertEquals(keyboard.getPrice(), result.get(0).getPrice());
    }

    @Test
    void groupByName() {
        Mouse m1 = new Mouse(false, new BigDecimal(25));
        Mouse m2 = new Mouse(false, new BigDecimal(29));
        Keyboard k1 = new Keyboard(false, new BigDecimal(45));
        Keyboard k2 = new Keyboard(false, new BigDecimal(52));
        Monitor monitor = new Monitor(27, new BigDecimal(600));
        shoppingCartService.addDevices(m1, m2, k1, k2, monitor);

        Map<String, List<Device>> result = shoppingCartService.groupByName();

        assertEquals(3, result.keySet().size());
        assertTrue(result.get(m1.getName()).contains(m1));
        assertTrue(result.get(m1.getName()).contains(m2));
        assertTrue(result.get(k1.getName()).contains(k1));
        assertTrue(result.get(k1.getName()).contains(k2));
        assertTrue(result.get(monitor.getName()).contains(monitor));
    }
}
