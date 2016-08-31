package application.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MSI on 30.04.2016.
 */

@Entity
@Table(name = "dishes")
public class Dish implements Serializable{

    private long id;

    private String dishName;

    private float price;

    private String url;

    public Dish(String dishName) {
        this.dishName = dishName;
    }

    private List<Transaction> transactions = new ArrayList<>();


    public Dish()
    {
        //explicit public constructor;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "price")
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

    @Override
    public String toString() {
        return "["+ this.dishName+"\t"+this.getPrice()+"<img src="+this.getUrl()+">]";
    }


    @Override
    public boolean equals(Object obj) {
        if(obj!=null && obj instanceof Dish) {
            Dish d = (Dish) obj;
            if (this.getName().equals(d.getName()))
                if (this.getUrl().equals(d.getUrl()))
                    if(BigDecimal.valueOf(this.getPrice())==BigDecimal.valueOf(d.getPrice()))
                        return true;

        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getUrl().length()+(int)price*3;
    }

}
