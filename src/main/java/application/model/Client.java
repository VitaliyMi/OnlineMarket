package application.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "users")
public class Client implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private long id;

    @Column(name = "userName")
    private String name;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();


    public Client() {
        //explicit public constructor;
    }

    public Client(String name) {
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

    public void addTransactions(List<Transaction> transactionList) {
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
        return getId() == client.getId() &&
                Objects.equals(getName(), client.getName()) &&
                Objects.equals(getTransactions(), client.getTransactions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getTransactions());
    }
}