/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import org.json.*;

public class Try {
    public static void main(String[] args) throws IOException, JSONException {
        Scanner sc = new Scanner(System.in);
        double balance = 1000;
        System.out.println("Your Account Balance is: "+balance);
        System.out.print("Enter Source Station: ");
        String fromStation = sc.nextLine();
        System.out.print("Enter Destination Station: ");
        String toStation = sc.nextLine();
        String encodedFromStation = URLEncoder.encode(fromStation, "UTF-8");
        String encodedToStation = URLEncoder.encode(toStation, "UTF-8");
        URL url = new URL("https://us-central1-delhimetroapi.cloudfunctions.net/route-get?from=" + encodedFromStation + "&to=" + encodedToStation);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();

        JSONObject json = new JSONObject(content.toString());

        int statusCode = json.getInt("status");
        switch (statusCode) {
            case 200:
                JSONArray line1 = json.getJSONArray("line1");
                JSONArray line2 = json.getJSONArray("line2");

                // concatenate line1 and line2
                JSONArray lines = new JSONArray();
                for (int i = 0; i < line1.length(); i++) {
                    lines.put(line1.get(i));
                }
                for (int i = 0; i < line2.length(); i++) {
                    lines.put(line2.get(i));
                }

                // remove duplicates while preserving order
                Set<Object> set = new HashSet<Object>();
                JSONArray uniqueLines = new JSONArray();
                for (int i = 0; i < lines.length(); i++) {
                    Object obj = lines.get(i);
                    if (!set.contains(obj)) {
                        set.add(obj);
                        uniqueLines.put(obj);
                    }
                }

                System.out.println("Lines: " + uniqueLines.toString());
                JSONArray interchange = json.getJSONArray("interchange");
                //String sourceStation = fromStation;
                //String destinationStation = toStation;
                JSONArray newInterchange = new JSONArray();
                newInterchange.put(fromStation);
                for (int i = 0; i < interchange.length(); i++) {
                    String station = interchange.getString(i);
                    if (!station.equals(fromStation) && !station.equals(toStation)) {
                        newInterchange.put(station);
                    }
                }
                newInterchange.put(toStation);
                interchange = newInterchange;
                System.out.println("Main Stations: " + interchange.toString());

                JSONArray lineEnds = json.getJSONArray("lineEnds");
                System.out.println("Line Ends: " + lineEnds.toString());
                JSONArray path = json.getJSONArray("path");
                System.out.println("Path: " + path.toString());
                double time = json.getDouble("time");
                System.out.println("Time: " + (int)time + " mins");
                int fare = 0;
                if (time>=55) {
                    fare=60;
                }
                else if (time>=40) {
                    fare=50;
                }
                else if (time>=30) {
                    fare=40;
                }
                else if (time>=20) {
                    fare=30;
                }
                else if (time>=10) {
                    fare=20;
                }
                else if (time<=10) {
                    fare=10;
                }
                System.out.println("Fare: " + fare + " Rupees");

                balance -= fare;
                System.out.println("Updated Balance after Booking: "+balance);
                break;
            case 204:
                System.out.println("Same source and destination");
                break;
            case 400:
                System.out.println("Undefined source or destination");
                break;
            case 4061:
                System.out.println("Invalid source");
                break;
            case 4062:
                System.out.println("Invalid destination");
                break;
            case 406:
                System.out.println("Invalid source and destination");
                break;
            default:
                System.out.println("Unknown error");
                break;
        }
    }
}

*/
