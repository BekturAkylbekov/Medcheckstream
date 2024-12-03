package Service.Implements;

import Models.Patient;
import Service.PatientService;
import dao.Impl.PatientDaoImpl;

import java.util.List;
import java.util.Map;

public class PatientServiceImpl implements PatientService {
PatientDaoImpl patientDao;

    public PatientServiceImpl(PatientDaoImpl patientDao) {
        this.patientDao = patientDao;
    }

    public PatientDaoImpl getPatientDao() {
        return patientDao;
    }

    public void setPatientDao(PatientDaoImpl patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        return patientDao.addPatientsToHospital(id,patients);
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientDao.getPatientById(id);
    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {
        return patientDao.getPatientByAge();
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        return patientDao.sortPatientsByAge(ascOrDesc);
    }
}
