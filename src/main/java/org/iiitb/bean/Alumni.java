package org.iiitb.bean;


import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="ID")
public class Alumni extends Student{

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer alum_id;

    @Column
    private Integer passingYear;

//    @OneToOne()
//    private Student student;

    public Alumni(){}

    public Alumni(Integer passingYear) {
        this.passingYear = passingYear;
//        this.student = student;
    }

    public Integer getPassingYear() {
        return passingYear;
    }

    public void setPassingYear(Integer passingYear) {
        this.passingYear = passingYear;
    }

//    public Integer getId() {
//        return alum_id;
//    }

//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }

//    public void setId(Integer id) {
//        this.alum_id = id;
//    }

}
