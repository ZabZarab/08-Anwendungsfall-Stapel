package model;

import java.sql.Timestamp;

/**
 * Created by Jean-Pierre on 01.11.2016.
 */
public class Exam {

    private String pupil;
    private Timestamp timestamp;

    public Exam(String pupil){
        this.pupil = pupil;
        timestamp = new Timestamp(System.currentTimeMillis());
    }

    public String toString(){
        return pupil + " - " + timestamp.toString();
    }
}
