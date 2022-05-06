package hiberlab.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_students")
public class Student implements java.io.Serializable {
    private long StudentNum;
    private Group group;
    private String surname;
    private String name;
    private String patronymic;
    private String city;
    private String address;
    private String phone;
    private String status;
    private Date statusDate;

    public Student() {

    }

    public Student(long StudentNum, Group group, String surname, String name, String patronymic, String city, String address, String phone) {
        this.StudentNum = StudentNum;
        this.group = group;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.city = city;
        this.address = address;
        this.phone = phone;
    }

    public Student(long StudentNum, Group group, String surname, String name, String patronymic, String city, String address, String phone, String status, Date statusDate) {
        this.StudentNum = StudentNum;
        this.group = group;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.city = city;
        this.address = address;
        this.phone = phone;
        this.status = status;
        this.statusDate = statusDate;
    }

    @Id
    @Column(name = "StudentNum", unique = true, nullable = false)
    public long getStudentNum() {
        return this.StudentNum;
    }

    public void setStudentNum(long studentNum) {
        this.StudentNum = studentNum;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GroupCipher", nullable = false)
    public Group getGroup() {
        return this.group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Column(name = "Surname", nullable = false, length = 30)
    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    @Column(name = "Name", nullable = false, length = 30)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Column(name = "Patronymic", nullable = false, length = 30)
    public String getPatronymic() {
        return this.patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }


    @Column(name = "City", nullable = false, length = 30)
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @Column(name = "Address", nullable = false, length = 80)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Column(name = "Phone", nullable = false, length = 30)
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Column(name = "Status", length = 50)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "StatusDate", length = 10)
    public Date getStatusDate() {
        return this.statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    @Override
    public String toString() {
        return "ФИО: " + this.getSurname()+ " " + this.getName() + " " + this.getPatronymic() +
                "\nНомер зачётки: " + this.getStudentNum() +
                "\nГруппа: " + this.getGroup().getName() +
                "\nДата обновления: " + this.getStatusDate() + "\n";
    }
}


