package dao.Impl;

import GenericService.GenericService;
import Models.Database;
import Models.Department;
import Models.Doctor;
import Models.Hospital;
import dao.GenericServiceDao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DepartmentDaoImpl implements GenericServiceDao<Department> {
    @Override
    public String add(Long hospitalId, Department department) {
        try {


            Hospital hospital = Database.hospitals.stream().
                    filter(h -> h.getId() == hospitalId).
                    findFirst().
                    orElseThrow(() -> new RuntimeException("Айди туура эмес"));
            hospital.getDepartnents().add(department);
            return "кошулду";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Мындай hospital жок";
        }
    }

    @Override
    public void removeById(Long id) {
        try {

            Hospital hospital = Database.hospitals.stream()
                    .filter(h -> h.getDepartnents()
                            .stream()
                            .anyMatch(d -> d.getId() == (id)))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Айди туура эмес"));
            hospital.getDepartnents().removeIf(d -> d.getId() == (id));
            System.out.println("очурулду");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
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
        Department department = Database.hospitals.stream()
                .flatMap(d -> d.getDepartnents().stream().filter(de -> de.getId() == (id)))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Айди туура эмес"));
        department.setDepartmenName(newName);
        return "updated";
    }

    public List<Department> getAllDepartmentByHospital(Long id) {
        return Database.hospitals.stream()
                .filter(hospital -> hospital.getId() == id)
                .findFirst()
                .map(hospital -> hospital.getDepartnents())
                .orElseThrow(() -> new RuntimeException("Айди туура эмес"));

    }

    public Department findDepartmentByName(String name) {
        try {
            return Database.hospitals.stream()
                    .flatMap(hospital -> hospital.getDepartnents().stream())
                    .filter(department -> department.getDepartmenName().equals(name))
                    .findFirst()
                    .orElseThrow(()->new RuntimeException("Мындай name меенен департмент жок"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
