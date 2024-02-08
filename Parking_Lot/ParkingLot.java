import java.util.HashMap;
import java.util.Map;

class ParkingLot {
    private int capacity;
    private Map<Integer, Car> parkingMap;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkingMap = new HashMap<>();
    }

    public String park(String registrationNumber, String colour) {
        int slotNumber = findNextAvailableSlot();
        if (slotNumber != -1) {
            Car car = new Car(registrationNumber, colour);
            parkingMap.put(slotNumber, car);
            return "Allocated slot number: " + slotNumber;
        } else {
            return "Sorry, parking lot is full";
        }
    }

    public String leave(int slotNumber) {
        if (parkingMap.containsKey(slotNumber)) {
            parkingMap.remove(slotNumber);
            return "Slot number " + slotNumber + " is free";
        } else {
            return "Slot number " + slotNumber + " not found";
        }
    }

    public String status() {
        StringBuilder statusOutput = new StringBuilder("Slot No. Registration   No Colour\n");
        for (Map.Entry<Integer, Car> entry : parkingMap.entrySet()) {
            Car car = entry.getValue();
            statusOutput.append(entry.getKey()).append("\t ").append(car.getRegistrationNumber())
                    .append("\t").append(car.getColor()).append("\n");
        }
        return statusOutput.toString().trim();
    }

    public String registrationNumbersForCarsWithColor(String colour) {
        StringBuilder registrationNumbers = new StringBuilder();
        for (Car car : parkingMap.values()) {
            if (car.getColor().equalsIgnoreCase(colour)) {
                registrationNumbers.append(car.getRegistrationNumber()).append(", ");
            }
        }
        return registrationNumbers.length() > 0 ?
                registrationNumbers.substring(0, registrationNumbers.length() - 2) :
                "Not found";
    }

    public String slotNumbersForCarsWithColor(String colour) {
        StringBuilder slotNumbers = new StringBuilder();
        for (Map.Entry<Integer, Car> entry : parkingMap.entrySet()) {
            Car car = entry.getValue();
            if (car.getColor().equalsIgnoreCase(colour)) {
                slotNumbers.append(entry.getKey()).append(", ");
            }
        }
        return slotNumbers.length() > 0 ?
                slotNumbers.substring(0, slotNumbers.length() - 2) :
                "Not found";
    }

    public String slotNumberForRegistrationNumber(String registrationNumber) {
        for (Map.Entry<Integer, Car> entry : parkingMap.entrySet()) {
            Car car = entry.getValue();
            if (car.getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
                return String.valueOf(entry.getKey());
            }
        }
        return "Not found";
    }

    private int findNextAvailableSlot() {
        for (int i = 1; i <= capacity; i++) {
            if (!parkingMap.containsKey(i)) {
                return i;
            }
        }
        return -1; 
    }
}