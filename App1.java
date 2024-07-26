package examples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class App1 {

    private static final String BUS_DATA_FILE = "bus_data.txt";

    public static void main(String[] args) {
        Bus bus;
        Passenger passenger = new Passenger(null, null, null, null);

        try {
            System.out.println("Loading previous data...");
            FileInputStream fileIn = new FileInputStream(BUS_DATA_FILE);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            bus = (Bus) objectIn.readObject();
            objectIn.close();
            System.out.println("Previous data loaded...");
        } catch (FileNotFoundException e) {
            bus = new Bus();
            System.out.println("No previous data found. Creating a new bus.");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Scanner inputreader = new Scanner(System.in);
        int choice;

        do {
            System.out.println("------Welcome to the reservation system-----\n");
            System.out.println("      1- Make a reservation");
            System.out.println("      2- Cancel a reservation");
            System.out.println("      3- Search for a reservation");
            System.out.println("      4- Update Your ID..)");
            System.out.println("      5- List of reservation (admin only :) ..)\n");
            System.out.print("Enter a number (1-5) to continue, 0 to exit: ");
            choice = inputreader.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("\nTo make a reservation, enter the id: ");
                    int id = inputreader.nextInt();

                    System.out.print("Enter your name: ");
                    passenger.setName(inputreader.next());
                    System.out.print("Enter your surname: ");
                    passenger.setSurname(inputreader.next());
                    System.out.print("Enter your phone number: ");
                    passenger.setPhonenumber(inputreader.next());
                    System.out.print("Enter your mail: ");
                    passenger.setMail(inputreader.next());

                    bus.makeReservation(id, passenger);
                    System.out.println();
                    break;

                case 2:
                    System.out.print("\nTo cancel a reservation, enter the reservation id: ");
                    id = inputreader.nextInt();
                    bus.deleteReservation(id);
                    System.out.println();
                    break;

                case 3:
                    System.out.print("\nTo search for a reservation, enter the reservation id: ");
                    id = inputreader.nextInt();
                    bus.searchReservation(id);
                    System.out.println();
                    break;

                case 4:
                    System.out.print("\nTo update a reservation, enter the reservation id: ");
                    id = inputreader.nextInt();
                    System.out.print("Enter the new id: ");
                    int newId = inputreader.nextInt();
                    bus.updateId(id, passenger, newId);
                    System.out.println();
                    break;

                case 5:
                    int enteredPw;
                    final int pw = 1234;
                    System.out.print("\nTo access this part enter your password: ");
                    enteredPw = inputreader.nextInt();

                    if (enteredPw == pw) {
                        bus.listOfReservation();
                    } else {
                        System.out.println("Incorrect password...");
                    }
                    System.out.println();
                    break;

                default:
                    if (choice != 0)
                        System.out.println("\nPlease enter a valid choice (0-5)...\n");
                    else
                        System.out.println("\nLooking forward to seeing you again :) bye!");
                    System.out.println();
            }
        } while (bus.numberofreservedseats != bus.numberofseats && choice != 0);

        inputreader.close();

        try {
            FileOutputStream fileOut = new FileOutputStream(BUS_DATA_FILE);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(bus);
            objectOut.close();

            System.out.println("Bus data saved...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
