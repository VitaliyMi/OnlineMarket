package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by MSI on 22.05.2016.
 */
@Entity
@Table(name = "transactions")
/*@AssociationOverrides({
        @AssociationOverride(name = "tr.dish",
                joinColumns =@JoinColumn(name = "dish_id")),
        @AssociationOverride(name = "tr.client",
                joinColumns =@JoinColumn(name = "user_id"))
         })*/
public class Transaction{

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

    public Transaction()
    {}

    public Transaction(Client client, Dish dish,int amount) {
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



    /*  @Transient
    public Client getClient()
    {
      return getTr().getClient();
    }

    public void setClient(Client client)
    {
        getTr().setClient(client);
    }

    @Transient
    public Dish getDish()
    {
    return getTr().getDish();
    }

    public void setDish(Dish dish)
    {
        getTr().setDish(dish);
    }

     public Transaction (Client client, Dish dish, int amount)
    {
        tr.setClient(client);
        tr.setDish(dish);
        this.amount = amount;
    }

     private TransactionID tr = new TransactionID();

   @EmbeddedId
    public TransactionID getTr() {
        return tr;
    }

    public void setTr(TransactionID trID) {
        this.tr = trID;
    }

*/
}