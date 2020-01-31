package app;

import java.io.Serializable;

public class Attendance implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    String time;

    public Attendance(String name, String time) {
        this.name = name;
        this.time = time;
    }
}