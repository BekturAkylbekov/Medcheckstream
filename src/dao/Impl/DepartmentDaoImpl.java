package dao.Impl;

import GenericService.GenericService;
import Models.Database;
import Models.Department;
import Models.Doctor;
import Models.Hospital;
import dao.GenericServiceDao;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImpl implements GenericServiceDao<Department> {
    @Override
    public String add(Long hospitalId, Department department) {
        boolean is = false;
        try {
            for (Hospital h : Database.hospitals) {
                if (h.getId() == hospitalId) {
                    h.getDepartnents().add(department);
                    is = true;
                    return "Кошулду";
                }
                }
            if (!is) {
                throw new Exception("Мындай айдидеги департмент жок");
            }
            }

         catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void removeById(Long id) {
        boolean isRemoved = false;

        try {
            for (Hospital h : Database.hospitals) {
                for (Department d : h.getDepartnents()) {
                    if (d.getId() == id) {
                        h.getDepartnents().remove(d);
                        System.out.println("Очурулду");
                        isRemoved = true;
                        break;

                    }
                }
            }
            if (!isRemoved) {
                throw new Exception("Мындай айдидеги департмент жок");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String updateById(Long id, String newName) {


try{
    boolean s = false;
        for (Hospital h:Database.hospitals) {
            for (Department d : h.getDepartnents()) {
                if (d.getId() == id) {
                    d.setDepartmenName(newName);
                    s = true;
                    return "updated ";
                }
            }
        }if (!s){
                throw new Exception("Мындай айдидеги департмент жок");
            }

       }catch (Exception e){
    System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Department> getAllDepartmentByHospital(Long id) {
        try{
            for (Hospital h: Database.hospitals) {
                if (h.getId()==id){
                    return h.getDepartnents();
                }
            }
          throw  new Exception("Мындай айдидеги Hospital жок");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Department findDepartmentByName(String name) {
        try {
            for (Hospital h : Database.hospitals) {
                for (Department d : h.getDepartnents()) {
                    if (d.getDepartmenName().equals(name)) {
                        return d;
                    }

                }
            }
            throw new Exception("Мындай department жок");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
