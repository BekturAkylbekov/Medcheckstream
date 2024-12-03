package GenericService;

import Models.Department;
import dao.Impl.DepartmentDaoImpl;

public class DepartementGenServiceImpl implements GenericService<Department>{
   private DepartmentDaoImpl departmentDao ;

    public DepartementGenServiceImpl(DepartmentDaoImpl departmentDao) {
        this.departmentDao = departmentDao;
    }

    public DepartmentDaoImpl getDepartmentDao() {
        return departmentDao;
    }

    public void setDepartmentDao(DepartmentDaoImpl departmentDao) {
        this.departmentDao = departmentDao;
    }

    public DepartementGenServiceImpl() {
    }

    @Override
    public String add(Long hospitalId, Department department) {

        return departmentDao.add(hospitalId,department);
    }

    @Override
    public void removeById(Long id) {
        departmentDao.removeById(id);

    }

    @Override
    public String updateById(Long id, String newName) {

        return departmentDao.updateById(id,newName);
    }
}
