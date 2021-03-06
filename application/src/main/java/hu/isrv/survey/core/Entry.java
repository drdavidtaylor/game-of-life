package hu.isrv.survey.core;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by teddywestside on 2017. 02. 01..
 */
@Entity
//@Table(name = "ENTRY")
public class Entry implements Serializable {

    private static final long serialVersionUID = -577504403338770409L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

//    @Column(name = "NANOTIME")
    private long nanoTime;

//    @Column(name = "NUMBEROFELEMENTS")
    private int numberOfElements;


    @Override
    public String toString() {
        return String.format("Entry[id=%d, numberOfElements='%d', nanoTime='%d']", id, numberOfElements, nanoTime);
    }

    @Override
    public final int hashCode() {
        return numberOfElements;
    }

    public Entry() {

    }

    public Entry(int numberOfElements, long nanoTime) {
        this.numberOfElements = numberOfElements;
        this.nanoTime = nanoTime;
    }

    public long getNanoTime() {
        return nanoTime;
    }

    public void setNanoTime(long nanoTime) {
        this.nanoTime = nanoTime;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

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
