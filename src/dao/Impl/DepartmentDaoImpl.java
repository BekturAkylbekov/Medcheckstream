package dao.Impl;

import GenericService.GenericService;
import Models.Database;
import Models.Department;
import Models.Doctor;
import Models.Hospital;
import dao.GenericServiceDao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DepartmentDaoImpl implements GenericServiceDao<Department> {
    @Override
    public String add(Long hospitalId, Department department) {
    Hospital hospital =Database.hospitals.stream().
                    filter(h -> h.getId()==hospitalId).
                    findFirst().
                orElseThrow(() -> new RuntimeException("Айди туура эмес"));
    hospital.getDepartnents().add(department);
    return "кошулду";
    }

    @Override
    public void removeById(Long id) {

      Hospital hospital=Database.hospitals.stream()
              .filter(h->h.getDepartnents()
                      .stream().anyMatch(d->d.getId()==(id))).findFirst()
                 .orElseThrow(() -> new RuntimeException("Айди туура эмес"));
hospital.getDepartnents().removeIf(d->d.getId()==(id));
        System.out.println("очурулду");
//        boolean isRemoved = false;
//
//        try {
//            for (Hospital h : Database.hospitals) {
//                for (Department d : h.getDepartnents()) {
//                    if (d.getId() == id) {
//                        h.getDepartnents().remove(d);
//                        System.out.println("Очурулду");
//                        break;
//
//                    }
//                }
//            }
//            if (!isRemoved) {
//                throw new Exception("Мындай айдидеги департмент жок");
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
    }

    @Override
    public String updateById(Long id, String newName) {
Department department =Database.hospitals.stream()
        .flatMap(d->d.getDepartnents().stream().filter(de->de.getId()==(id)))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Айди туура эмес"));
department.setDepartmenName(newName);
        return "updated";
//try{
//    boolean s = false;
//        for (Hospital h:Database.hospitals) {
//            for (Department d : h.getDepartnents()) {
//                if (d.getId() == id) {
//                    d.setDepartmenName(newName);
//                    s = true;
//                    return "updated ";
//                }
//            }
//        }if (!s){
//                throw new Exception("Мындай айдидеги департмент жок");
//            }
//
//       }catch (Exception e){
//    System.out.println(e.getMessage());
//        }
//        return null;
    }

    public List<Department> getAllDepartmentByHospital(Long id) {
        Database.hospitals.stream()
                .filter(h->h.getId()==id)
                .findFirst().orElse(null);
//        try{
//            for (Hospital h: Database.hospitals) {
//                if (h.getId()==id){
//                    return h.getDepartnents();
//                }
//            }
//          throw  new Exception("Мындай айдидеги Hospital жок");
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
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
