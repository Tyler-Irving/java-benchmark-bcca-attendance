package app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Attendance> attendanceInfo = loadInfo();

        System.out.println("Good Morning. Sign in.");

        Attendance studentInfo = getInfo();

        attendanceInfo.add(studentInfo);

        saveInfo(attendanceInfo);

    }

    public static Attendance getInfo() {
        System.out.print("Name: ");
        String name = in.nextLine();
        System.out.print("Time: ");
        String time = in.nextLine();
        return new Attendance(name, time);
    }

    private static void saveInfo(ArrayList<Attendance> attendanceInfo) {
        try {
            FileOutputStream fileStream = new FileOutputStream("attendanceInfo.ser");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(attendanceInfo);
            os.close();
        } catch (IOException ex) {
            System.out.println("Failed to save attendance.");
        }
    }

    public static ArrayList<Attendance> loadInfo() {
        try {
            FileInputStream fileStream = new FileInputStream("attendanceInfo.ser");
            ObjectInputStream os = new ObjectInputStream(fileStream);
            ArrayList<Attendance> attendanceInfo = (ArrayList<Attendance>) os.readObject();
            os.close();
            return attendanceInfo;
        } catch (IOException | ClassNotFoundException ex) {
            return new ArrayList<Attendance>();
        }
    }
}