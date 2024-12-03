package Models;
//* Hospital (Long id, String hospitalName, String address, List<Department> departments, List<Doctor> doctors, List<Patient> patients),

import java.util.List;

public class Hospital {
     private long id;
     private String hospitalName,address;
     List<Department> departnents;
     List<Doctor> doctors;
     List<Patient> patients;

    public Hospital(long id, String hospitalName, String address, List<Department> departnents, List<Doctor> doctors, List<Patient> patients) {
        this.id = id;
        this.hospitalName = hospitalName;
        this.address = address;
        this.departnents = departnents;
        this.doctors = doctors;
        this.patients = patients;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Department> getDepartnents() {
        return departnents;
    }

    public void setDepartnents(List<Department> departnents) {
        this.departnents = departnents;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "\nHospital{" +
                "id=" + id +
                ", hospitalName='" + hospitalName + '\'' +
                ", address='" + address + '\'' +
                ", departnents=" + departnents +
                ", doctors=" + doctors +
                ", patients=" + patients +
                '}';
    }
}
