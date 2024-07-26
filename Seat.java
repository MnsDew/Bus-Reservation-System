package examples;

import java.io.Serializable;

public class Seat implements Serializable {

    private static final long serialVersionUID = 1L;
    int id;
    Passenger passenger = new Passenger(null, null, null, null);
    boolean isReserved = false;

    Seat(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Seat [id=" + id + ", passenger=" + passenger + ", isReserved=" + isReserved + "]";
    }
}
