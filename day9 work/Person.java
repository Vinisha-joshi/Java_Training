package day7;

import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="person_records")
public class Person {
    @Id
    @GeneratedValue(generator = "custom-generator" )
    @GenericGenerator(strategy = "day8.CustomIdGenerator", name = "custom-generator")
    private int id;
    @Column(name = "Name",columnDefinition = "not null",length = 200)//nullable false->not null
    private String name;
    @Column(name = "IsHired",updatable = false)
    private boolean isHired;

    public Person(String name, boolean isHired) {
        this.name = name;
        this.isHired = isHired;
    }
    Person()
    {

    }
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

    public boolean isHired() {
        return isHired;
    }

    public void setHired(boolean hired) {
        isHired = hired;
    }


}
