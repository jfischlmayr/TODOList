package at.thejano.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
        @NamedQuery(name = "TODO.findAll", query = "SELECT t FROM TODO t")
})

@Entity
public class TODO {
    @Id
    private long id;
    private String name;
    private String dueDate;
    private String person;
    private String status;

    public TODO() { }

    public TODO(long id, String name, String dueDate, String person) {
        this.id = id;
        this.name = name;
        this.dueDate = dueDate;
        this.person = person;
    }

    public TODO(long id, String name, String dueDate, String person, String status) {
        this.id = id;
        this.name = name;
        this.dueDate = dueDate;
        this.person = person;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
