import java.util.ArrayList;

public class Airport
{
    /** A list of the flights into and out of this airport
     *  Guaranteed not to be null and to contain only non-null entries
     */
    private ArrayList<Flight> allFlights;

    public Airport(ArrayList<Flight> flights)
    {
        allFlights = flights;
    }

    public ArrayList<Flight> getAllFlights()
    {
        return allFlights;
    }

    /** Returns the revenue generated by all flights at the airport,
     *  as described in part (a)
     */
    public double getTotalRevenue() {
        double total = 0;
        double toMultiply = 0;
        for (int i = 0; i < allFlights.size(); i++) {
            toMultiply = allFlights.get(i).getNumPassengers();
            if (allFlights.get(i).getNumPassengers() > allFlights.get(i).getCapacity()){
                toMultiply = allFlights.get(i).getCapacity();
            }
            total += toMultiply * allFlights.get(i).getPrice();
        }
        return total;
    }

    /** Updates the list of flights by removing certain flights and
     *  returns the total number of passengers whose flights were removed,
     *  as described in part (b)
     */
    public int updateFlights()
    {
        int numRemoved = 0;
        for (int i = 0; i < allFlights.size(); i++){
            if (allFlights.get(i).getNumPassengers() < allFlights.get(i).getCapacity() * .20){
                numRemoved += allFlights.get(i).getNumPassengers();
                allFlights.remove(i);
                i--;
            }
        }
        return numRemoved;
    }
}