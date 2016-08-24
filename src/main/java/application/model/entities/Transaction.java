package application.model.entities;

/**
 * Created by MSI on 21.08.2016.
 */

import javax.persistence.Entity;
import javax.persistence.*;


@Entity
@Table(name = "transactions")
public class Transaction {

    private int id;
    private int amount;
    private Client client;
    private Dish dish;

    @Id
    @GeneratedValue
    @Column(name = "transaction_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Transaction() {
    }

    public Transaction(Client client, Dish dish, int amount) {
        this.amount = amount;
        this.client = client;
        this.dish = dish;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dish_id")
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
}

