package hiberlab.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "t_specialties", uniqueConstraints = @UniqueConstraint(columnNames = "Name"))
public class Specialty implements java.io.Serializable {
    private long id;
    private String code;
    private String name;
    private List<Group> groups;
    private Date statusDate;

    public Specialty() {
    }

    public Specialty(String code, String name, Date statusDate) {
        this.code = code;
        this.name = name;
        this.statusDate = statusDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "StatusDate")
    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "Code", unique = true, nullable = false, length = 50)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "Name", unique = true, nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "specialty")
    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Название: " + this.name +
                "\nКод: " + this.code +
                "\nДата обновления: " + this.statusDate;
    }
}
