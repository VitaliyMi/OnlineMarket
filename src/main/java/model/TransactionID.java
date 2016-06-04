package model;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by MSI on 29.05.2016.
 */
@Embeddable
public class TransactionID implements Serializable{


    private Client client;

    private Dish dish;

    @ManyToOne(cascade = CascadeType.ALL)
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactionID)) return false;

        TransactionID that = (TransactionID) o;

        if (client != null ? !client.equals(that.client) : that.client != null) return false;
        if (dish != null ? !dish.equals(that.dish) : that.dish != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = client != null ? client.hashCode() : 0;
        result = 31 * result + (dish != null ? dish.hashCode() : 0);
        return result;
    }
}
