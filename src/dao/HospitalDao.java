package dao;

import Models.Hospital;
import Models.Patient;

import java.util.List;
import java.util.Map;

public interface HospitalDao {
    String addHospital(String name, String adress);
    Hospital findHospitalById(Long id);
    List<Hospital> getAllHospital();
    String deleteHospitalById(Long id);
    Map<String,Hospital>
    getAllHospitalByAddress(String address);
    List<Patient> getAllPatientFromHospital(Long id);

}
