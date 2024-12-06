package dao.Impl;

import Models.Database;
import Models.Doctor;
import Models.Hospital;
import Models.Patient;
import dao.GenericServiceDao;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PatientDaoImpl implements GenericServiceDao<Patient> {
    @Override
    public String add(Long hospitalId, Patient patient) {

            try {
                Hospital hospital = Database.hospitals.stream().
                        filter(h -> h.getId() == hospitalId).
                        findFirst().
                        orElseThrow(() -> new RuntimeException("Айди туура эмес"));
                hospital.getPatients().add(patient);
                return "кошулду";
            }catch (Exception e){
                System.out.println(e.getMessage());
                return "Мындай Hospital жок";
            }
        }

    @Override
    public void removeById(Long id) {

        try {
            Hospital hospital = Database.hospitals.stream()
                    .filter(hospital1 -> hospital1.getPatients().stream()
                            .anyMatch(patient -> patient.getId() == (id)))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Айди туура эмес"));
            hospital.getPatients().removeIf(patient -> patient.getId() == id);
            System.out.println("Очурулду");
        }catch (Exception e){
            System.out.println(e.getMessage());}
    }

    @Override
    public String updateById(Long id, String newName) {
        try {
           Patient patient = Database.hospitals.stream()
                   .flatMap(hospital -> hospital.getPatients().stream())
                   .filter(patient1 -> patient1.getId()==id)
                   .findFirst()
                   .orElseThrow(()->new RuntimeException("Мындай patient жок"));
                   patient.setFirstName(newName);
            System.out.println("updated");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }return "";
    }

    public String addPatientsToHospital(Long id, List<Patient> patients) {
        try {
           Hospital hospital = Database.hospitals.stream()
                   .filter(hospital1 -> hospital1.getId()==id)
                   .findFirst()
                   .orElse(null);
           hospital.getPatients().addAll(patients);
               return "кошулду";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Мындай Hospital жок";
        }
//        try {
//            for (Hospital h : Database.hospitals) {
//                if (h.getId() == id) {
//                    h.getPatients().addAll(patients);
//                    return "added";
//                }
//            }
//            throw new Exception("Мындай айдидеги Hospital жок");
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        return null;
    }

    public Patient getPatientById(Long id) {
        try {


            return Database.hospitals.stream()
                    .flatMap(hospital -> hospital.getPatients().stream())
                    .filter(patient -> patient.getId() == id)
                    .findFirst()
                    .orElseThrow(()->new RuntimeException("мындай айдидеги patient жок"));
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
//
//    public Map<String, Hospital> getAllHospitalByAddress(String address) {
//        return database.getHospitals().stream()
//                .filter(h -> h.getAddress().equals(address))
//                .collect(Collectors.toMap(Hospital::getHospitalName, h -> h));
//    }

    public Map<Integer, Patient> getPatientByAge() {
        try {
            return Database.hospitals.stream()
                    .flatMap(hospital -> hospital.getPatients().stream())
                    .collect(Collectors.toMap(
                            Patient::getAge,
                            patient -> patient
                    ));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new HashMap<>();
        }
    }

    public List<Patient> sortPatientsByAge(String ascOrDesc) {
            if ("asc".equals(ascOrDesc)) {
                return Database.hospitals.stream()
                        .flatMap(hospital -> hospital.getPatients().stream())
                        .sorted(Comparator.comparing(Patient::getAge))
                        .collect(Collectors.toList());
            } else if ("desk".equals(ascOrDesc)) {
                return Database.hospitals.stream()
                        .flatMap(hospital -> hospital.getPatients().stream())
                        .sorted(Comparator.comparing(Patient::getAge).reversed())
                        .collect(Collectors.toList());
            }

        return null;
    }
}
