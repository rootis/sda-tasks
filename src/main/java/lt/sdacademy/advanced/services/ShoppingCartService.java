package lt.sdacademy.advanced.services;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
        /*
        Device result = null;

        for (Device device : devices) {
            if (result == null || device.getPrice().compareTo(result.getPrice()) > 0) {
                result = device;
            }
        }

        return result;
        */
        return devices.stream().max(Comparator.comparing(Device::getPrice)).orElse(null);
    }

    public List<String> getDeviceNames() {
        /*
        List<String> result = new ArrayList<>();

        for (Device device : devices) {
            result.add(device.getName());
        }

        return result;
        */
        return devices
            .stream()
            .map(Device::getName)
            .collect(toList());
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

    public Map<String, Integer> calculateDeviceAmounts() {
        Map<String, Integer> result = new HashMap<>();

        for (Device device : devices) {
            if (!result.containsKey(device.getName())) {
                result.put(device.getName(), 0);
            }
            Integer oldDevicesAmount = result.get(device.getName());
            result.put(device.getName(), oldDevicesAmount + 1);
        }

        return result;
    }

    public List<Device> getDevices() {
        return devices;
    }
}
