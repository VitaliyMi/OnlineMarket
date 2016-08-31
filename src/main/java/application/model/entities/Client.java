package application.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MSI on 30.04.2016.
 */
@Entity
@Table(name = "users")
public class Client implements Serializable{

    private long id;

    private String name;

    private List<Transaction> transactions= new ArrayList<>();


    public  Client()
    {
        //explicit public constructor;
    }

    public Client(String name)
    {
        this.name = name;

    }


    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "userName")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addTransactions(List<Transaction> transactionList)
    {
        transactions.addAll(transactionList);
    }


    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    public List<Transaction> getTransactions() {
        return transactions;
    }

}