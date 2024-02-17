
package com.gilles.data;

import com.gilles.model.Student;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gilles
 */
public class StudentData {
    
    public static List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Gilles","Patrick","gilles@gmail.com"));
        students.add(new Student("Gilles","Patrick","gilles@gmail.com"));
        students.add(new Student("Gilles","Patrick","gilles@gmail.com"));
        
    return students;
    }
    
}
