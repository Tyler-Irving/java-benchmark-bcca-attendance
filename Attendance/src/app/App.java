package app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Attendance> attendanceInfo = loadInfo();
        String date = getCurrentTimeUsingDate();

        System.out.println("Current time: " + date);
        while (true) {
            String name = getInfo();
            if (name == null) {
                break;
            } else {
                Attendance studentInfo = new Attendance(name, date);
                attendanceInfo.add(studentInfo);
                break;
            }
        }

        saveInfo(attendanceInfo);
    }

    public static String getInfo() {
        while (true) {
            System.out.println("| Angie U");
            System.out.println("| Christian G");
            System.out.println("| Dakota N");
            System.out.println("| Derek S");
            System.out.println("| Destiny M");
            System.out.println("| Devin B");
            System.out.println("| Dylan M");
            System.out.println("| Gillian F");
            System.out.println("| JD G");
            System.out.println("| Oscar G");
            System.out.println("| Patton B");
            System.out.println("| Tyler I");
            System.out.println("| quit");
            System.out.println(" - Enter one of the names listed above.");
            System.out.println(" - Ignore casing.");
            System.out.println(" - Do NOT ignore the space.");
            System.out.print(">>> ");
            String choice = in.nextLine();
            if (choice.equalsIgnoreCase("q")) {
                return null;
            } else if (choice.equalsIgnoreCase("angie u") || choice.equalsIgnoreCase("christian g")
                    || choice.equalsIgnoreCase("dakota n") || choice.equalsIgnoreCase("derek s")
                    || choice.equalsIgnoreCase("destiny m") || choice.equalsIgnoreCase("devin b")
                    || choice.equalsIgnoreCase("dylan m") || choice.equalsIgnoreCase("gillian f")
                    || choice.equalsIgnoreCase("jd g") || choice.equalsIgnoreCase("oscar g")
                    || choice.equalsIgnoreCase("patton b") || choice.equalsIgnoreCase("tyler i")) {
                return choice;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

    public static String getCurrentTimeUsingDate() {
        Date date = new Date();
        String strDateFormat = "hh:mm:ss a";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate = dateFormat.format(date);
        return formattedDate;
    }

    private static void saveInfo(ArrayList<Attendance> attendanceInfo) {
        try {
            FileOutputStream fileStream = new FileOutputStream("attendanceInfo.ser");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(attendanceInfo);
            os.close();
            System.out.println("You're signed in.");
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