package dao.Impl;

import Models.Database;
import Models.Department;
import Models.Doctor;
import Models.Hospital;
import dao.GenericServiceDao;

import java.util.ArrayList;
import java.util.List;

public class DoctorDaoImpl implements GenericServiceDao<Doctor> {


    @Override
    public String add(Long hospitalId, Doctor doctor) {
        try {
            for (Hospital h : Database.hospitals) {
                if (h.getId() == hospitalId) {
                    h.getDoctors().add(doctor);
                    return "Доктор кошулду";
                }
            }
            throw new Exception("Мындай айдидеги Hospital жок");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    @Override
    public void removeById(Long id) {
boolean isremoved=false;
try {
            for (Hospital h : Database.hospitals) {
                for (Doctor d : h.getDoctors()) {
                    if (d.getId() == id) {
                        h.getDoctors().remove(d);
                        System.out.println("Очурулду");
                        isremoved=true;
                        break;
                    }
                }
            }   if (!isremoved) {
        throw new Exception("Мындай айдидеги доктор жок");
    }}catch (Exception e){
    System.out.println(e.getMessage());
    }

    }

    @Override
    public String updateById(Long id, String newName) {
        try {
            boolean u =false;
            for (Hospital h : Database.hospitals) {
                for (Doctor d : h.getDoctors()) {
                    if (d.getId() == id) {
                        d.setFirstName(newName);
                        u=true;
                        return "updated";
                    }
                }
            }
            if (!u){
                throw  new Exception("Мындай айдидеги доктор жок");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }return "";
    }

    public Doctor findDoctorById(Long id) {
        try {
            for (Hospital h : Database.hospitals) {
                for (Doctor d : h.getDoctors()) {
                    if (d.getId() == id) {
                        return d;
                    }
                }
            }
            throw new Exception("Мындай айдидеги доктор жок");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        for (Hospital hospital : Database.hospitals) {
            // Перебираем департаменты в больнице
            for (Department department : hospital.getDepartnents()) {
                // Проверяем, совпадает ли ID департамента
                if (department.getId()==(departmentId)) {
                    // Создаем копию списка докторов больницы, чтобы избежать ошибок модификации
                    List<Doctor> hospitalDoctorsCopy = new ArrayList<>(hospital.getDoctors());

                    // Перебираем докторов из копии
                    for (Doctor doctor : hospitalDoctorsCopy) {
                        // Проверяем, содержится ли ID доктора в списке
                        if (doctorsId.contains(doctor.getId())) {
                            // Добавляем доктора в департамент
                            department.getDoctors().add(doctor);
                            // Удаляем доктора из списка больницы
                            hospital.getDoctors().remove(doctor);
                        }
                    }
                    return "Доктора успешно назначены в департамент!";
                }
            }
        }
        return "Департамент с ID " + departmentId + " не найден!";
    }

    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        try {
            for (Hospital h : Database.hospitals) {
                if (h.getId() == id) {
                    return h.getDoctors();
                }

            }
            throw new Exception("Мындай айдидеги Hospital жок");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        return null;
    }

    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        try {
            for (Hospital h : Database.hospitals) {
                for (Department d:h.getDepartnents()) {
                    if (d.getId() == id) {
                        return d.getDoctors();
                    }
                }


            }
            throw new Exception("Мындай айдидеги Hospital жок");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        return null;

    }
}