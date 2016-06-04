package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MSI on 30.04.2016.
 */

@Entity
@Table(name = "dishes")
public class Dish implements Serializable{


    private long id;

    public Dish(String dishName) {
        this.dishName = dishName;
    }

    public Dish()
    {
     //   id=180;
    }

    private String dishName;

    private float price;

    private String url;

    private List<Transaction> transactions = new ArrayList<Transaction>(0);

    //   private float rating;
 //   @ManyToMany(mappedBy = "dishes")
 //@OneToMany(fetch = FetchType.LAZY, mappedBy = "dish", cascade = CascadeType.ALL)



    @Id
    @GeneratedValue
    @Column(name = "dish_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Column(name="dishName")
    public String getName() {
        return dishName;
    }

    public void setName(String name) {
        this.dishName = name;
    }

    @Column(name = "pric")
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL)
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

 /*   public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }*/

    @Override
    public String toString() {
        return "["+ this.dishName+"\t"+this.getPrice()+"]";
    }
}
