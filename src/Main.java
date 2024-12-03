import GenericService.DepartementGenServiceImpl;
import GenericService.DoctorGenServiceImpl;
import GenericService.PatienGenServiceImpl;
import Service.Implements.DepartmentServiceImpl;
import Service.Implements.DoctorServiceImpl;
import Service.Implements.HospitalServiceImpl;
import Models.*;
import Service.Implements.PatientServiceImpl;
import dao.Impl.DepartmentDaoImpl;
import dao.Impl.DoctorDaoImpl;
import dao.Impl.HospitalDaoImpl;
import dao.Impl.PatientDaoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);

        HospitalDaoImpl hospitalDao = new HospitalDaoImpl(database);
        HospitalServiceImpl h = new HospitalServiceImpl(hospitalDao);

        DoctorDaoImpl doctorDao = new DoctorDaoImpl();
        DoctorGenServiceImpl g = new DoctorGenServiceImpl(doctorDao);

        DepartmentDaoImpl departmentDao = new DepartmentDaoImpl();
        DepartementGenServiceImpl d = new DepartementGenServiceImpl(departmentDao);

        PatientDaoImpl patientDao = new PatientDaoImpl();
        PatienGenServiceImpl p = new PatienGenServiceImpl(patientDao);

        DepartmentServiceImpl r=new DepartmentServiceImpl(departmentDao);
        DoctorServiceImpl doctorService= new DoctorServiceImpl(doctorDao);
        PatientServiceImpl patientService=new PatientServiceImpl(patientDao);
        while (true) {
            System.out.println("1. add Hospital");
            System.out.println("2. findHospitalById");
            System.out.println("3. getAllHospital");
            System.out.println("4. deleteHospitalById");
            System.out.println("5. getAllHospitalByAddress");
            System.out.println("6. add doctor");
            System.out.println("7. delete Doctor By Id");
            System.out.println("8. updated Doctor by id");
            System.out.println("9. add department");
            System.out.println("10. delete department");
            System.out.println("11. updated Department by id");
            System.out.println("12. add patient");
            System.out.println("13. delete patient by id");
            System.out.println("14. updated patient by id");
            System.out.println("15. getAllDepartmentByHospital");
            System.out.println("16. findDepartmentByName");
            System.out.println("17. findDoctorById");
            System.out.println("18. assignDoctorToDepartment");
            System.out.println("19. getAllDoctorsByHospitalId");
            System.out.println("20. getAllDoctorsByDepartmentId");
            System.out.println("21. addPatientsToHospital");
            System.out.println("22. getPatientById");
            System.out.println("23. getPatientByAge");
            System.out.println("24. sortPatientsByAge");
            System.out.println("25. getAllPatientFromHospital");
            int a = scanner.nextInt();
            switch (a) {
                case 1: {
                    System.out.println("Атын жазыныз");
                    String name = scanner1.nextLine();
                    System.out.println("адрессин жазыныз");
                    String adress = scanner1.nextLine();
                    System.out.println(h.addHospital(name, adress));
                    break;
                }
                case 2: {
                    System.out.println("Айдисин жазыныз");
                    long b = scanner2.nextLong();
                    System.out.println(h.findHospitalById(b));
                    break;
                }
                case 3: {
                    System.out.println(h.getAllHospital());
                    break;
                }
                case 4: {
                    System.out.println("Кайсыл hospitaldy очуруну калайсыз айдисин жазыныз");
                    long b = scanner2.nextLong();
                    System.out.println(h.deleteHospitalById(b));

                    break;
                }
                case 5: {
                    System.out.println("Адрес жазыныз");
                    String addres = scanner1.nextLine();
                    System.out.println(h.getAllHospitalByAddress(addres));
                    break;
                }
                case 6: {
                    System.out.println("Hospital айдисин жазыныз");
                    Long id = scanner2.nextLong();
                    System.out.println("Доктордун атын жазыныз");
                    String name = scanner1.nextLine();
                    System.out.println("Фамилиясын жазыныз");
                    String lastName = scanner1.nextLine();
                    System.out.println("Пол (MALE/FEMALE):");
                    String genderStr = scanner1.nextLine();
                    Gender gender = Gender.valueOf(genderStr.toUpperCase());
                    System.out.println("опытын жазыныз");
                    int experianceYear = scanner3.nextInt();
                    Doctor doctor = new Doctor(GeneratedId.doctorId(), name, lastName, gender, experianceYear);
                    System.out.println(g.add(id, doctor));
                    break;
                }
                case 7: {
                    System.out.println("Доктордун айдисин жазыныз");
                    Long id = scanner2.nextLong();
                    g.removeById(id);
                    break;
                }
                case 8: {
                    System.out.println("Доктордун айдисин жазыныз");
                    Long id = scanner2.nextLong();
                    System.out.println("жаны ат жазыныз");
                    String name = scanner1.nextLine();
                    System.out.println(g.updateById(id, name));
                    break;
                }
                case 9: {
                    System.out.println("Hospital айдисин жазыныз");
                    Long id = scanner2.nextLong();
                    System.out.println("department атын жазыныз");
                    String name = scanner1.nextLine();
                    List<Doctor> doctors = new ArrayList<>();
                    Department department = new Department(GeneratedId.departmentId(), name, doctors);
                    System.out.println(d.add(id, department));
                    break;
                }
                case 10: {
                    System.out.println("Департментин айдисин жазыныз");
                    Long id = scanner2.nextLong();
                    d.removeById(id);
                    break;
                }
                case 11: {
                    System.out.println("Департментин айдисин жазыныз");
                    Long id = scanner2.nextLong();
                    System.out.println("Жаны ат жазыныз");
                    String name = scanner1.nextLine();
                    d.updateById(id, name);
                    break;
                }
                case 12: {
                    System.out.println("Hospital айдисин жазыныз");
                    Long id = scanner2.nextLong();
                    System.out.println("patient атын жазыныз");
                    String name = scanner1.nextLine();
                    System.out.println("Фамилиясын жазыныз");
                    String lastName = scanner1.nextLine();
                    System.out.println("Жашыны жазыныз");
                    int age = scanner3.nextInt();
                    System.out.println("Пол (MALE/FEMALE):");
                    String genderStr = scanner1.nextLine();
                    Gender gender = Gender.valueOf(genderStr.toUpperCase());
                    Patient patient = new Patient(GeneratedId.patientId(), name, lastName, age, gender);
                    System.out.println(p.add(id, patient));
                    break;
                }
                case 13: {
                    System.out.println("Patient тин айдисин жазыныз");
                    Long id = scanner2.nextLong();
                    p.removeById(id);
               break; }
                case 14:{
                    System.out.println("Patient айдисин жазыныз");
                    Long id = scanner2.nextLong();
                    System.out.println("Жаны ат жазыныз");
                    String name = scanner1.nextLine();
                    System.out.println(p.updateById(id, name));
               break; }
                case 15:{
                    System.out.println("Hospital дын айдисин жазыныз");
                    Long id = scanner2.nextLong();
                    System.out.println(r.getAllDepartmentByHospital(id));
               break; }
                case 16:{
                    System.out.println("Department тин атын жазыныз");
                    String name = scanner1.nextLine();
                    System.out.println(r.findDepartmentByName(name));
                break;}
                case 17:{
                    System.out.println("Доктордун айдисин жазыныз");
                    Long id = scanner2.nextLong();
                    System.out.println(doctorService.findDoctorById(id));
             break;   }
                case 18:{
                    System.out.println("Введите ID департамента:");
                    Long idDepartment = scanner.nextLong();

                    System.out.println("Введите ID докторов через запятую:");
                    scanner.nextLine(); // Считываем остатки строки
                    String ids = scanner.nextLine();
                    List<Long> doctorIds = new ArrayList<>();
                    for (String id : ids.split(",")) {
                        doctorIds.add(Long.parseLong(id.trim()));
                    }
                    String result = doctorService.assignDoctorToDepartment(idDepartment, doctorIds);
                    System.out.println(result);
                break;}
                case 19:{
                    System.out.println("Hospital дын айдисин жазыныз");
                    Long id = scanner2.nextLong();
                    System.out.println(doctorService.getAllDoctorsByHospitalId(id));
              break;  }
                case 20:{
                    System.out.println("Department тин айдисин жазыныз");
                    Long id = scanner2.nextLong();
                    System.out.println(doctorService.getAllDoctorsByDepartmentId(id));
                break;}
                case 21:{
                    System.out.println("Hospital дын айдисин жазыныз");
                    Long id = scanner2.nextLong();
                    List <Patient> patients = new ArrayList<>();
                    System.out.println(patientService.addPatientsToHospital(id,patients));
                break;}
                case 22:{
                    System.out.println("Patient тин айдисин жазыныз");
                    Long id = scanner2.nextLong();
                    System.out.println(patientService.getPatientById(id));
                break;}
                case 23:{
                    System.out.println(patientService.getPatientByAge());
               break; }
                case 24:{
                    System.out.println("asc же desk");
                   String askordesk = scanner1.nextLine();
                    System.out.println(patientService.sortPatientsByAge(askordesk));
                break;}
                case 25:{
                    System.out.println("Hospital дын айдисин жазыныз");
                    Long id = scanner2.nextLong();
                    System.out.println(h.getAllPatientFromHospital(id));
                }
            }
        }
    }

}