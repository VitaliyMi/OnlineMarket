package application.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "dishes")
public class Dish implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id")
    private long id;

    @Column(name="dishName")
    private String dishName;

    @Column(name = "price")
    private float price;

    private String url;

    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();



    public Dish(String dishName) {
        this.dishName = dishName;
    }

    public Dish()
    {
        //explicit public constructor;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return dishName;
    }

    public void setName(String name) {
        this.dishName = name;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dish)) return false;

        Dish dish = (Dish) o;

        if (id == dish.id&&
                Float.compare(dish.price, price) == 0&&
                    dishName.equals(dish.dishName)&&
                            url.equals(dish.url))
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return this.getUrl().length()+(int)price*3;
    }

}
