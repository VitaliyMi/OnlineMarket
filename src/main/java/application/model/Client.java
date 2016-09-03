package application.model;

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

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private long id;

    @Column(name = "userName")
    private String name;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
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

    public void addTransactions(List<Transaction> transactionList)
    {
        transactions.addAll(transactionList);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;

        Client client = (Client) o;

        if (id != client.id) return false;
        if (!name.equals(client.name)) return false;
        if (!transactions.equals(client.transactions)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        return result;
    }
}