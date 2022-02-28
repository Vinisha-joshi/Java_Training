package Hibernate_Assignment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Product_Details")
public class Product {
    /*
        Q7 Make a class Product with fields (id, name, price) where id is generated through your
           custom ID generator class.The ids should be generated sequentially starting from 1
     */
    @Id
    @GeneratedValue(generator = "custom-generator" )
    @GenericGenerator(strategy = "Hibernate_Assignment.CustomidGenerator", name = "custom-generator")
    private int id;
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public Product(){

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }




}
