package Service.Implements;

import Models.Database;
import Models.Department;
import Models.Hospital;
import Service.DepartmentService;
import dao.Impl.DepartmentDaoImpl;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    DepartmentDaoImpl departmentDao;

    public DepartmentServiceImpl(DepartmentDaoImpl departmentDao) {
        this.departmentDao = departmentDao;
    }

    public DepartmentDaoImpl getDepartmentDao() {
        return departmentDao;
    }

    public void setDepartmentDao(DepartmentDaoImpl departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        return departmentDao.getAllDepartmentByHospital(id);
    }

    @Override
    public Department findDepartmentByName(String name) {
        return departmentDao.findDepartmentByName(name);
    }
}
