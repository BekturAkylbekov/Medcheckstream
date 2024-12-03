package dao.Impl;

import Models.Database;
import Models.Doctor;
import Models.Hospital;
import Models.Patient;
import dao.GenericServiceDao;

import java.util.*;

public class PatientDaoImpl implements GenericServiceDao<Patient> {
    @Override
    public String add(Long hospitalId, Patient patient) {

            try {
                for (Hospital h : Database.hospitals) {
                    if (h.getId() == hospitalId) {
                        h.getPatients().add(patient);
                        return "Patient кошулду";
                    }

                    }
                throw new Exception("Мындай айдидеги Hospital жок");

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return "";
        }

    @Override
    public void removeById(Long id) {
        boolean isremoved=false;
        try {
            for (Hospital h : Database.hospitals) {
                for (Patient d : h.getPatients()) {
                    if (d.getId() == id) {
                        h.getPatients().remove(d);
                        System.out.println("Очурулду");
                        isremoved=true;
                        break;
                    }
                }
            }   if (!isremoved) {
                throw new Exception("Мындай айдидеги patient жок");
            }}catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


    @Override
    public String updateById(Long id, String newName) {
        try {
            boolean u =false;
            for (Hospital h : Database.hospitals) {
                for (Patient d : h.getPatients()) {
                    if (d.getId() == id) {
                        d.setFirstName(newName);
                        u=true;
                        return "updated";
                    }
                }
            }
            if (!u){
                throw  new Exception("Мындай айдидеги patient жок");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }return "";
    }

    public String addPatientsToHospital(Long id, List<Patient> patients) {
        try {
            for (Hospital h : Database.hospitals) {
                if (h.getId() == id) {
                    h.getPatients().addAll(patients);
                    return "added";
                }
            }
            throw new Exception("Мындай айдидеги Hospital жок");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Patient getPatientById(Long id) {
        try {
            for (Hospital h : Database.hospitals) {
                for (Patient p : h.getPatients()) {
                    if (p.getId() == id) {
                        return p;
                    }
                }
            }
            throw new Exception("Мындай айдидеги Patient жок");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Map<Integer, Patient> getPatientByAge() {
        Map<Integer, Patient> result = new HashMap<>();
        try {
            for (Hospital h : Database.hospitals) {
                for (Patient p : h.getPatients()) {
                    result.put(p.getAge(), p);
                }

            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        List<Patient> allPatients = new ArrayList<>();
        for (Hospital h : Database.hospitals) {
            allPatients.addAll(h.getPatients());
            if ("asc".equals(ascOrDesc)) {
                Collections.sort(allPatients, Patient.sortByageAsk);
            } else if ("desk".equals(ascOrDesc)) {
                Collections.sort(allPatients, Patient.sortByagedDesk);
            }
        }
        return allPatients;
    }
}
