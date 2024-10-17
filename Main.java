
/**
 * Noah MacGillivray
 * Assignment: Linked List 
 * 10/20/2024
 * CSCI 2251 U01
 * Purpose: This program reads in a file of hurricane data, instantiates each line of data
 * in an object defined in the class HurricaneRowDat, //TODO class where various methods manipulate the data.
 * General sources:
 * Referenced 080_fileio_baby
 * Gemini: "how do I use three classes to import, store data and manage the data"
 * Gemini: "how does the data manager work if it does not have a return type"
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        if (args.length != 1) {
        	System.out.println("Please provide the file path.");
        	return;
        }
        String filePath = args[0]; 
        */
        String filePath = ("C:\\Users\\pilga\\code\\CS2251_code\\Linked_List\\ace.csv");
        // Instantiates a new object of the class HurricaneDataManager
        HurricaneDataManager dataSet1 = new HurricaneDataManager();

        try {
            File f = new File(filePath);
            Scanner s = new Scanner(f);

            s.nextLine();

            while (s.hasNext()) {
                String line = s.nextLine(); // Strips the header
                String[] values = line.split(","); // Breaks the data up

                HurricaneRowData temp = new HurricaneRowData(
                        Integer.parseInt(values[0]), // year
                        Integer.parseInt(values[1]), // aceIndex
                        Integer.parseInt(values[2]), //tropStorm
                        Integer.parseInt(values[3]), // hurrCat1
                        Integer.parseInt(values[4]) // hurrMajor
                );
                // Source: "CGPT how do I add data from Main into a data class"
                dataSet1.addHurricaneData(temp);
            }
            s.close();
            // Source: CGPT "what io exception do I want to initiate in try / catch for a file input"
        } catch (IOException e) {
            System.err.println("IO error: " + e.getMessage());
        }
        // Source: CGPT "how do I call another method in another class with an object
        // that has been instantiated in main"
        // Prints the entire data set to ensure proper file input and classification
        dataSet1.printAllHurricaneData();
        System.out.println();
        dataSet1.calculateAndPrintMaximumAceYear();
        dataSet1.aceAverageAndFrequency();

    } // end public static void main (String[] args )
} // End public class Main