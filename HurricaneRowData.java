/**
 * This class organizes the object data and has an override to
 * print all the data.
 */

public class HurricaneRowData {

    private final int year;
    private final int aceIndex;
    private final int tropStorm;
    private final int hurrCat1;
    private final int hurrMajor;

    // Constructor
    public HurricaneRowData(int year, int aceIndex, int tropStorm, int hurrCat1, int hurrMajor) {
        this.year = year;
        this.aceIndex = aceIndex;
        this.tropStorm = tropStorm;
        this.hurrCat1 = hurrCat1;
        this.hurrMajor = hurrMajor;
    }

    // Getters
    // Source: CGPT "how do I set up getters
    public int getYear() {
        return year;
    }

    public int getAceIndex() {
        return aceIndex;
    }

    public int getTropStorm() {
        return tropStorm;
    }

    public int getHurrMajor() {
        return hurrCat1;
    }

    public int getGetHurrMajor() {
        return hurrMajor;
    }

    // For printing all the data
    @Override
    public String toString() {
        return String.format(
                "%-12s %-16s %-22s %-22s %-22s",
                "Year: " + year,
                "ACE Index: " + aceIndex,
                "Tropical Storms: " + tropStorm,
                "Hurricanes Cat 1: " + hurrCat1,
                "Major Hurricanes: " + hurrMajor);
    }
} // end class
