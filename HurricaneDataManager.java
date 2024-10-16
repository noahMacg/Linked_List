
/**
 * This class holds and allows manipulation of the data.
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class HurricaneDataManager {

    private ArrayList<HurricaneRowData> hurricaneDataList;

    // Allows access to the data from outside the class by making a new ArrayList
    public HurricaneDataManager() {
        this.hurricaneDataList = new ArrayList<>();
    }

    // Adds data to the private ArrayList
    public void addHurricaneData(HurricaneRowData data) {
        hurricaneDataList.add(data);
    }

    // Prints out all the data
    public void printAllHurricaneData() {
        for (HurricaneRowData data : hurricaneDataList) {
            System.out.println(data); // Calls the toString() method of HurricaneRowData
        }
    }

    // Calculates the maximus ACE year and prints it to the console and a file
    public void calculateAndPrintMaxiumAceYear() {
        int highAceIndex = 0;
        int highAceYear = 0;
        for (HurricaneRowData data : hurricaneDataList) {
            if (data.getAceIndex() > highAceIndex) {
                highAceIndex = data.getAceIndex();
                highAceYear = data.getYear();
            }
        }
        System.out.println("High ACE index: " + highAceIndex);
        System.out.println("High ACE year: " + highAceYear);

        // Source: Gemini "how do I write a file with file writer in java"
        String fileName = "High ACE index.txt";
        String content = "High ACE index: " + highAceIndex + "\n" +
                "High ACE year: " + highAceYear;

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    /*
    This method calculates and prints the average and frequency distribution
    of every 6 years. I am also taking statistics, so I decided to try and incorporate what
    I am learning. The method became a bit long and could have been organized better / broken
    up into a couple more methods. I believe the calculations are correct?
    */
    public void aceAverageAndFrequency() {
        int currentValue = 0;
        System.out.println("\nThe following are the 6 year averages starting at 1951: ");

        // Holds the 11-year average
        ArrayList<Double> elevenYearAvg = new ArrayList<>();

        // This nested loop breaks find the sum for periods of 11-years excluding the
        // first year (made it simpler to formulate a graph).
        for (int i = 1; i < hurricaneDataList.size(); i = i + 6) {
            double sum = 0;
            for (int j = i; j < 6 + i; j++) {
                // Source: Gemini "why isn't this working sum += hurricaineDataList.getAceIndex()[j];"
                sum += hurricaneDataList.get(j).getAceIndex();
                currentValue = hurricaneDataList.get(j).getAceIndex();
            }
            double average = sum / 6;
            elevenYearAvg.add(average);
            System.out.println(average);
        }

        double averageSum = 0;

        // This loop summed all the averages to use in the frequency distribution below.
        for (int i = 0; i < elevenYearAvg.size(); i++) {
            averageSum += elevenYearAvg.get(i);
        }

        System.out.println("\nThe following are the frequency distributions \n" +
                "with the associated graph:\n");

        double frequencyDistribution = 0;

        // This loop became a bit messy, but it essentially finds the frequency distribution
        // and creates variables to use in printing the year range and the graph.
        for (int i = 0; i < elevenYearAvg.size(); i++) {
            frequencyDistribution = elevenYearAvg.get(i) / averageSum;

            // Source: Gemini "double to an int"
            // This calculation is used to determine the "weight" of each mark on the graph
            int graphDepth = (int) Math.round(frequencyDistribution / .01);
            int yearRangeStart = (1951 + (i * 6));
            int yearRangeEnd = (1956 + (i * 6));

            System.out.print(yearRangeStart + "-" + yearRangeEnd + ": ");
            //Source: Gemini "how do I make this pad with 35 spaces just on the first #"
            System.out.printf("%-12.6f", frequencyDistribution);

            for (int j = 0; j < graphDepth; j++) {
                System.out.print("(*)");
            }
            System.out.println();
        } // public void aceAverageAndFrequency()
    } // public void aceAverageAndFrequency()
} // public class HurricaneDataManager
