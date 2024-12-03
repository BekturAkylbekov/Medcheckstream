package Service.Implements;

import Models.*;
import Service.HospitalService;
import dao.HospitalDao;
import dao.Impl.HospitalDaoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HospitalServiceImpl implements HospitalService {


    private HospitalDaoImpl hospitalDao;

    public HospitalServiceImpl(HospitalDaoImpl hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    public HospitalDaoImpl getHospitalDao() {
        return hospitalDao;
    }

    public void setHospitalDao(HospitalDaoImpl hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    @Override
    public String addHospital(String name, String adress) {

        return hospitalDao.addHospital(name, adress);
    }

    @Override
    public Hospital findHospitalById(Long id) {

        return hospitalDao.findHospitalById(id);
    }

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalDao.getAllHospital();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        return hospitalDao.getAllPatientFromHospital(id);
    }

    @Override
    public String deleteHospitalById(Long id) {
        return hospitalDao.deleteHospitalById(id);
    }


    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {

        return hospitalDao.getAllHospitalByAddress(address);
    }
}