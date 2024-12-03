package Models;

public class GeneratedId {
    public static Long hospitalId= 0L;
    public  static Long hospitalId(){
        return ++hospitalId;
    }

    public static Long doctorId=0L;
    public static Long doctorId(){
        return ++doctorId;
    }

    public static Long departmentId=0L;
    public static Long departmentId(){
        return ++departmentId;
    }

    public static Long ddoctorId=0L;
    public static Long ddoctorId(){
        return ++ddoctorId;
    }
    public static Long patientId=0L;
    public static Long patientId(){
        return ++patientId;
    }

}
