package GenericService;

import Models.Patient;
import dao.Impl.PatientDaoImpl;

public class PatienGenServiceImpl implements  GenericService<Patient>{
private PatientDaoImpl patientDao;

    public PatienGenServiceImpl(PatientDaoImpl patientDao) {
        this.patientDao = patientDao;
    }

    public PatienGenServiceImpl() {
    }

    public PatientDaoImpl getPatientDao() {
        return patientDao;
    }

    public void setPatientDao(PatientDaoImpl patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public String add(Long hospitalId, Patient patient) {
        return patientDao.add(hospitalId,patient);
    }

    @Override
    public void removeById(Long id) {
patientDao.removeById(id);
    }

    @Override
    public String updateById(Long id, String newName) {

        return patientDao.updateById(id,newName);
    }
}
