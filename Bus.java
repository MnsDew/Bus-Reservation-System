package examples;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Bus implements Reservation, Serializable {

    private static final long serialVersionUID = 1L;
    ArrayList<Seat> seats = new ArrayList<>();
    int numberofseats = 40;
    int numberofreservedseats = 0;
    int numberofunreservedseats = this.numberofseats;
    transient Scanner inputreader = new Scanner(System.in);

    Bus() {
        for (int i = 0; i < this.numberofseats; i++) {
            seats.add(new Seat(i + 1));
        }
    }

    @Override
    public String toString() {
        return "Bus [seats=" + seats + ", numberofseats=" + numberofseats + ", numberofreservedseats="
                + numberofreservedseats + ", numberofunreservedseats=" + numberofunreservedseats + "]";
    }

    @Override
    public void makeReservation(int id, Passenger passenger) {
        id = id - 1;

        if (id < 0 || id >= numberofseats) {
            System.out.println("Invalid ID. Please enter an ID between 1 and " + numberofseats);
            return;
        }

        if (seats.get(id).isReserved) {
            System.out.println("This seat is already reserved, please enter another id:");
            int newId = inputreader.nextInt();
            this.makeReservation(newId, passenger);
        } else {
            seats.get(id).passenger = passenger;
            seats.get(id).isReserved = true;

            this.numberofreservedseats++;
            this.numberofunreservedseats--;

            System.out.println("Thanks for your reservation...");
        }
    }

    @Override
    public void deleteReservation(int id) {
        id = id - 1;

        if (id < 0 || id >= numberofseats) {
            System.out.println("Invalid ID. Please enter an ID between 1 and " + numberofseats);
            return;
        }

        if (!seats.get(id).isReserved) {
            System.out.println("This seat is not reserved, therefore you cannot cancel the reservation...");
        } else {
            seats.get(id).passenger = new Passenger(null, null, null, null);
            seats.get(id).isReserved = false;

            this.numberofreservedseats--;
            this.numberofunreservedseats++;

            System.out.println("You canceled the reservation with id " + (id + 1) + "\nLooking forward to seeing you again :)");
        }
    }

    public void searchReservation(int id) {
        boolean isFound = false;

        if (id < 1 || id > numberofseats) {
            System.out.println("Invalid ID. Please enter an ID between 1 and " + numberofseats);
            return;
        }

        for (Seat seat : seats) {
            if (seat.getId() == id && seat.isReserved) {
                System.out.println("---------------------------------");
                System.out.println("         Reservation");
                System.out.println("---------id = " + seat.getId());
                System.out.println("---------name = " + seat.passenger.getName());
                System.out.println("---------surname = " + seat.passenger.getSurname());
                System.out.println("---------mail = " + seat.passenger.getMail());
                System.out.println("---------phone = " + seat.passenger.getPhonenumber());
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("No reservation found, you can reserve this seat...");
        }
    }

    public void listOfReservation() {
        System.out.println("List of reservations\n");
        for (Seat seat : seats) {
            System.out.println("---------------------------------");
            System.out.println("---------id = " + seat.getId());
            System.out.println("---------name = " + seat.passenger.getName());
            System.out.println("---------surname = " + seat.passenger.getSurname());
            System.out.println("---------mail = " + seat.passenger.getMail());
            System.out.println("---------phone = " + seat.passenger.getPhonenumber());
        }
    }

    public void updateId(int id, Passenger passenger, int secId) {
        id = id - 1;
        secId = secId - 1;

        if (id < 0 || id >= numberofseats || secId < 0 || secId >= numberofseats) {
            System.out.println("Invalid ID. Please enter IDs between 1 and " + numberofseats);
            return;
        }

        if (!seats.get(id).isReserved) {
            System.out.println("This ID doesn't exist, therefore you cannot update your ID...");
        } else if (seats.get(secId).isReserved) {
            System.out.println("The new ID is already reserved, please choose another ID.");
        } else {
            Passenger existingPassenger = seats.get(id).passenger;
            seats.get(id).passenger = new Passenger(null, null, null, null);
            seats.get(id).isReserved = false;

            seats.get(secId).passenger = existingPassenger;
            seats.get(secId).isReserved = true;

            System.out.println("Your ID updated successfully " + passenger.getName());
        }
    }

    public void updateReservation(int id, Passenger passenger) {
        id = id - 1;

        if (id < 0 || id >= numberofseats) {
            System.out.println("Invalid ID. Please enter an ID between 1 and " + numberofseats);
            return;
        }

        if (seats.get(id).isReserved) {
            System.out.print("Welcome " + passenger.getName() + " Enter the New ID: ");
            int newId = inputreader.nextInt();
            updateId(id + 1, passenger, newId);  // Add 1 to id to match the method's expected input
        } else {
            System.out.println("This seat is not reserved, cannot update reservation.");
        }
    }
}
