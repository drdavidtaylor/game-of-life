package hu.isrv.survey.core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by teddywestside on 2017. 02. 01..
 */
@Entity
public class Entry implements Serializable {

    private static final long serialVersionUID = -577504403338770409L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
