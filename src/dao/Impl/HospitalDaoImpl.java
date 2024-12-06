package dao.Impl;

import Models.*;
import dao.HospitalDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HospitalDaoImpl implements HospitalDao {
   private Database database;

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public HospitalDaoImpl() {
    }

    public HospitalDaoImpl(Database database) {
        this.database = database;
    }

    @Override
    public String addHospital(String name, String adress) {
        List<Department> departments = new ArrayList<>();
        List<Doctor>doctors = new ArrayList<>();
        List<Patient> patients= new ArrayList<>();
        Hospital hospital = new Hospital(GeneratedId.hospitalId(),name,adress,departments,doctors,patients);
        database.getHospitals().add(hospital);
        return "Успешно добавлено";
    }

    @Override
    public Hospital findHospitalById(Long id) {
        return database.getHospitals().stream()
                .filter(h -> h.getId()==(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Айди туура эмес"));
    }
    @Override
    public List<Hospital> getAllHospital() {
        return database.getHospitals();
    }

    @Override
    public String deleteHospitalById(Long id) {
        Hospital hospitalToDelete = database.getHospitals().stream()
                .filter(h -> h.getId()==(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Айди туура эмес"));

        if (hospitalToDelete != null) {
            database.getHospitals().remove(hospitalToDelete);
            return hospitalToDelete.getHospitalName() + " деген hospital өчүрүлдү";
        }
        return "Мындай Hospital жок";
    }
    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        return database.getHospitals().stream()
                .filter(h -> h.getAddress().equals(address))
                .collect(Collectors.toMap(Hospital::getHospitalName, h -> h));
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        return database.getHospitals().stream()
                .filter(h -> h.getId()==(id))
                .map(Hospital::getPatients)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Айди туура эмес"));
    }
}
