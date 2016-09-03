package application.model;

/**
 * Created by MSI on 30.04.2016.
 */

import javax.persistence.*;
import java.util.Arrays;

@Table(name = "Photos")
public class Photo {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private byte[] body;

    public Photo() {
        //explicit public constructor;
    }

    public Photo(String name, byte[] body) {
        this.name = name;
        this.body = body;
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

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Photo)) return false;

        Photo photo = (Photo) o;

        if (id != photo.id) return false;
        if (!Arrays.equals(body, photo.body)) return false;
        if (!name.equals(photo.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + Arrays.hashCode(body);
        return result;
    }
}