import java.util.ArrayList;
import java.util.List;

public class Students {
    public static List<Student> studentList = new ArrayList<>();

    // zakladajac ze w przykladowym kodzie nie ma logiki dodawania studentow do listy, studenci
    // beda dodawani automatycznie przy wywolaniu konstruktora klasy Student
    public static void addStudent(Student s){
        studentList.add(s);
    }

    public static void promoteAllStudents(){
        for (Student s : studentList){
            s.promoteToNewSemester();
        }
    }
    public static void displayInfoAboutAllStudents(){
        for (Student s : studentList){
            System.out.println(s); // -> nadpisany toString
        }
    }

}
