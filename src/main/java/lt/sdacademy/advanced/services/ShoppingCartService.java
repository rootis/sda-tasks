package lt.sdacademy.advanced.services;

import java.util.ArrayList;
import java.util.List;
import lt.sdacademy.advanced.models.devices.Device;

public class ShoppingCartService {

    private List<Device> devices = new ArrayList<>();

    public void addDevice(Device device) {
        devices.add(device);
    }

    public List<Device> getDevices() {
        return devices;
    }
}
