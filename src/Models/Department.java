package Models;
//        * Department (Long id, String departmentName, List<Doctor> doctors),

import java.util.List;

public class Department {
    private long id;
    private String departmenName;
    List<Doctor> doctors;

    public Department(long id, String departmenName, List<Doctor> doctors) {
        this.id = id;
        this.departmenName = departmenName;
        this.doctors = doctors;
    }

    public Department() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartmenName() {
        return departmenName;
    }

    public void setDepartmenName(String departmenName) {
        this.departmenName = departmenName;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        return "\nDepartment{" +
                "id=" + id +
                ", departmenName='" + departmenName + '\'' +
                ", doctors=" + doctors +
                '}';
    }
}
