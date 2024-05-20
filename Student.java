import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Student {

    public static int studentCounter = 0;
    public Map<String, Integer> grades = new HashMap<>();
    public String index;
    public String name;
    public String surname;
    public String email;
    public String address;
    public String phoneNumber;
    public Date birthDate;
    public String status;
    public StudyProgramme programme;
    public int currentSemester;

    public Student(String name, String surname, String email, String address, String phoneNumber, Date birthDate) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.index = setIndex();
        this.status = "candidate";
        Students.addStudent(this);
    }


    public String setIndex(){
        studentCounter++;
        return "s"  + studentCounter;
    }

    public void addGrade(int grade, String subject){
        grades.put(subject, grade);
    }
    public void enrollStudent(StudyProgramme programme){
        this.programme = programme;
        this.status = "student";
        this.currentSemester = 1;
    }
    public void promoteToNewSemester(){
        if (this.status.equals("student")) {
            if (currentSemester < programme.maxSemesters && countItn() <= programme.maxItn) {
                this.currentSemester++;
                if (currentSemester == programme.maxSemesters) {
                    this.status = "graduate";
                }
            }
        }
    }
    public int countItn(){
        int itnCount = 0;
        for (int grade : grades.values()) {
            if (grade < 3) {
                itnCount++;
            }
        }
        return itnCount;
    }

    @Override
    public String toString() {
        return "Student{" +
                "grades=" + grades +
                ", index='" + index + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthDate=" + birthDate +
                ", status='" + status + '\'' +
                ", programme=" + programme +
                ", currentSemester=" + currentSemester +
                '}';
    }
}
