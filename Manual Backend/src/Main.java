import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\akshu\\Documents\\MetroMate\\Manual Backend\\Dataset.csv"));
            Map<String, String> stationMap = new HashMap<>(); // Create a new HashMap to store station names and line names
            while ((line = br.readLine()) != null) {
                String[] station = line.split(splitBy);
                stationMap.put(station[0], station[1]); // Put the station name and line name into the HashMap
            }
            // Use the stationMap to access the line by station name and retrieve all station names of the same line
            System.out.print("Enter Name Of Station: ");
            String stationName = sc.nextLine();
            if (stationMap.containsKey(stationName)) {
                String lineName = stationMap.get(stationName);
                System.out.println("Line for station " + stationName + " is " + lineName);
            }
            else {
                System.out.println("No information found for station " + stationName);
            }

            System.out.print("Enter Name Of Station: ");
            String stationName2 = sc.nextLine();
            if (stationMap.containsKey(stationName2)) {
                String lineName = stationMap.get(stationName2);
                System.out.println("Line for station " + stationName2 + " is " + lineName);
            }
            else {
                System.out.println("No information found for station " + stationName2);
            }


            System.out.print("Enter the Line: ");
            String lineName = sc.nextLine();
            System.out.println("Stations on " + lineName + " line:");
            for (Map.Entry<String, String> entry : stationMap.entrySet()) {
                if (entry.getValue().equals(lineName)) {
                    String station = entry.getKey();
                    System.out.println(station);
                }
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}

