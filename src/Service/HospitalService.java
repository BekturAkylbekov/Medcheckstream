package Service;

import Models.Hospital;
import Models.Patient;

import java.util.List;
import java.util.Map;

public interface HospitalService {
    String addHospital(String name, String adress);
    Hospital findHospitalById(Long id);
    List<Hospital> getAllHospital();
    List<Patient> getAllPatientFromHospital(Long id);

    String deleteHospitalById(Long id);
    Map<String,Hospital>
    getAllHospitalByAddress(String address);
}
