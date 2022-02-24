package day8;
import java.util.List;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerators;


@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @GenericGenerators(="CustomIdGenerator")
    @Column(name="student_id")
    private int id;

    private String name;

    //private List<Integer> marks;

    private int rollno;
    private String university;
//    public String getMarks() {
//        String marks1=marks.toString();
//        return marks1;
//    }

//    public void setMarks(List<Integer> marks) {
//        this.marks = marks;
//    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    Student() {

    }
    public Student(String name,int rollno,String university){
        this.name=name;
        this.rollno=rollno;
        this.university=university;

    }
    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }



}
