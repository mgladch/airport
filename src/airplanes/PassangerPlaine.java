package airplanes;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.PrintStream;

public class PassangerPlaine extends Airplane {
    public int numSeats;

    public PassangerPlaine(String name, String model, int length_flight, int staff, int consumption, int num_seats) {
        super(name, model, length_flight, staff, consumption);
        this.numSeats = num_seats;
    }

    @Override
    public String toString() {
        ByteOutputStream stream = new ByteOutputStream();
        PrintStream printStream = new PrintStream(stream);
        printStream.printf("Name: %-10s Model: %-15s LengthFlight: %-5d Staff: %-3d Consumption: %-5d numSeats: %-6d Id: %-4d",
                name, model, lengthFlight, staff,consumption, numSeats, id);
        return stream.toString();
    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        if(numSeats >= 0)
            this.numSeats = numSeats;
        else
            this.numSeats = -1;
    }
}
