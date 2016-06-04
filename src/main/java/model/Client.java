package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by MSI on 30.04.2016.
 */
@Entity
@Table(name = "users")
public class Client implements Serializable{

    public  Client()
    {
        this.userName = "Noname";
    }

    public Client(String name)
    {
        this.userName = name;

    }

    private long id;

    private String userName;

    private List<Transaction> transactions= new ArrayList<Transaction>(0);


//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  //          @JoinTable(name = "transactions", joinColumns = {@JoinColumn(name = "user_id")},
    //        inverseJoinColumns = {@JoinColumn(name = "dish_id")})




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
        return userName;
    }

    public void setName(String name) {
        this.userName = name;
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
