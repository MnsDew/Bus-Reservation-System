package examples;

public interface Reservation {
    void makeReservation(int id, Passenger passenger);
    void deleteReservation(int id);
    void updateReservation(int id, Passenger passenger);
    void searchReservation(int id);
}
