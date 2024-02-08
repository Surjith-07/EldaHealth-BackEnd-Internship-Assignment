import java.util.Scanner;

public class Main {
    private static ParkingLot parkingLot = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine().trim();
            if (command.equals("exit")) {
                System.out.println("Exiting the program...");
                break;
            }
            executeCommand(command);
        }
    }

    private static void executeCommand(String command) {
        String[] parts = command.split(" ");
        switch (parts[0]) {
            case "create_parking_lot":
                int capacity = Integer.parseInt(parts[1]);
                parkingLot = new ParkingLot(capacity);
                System.out.println("Created a parking lot with " + capacity + " slots");
                break;
            case "park":
                if (parkingLot != null) {
                    System.out.println(parkingLot.park(parts[1], parts[2]));
                } else {
                    System.out.println("Parking lot not created. Use 'create_parking_lot' command first.");
                }
                break;
            case "leave":
                if (parkingLot != null) {
                    System.out.println(parkingLot.leave(Integer.parseInt(parts[1])));
                } else {
                    System.out.println("Parking lot not created. Use 'create_parking_lot' command first.");
                }
                break;
            case "status":
                if (parkingLot != null) {
                    System.out.println(parkingLot.status());
                } else {
                    System.out.println("Parking lot not created. Use 'create_parking_lot' command first.");
                }
                break;
            case "registration_numbers_for_cars_with_colour":
                if (parkingLot != null) {
                    System.out.println(parkingLot.registrationNumbersForCarsWithColor(parts[1]));
                } else {
                    System.out.println("Parking lot not created. Use 'create_parking_lot' command first.");
                }
                break;
            case "slot_numbers_for_cars_with_colour":
                if (parkingLot != null) {
                    System.out.println(parkingLot.slotNumbersForCarsWithColor(parts[1]));
                } else {
                    System.out.println("Parking lot not created. Use 'create_parking_lot' command first.");
                }
                break;
            case "slot_number_for_registration_number":
                if (parkingLot != null) {
                    System.out.println(parkingLot.slotNumberForRegistrationNumber(parts[1]));
                } else {
                    System.out.println("Parking lot not created. Use 'create_parking_lot' command first.");
                }
                break;
            default:
                System.out.println("Invalid command");
        }
    }
}
