package airplanes;

import java.util.List;
import java.util.ArrayList;
public class Airplane {
    public String name = "Default";
    public String model = "Default";
    public int lengthFlight;
    public int staff;
    public int consumption;
    public static int curId = 1;
    public int id;

    public Airplane(String name, String model, int length_flight, int staff, int consumption) {
        this.name = name;
        this.model = model;
        this.lengthFlight = length_flight;
        this.staff = staff;
        this.consumption=consumption;
        id = curId++;
    }



    @Override
    public String toString() {
        return "Airplane{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", length_flight=" + lengthFlight +
                ", staff=" + staff +
                ", consumption=" + consumption +
                '}';
    }

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        if(consumption >= 0)
            this.consumption = consumption;
        else
            this.consumption = -1;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public int getLengthFlight() {
        return lengthFlight;
    }

    public int getStaff() {
        return staff;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setLengthFlight(int lengthFlight) {
        if(lengthFlight >= 0)
            this.lengthFlight = lengthFlight;
        else
            this.lengthFlight = -1;
    }

    public void setStaff(int staff) {
        if(staff >= 0)
            this.staff = staff;
        else
            this.staff = -1;
    }
    public static void printList(List<Airplane> plains){
        for (Airplane airplane: plains) {
            System.out.println(airplane);
        }
    }


}
