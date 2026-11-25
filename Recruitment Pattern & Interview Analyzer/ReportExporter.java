

import java.io.*;

public class ReportExporter {

    public void exportReport(String report) {

        try {

            FileWriter writer = new FileWriter("PlacementReport.txt");

            writer.write(report);

            writer.close();

            System.out.println("Report Exported Successfully!");

        }
        catch (IOException e) {

            System.out.println("Error while exporting report.");
        }
    }
}
