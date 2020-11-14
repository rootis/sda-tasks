package lt.sdacademy.advanced.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lt.sdacademy.advanced.models.devices.Device;

public class ShoppingCartService {

    private List<Device> devices = new ArrayList<>();

    public void addDevice(Device device) {
        devices.add(device);
    }

    public void addDevices(Device... deviceList) {
        devices.addAll(Arrays.asList(deviceList));
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

    public List<Device> getDevicesByName(String name) {
        List<Device> devices = new ArrayList<>();

        for (Device device : this.devices) {
            if (device.getName().equals(name)) {
                devices.add(device);
            }
        }

        return devices;
    }

    public Map<String, List<Device>> groupByName() {
        Map<String, List<Device>> result = new HashMap<>();

        for (Device device : devices) {
            if (!result.containsKey(device.getName())) {
                result.put(device.getName(), new ArrayList<>());
            }
            result.get(device.getName()).add(device);
        }

        return result;
    }

    public List<Device> getDevices() {
        return devices;
    }
}
