package lt.sdacademy.advanced.services;

import java.util.ArrayList;
import java.util.List;
import lt.sdacademy.advanced.models.devices.Device;

public class ShoppingCartService {

    private List<Device> devices = new ArrayList<>();

    public void addDevice(Device device) {
        devices.add(device);
    }

    public Device getTheMostExpensive() {
        Device result = null;

        for (Device device : devices) {
            if (result == null || device.getPrice().compareTo(result.getPrice()) > 0) {
                result = device;
            }
        }

        return result;
    }

    public List<String> getDeviceNames() {
        List<String> result = new ArrayList<>();

        for (Device device : devices) {
            result.add(device.getName());
        }

        return result;
    }

    public List<Device> getDevices() {
        return devices;
    }
}
