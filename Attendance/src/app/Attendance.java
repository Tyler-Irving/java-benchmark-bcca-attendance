package app;

import java.io.Serializable;

public class Attendance implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    String date;

    public Attendance(String name, String date) {
        this.name = name;
        this.date = date;
    }
}