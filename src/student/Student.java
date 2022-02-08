package student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Student {
    private String name;
    private double gpa;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.gpa, gpa) == 0 && name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gpa);
    }

    public List<Student> unique(List<Student> l1, List<Student> l2){
        for(Student s:l2){
            if(!l1.contains(s)){
                l1.add(s);
            }
        }
        return l1;
    }
}
