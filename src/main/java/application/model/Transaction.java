package application.model;

/**
 * Created by MSI on 21.08.2016.
 */

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "transactions")
public class Transaction implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "transaction_id")
    private int id;

    private int amount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Client client;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dish_id")
    private Dish dish;

    public Transaction() {
        //explicit public constructor;
    }

    public Transaction(Client client, Dish dish, int amount) {
        this.amount = amount;
        this.client = client;
        this.dish = dish;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;

        Transaction that = (Transaction) o;

        if (amount != that.amount) return false;
        if (id != that.id) return false;
        if (!client.equals(that.client)) return false;
        if (!dish.equals(that.dish)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + amount;
        result = 31 * result + client.hashCode();
        result = 31 * result + dish.hashCode();
        return result;
    }
}

