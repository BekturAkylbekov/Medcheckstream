package GenericService;

import Models.Doctor;
import dao.Impl.DoctorDaoImpl;

public class DoctorGenServiceImpl implements GenericService<Doctor> {
   private DoctorDaoImpl doctorDao ;

    public DoctorGenServiceImpl(DoctorDaoImpl doctorDao) {
        this.doctorDao = doctorDao;
    }

    public DoctorDaoImpl getDoctorDao() {
        return doctorDao;
    }

    public void setDoctorDao(DoctorDaoImpl doctorDao) {
        this.doctorDao = doctorDao;
    }

    @Override
    public String add(Long hospitalId, Doctor doctor) {

        return doctorDao.add(hospitalId,doctor) ;
    }

    @Override
    public void removeById(Long id) {
        doctorDao.removeById(id);
    }

    @Override
    public String updateById(Long id, String newName) {

        return doctorDao.updateById(id,newName);
    }
}
