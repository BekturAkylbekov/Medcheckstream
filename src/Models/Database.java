package Models;

import java.util.ArrayList;
import java.util.List;

public class Database {
     public static List<Hospital> hospitals = new ArrayList<>();

        public List<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }
}
