package dao.Impl;

import Models.*;
import dao.HospitalDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        try {
            for (Hospital h : database.getHospitals()) {
                if (h.getId() == id) {
                    return h;
                }
            }

            throw new Exception("Айди туура эмес");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Hospital> getAllHospital() {
        return database.getHospitals();
    }

    @Override
    public String deleteHospitalById(Long id) {
        try{
            for (Hospital g: database.getHospitals()){
                if (g.getId()==(id)){
                    database.getHospitals().remove(g);
                    return g.getHospitalName() + " деген hospital очурулду ";
                }
            }
            return "Мындай Hospital жок";
        } catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        Map<String, Hospital> result=new HashMap<>();

        try{

            for (Hospital hospital:database.getHospitals()) {
            if (hospital.getAddress().equals(address)){
                result.put(hospital.getHospitalName(),hospital);

            }
            }
        }

        catch (Exception e) {
            System.out.println(e.getMessage());
        }
            return result;
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        for (Hospital h:Database.hospitals) {
            if (h.getId()==id){
                return h.getPatients();
            }
        }
        return null;
    }
}
