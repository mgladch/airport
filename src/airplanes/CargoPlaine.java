package airplanes;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.PrintStream;

public class CargoPlaine extends Airplane {
    public  int capacity;

    public CargoPlaine(String name, String model, int length_flight, int staff, int consumption, int capacity) {
        super(name, model, length_flight, staff, consumption);
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        ByteOutputStream stream = new ByteOutputStream();
        PrintStream printStream = new PrintStream(stream);
        printStream.printf("Name: %-10s Model: %-15s LengthFlight: %-5d Staff: %-3d Consumption: %-5d Capacity: %-6d Id: %-4d",
                name, model, lengthFlight, staff,consumption, capacity, id);
        return stream.toString();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if(capacity > 0)
            this.capacity = capacity;
        else this.capacity = -1;
    }

}
