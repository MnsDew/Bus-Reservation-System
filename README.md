# Bus Reservation System by MNS70 OR MN$

## Description

This project is a simple bus reservation system implemented in Java. It allows users to make, update, and cancel reservations for bus seats. The system also provides functionalities to search for reservations and list all reservations.

## Features

- **Reservation Management**: Users can make a reservation for a seat by providing their details.
- **Cancellation**: Users can cancel an existing reservation, freeing up the seat for others.
- **Search**: Users can search for reservations by seat ID to view the reservation details.
- **Update Reservation**: Users can update their reservation by changing the seat ID.
- **Admin Functionality**: Provides an option to list all reservations for administrative purposes.
- **Persistence**: Uses file serialization to save and load bus reservation data between sessions.

## Usage

- **Make a Reservation**: Choose an available seat ID and provide passenger details to make a reservation.
- **Cancel a Reservation**: Enter the seat ID of the reservation you want to cancel.
- **Search for a Reservation**: Enter a seat ID to view reservation details.
- **Update Reservation**: Enter the current seat ID and new seat ID to update a reservation.
- **List Reservations**: Enter the admin password to view a list of all reservations.

## How to Run

1. Clone the repository:
    ```sh
    git clone https://github.com/MnsDew/BusReservationSystem.git
    ```
2. Navigate to the project directory:
    ```sh
    cd BusReservationSystem
    ```
3. Compile the Java files:
    ```sh
    javac -d bin src/examples/*.java
    ```
4. Run the application:
    ```sh
    java -cp bin examples.App1
    ```

## Note

- Ensure Java is installed on your system.
- The project uses file serialization to store bus reservation data in `bus_data.txt`.

## Contributions

Feel free to fork the repository and contribute to the project by submitting pull requests.

## License

This project is licensed under the MIT License. See the LICENSE file for more details.

# Bus Reservation System by MNS70 OR MN$
