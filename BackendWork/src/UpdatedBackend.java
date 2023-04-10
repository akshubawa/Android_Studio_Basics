/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import org.json.*;

public class UpdatedBackend {
    public static void main(String[] args) throws IOException, JSONException {
        Scanner sc = new Scanner(System.in);
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
                System.out.println("Line 1: " + line1.toString());
                JSONArray line2 = json.getJSONArray("line2");
                System.out.println("Line 2: " + line2.toString());
                JSONArray interchange = json.getJSONArray("interchange");
                System.out.println("Interchange: " + interchange.toString());
                JSONArray lineEnds = json.getJSONArray("lineEnds");
                System.out.println("Line Ends: " + lineEnds.toString());
                JSONArray path = json.getJSONArray("path");
                System.out.println("Path: " + path.toString());
                double time = json.getDouble("time");
                System.out.println("Time: " + time);
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
