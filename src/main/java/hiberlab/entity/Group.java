package hiberlab.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "t_groups", uniqueConstraints = @UniqueConstraint(columnNames = "Name"))
public class Group implements java.io.Serializable {

    private Integer cipher;
    private String name;
    private Date createDate;
    private int planCode;
    private Specialty specialty;
    private String status;
    private Date statusDate;
    private List<Student> students;

    public Group() {
    }


    public Group(String name, Date createDate, int planCode) {
        this.name = name;
        this.createDate = createDate;
        this.planCode = planCode;
    }

    public Group(String name, Date createDate, int planCode, String status, Date statusDate, List<Student> students) {
        this.name = name;
        this.createDate = createDate;
        this.planCode = planCode;
        this.status = status;
        this.statusDate = statusDate;
        this.students = students;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "Cipher", unique = true, nullable = false)
    public Integer getCipher() {
        return this.cipher;
    }

    public void setCipher(Integer cipher) {
        this.cipher = cipher;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SpecialtyId", nullable = false)
    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    @Column(name = "Name", unique = true, nullable = false, length = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "CreateDate", nullable = false, length = 10)
    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    @Column(name = "PlanCode", nullable = false)
    public int getPlanCode() {
        return this.planCode;
    }

    public void setPlanCode(int planCode) {
        this.planCode = planCode;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}