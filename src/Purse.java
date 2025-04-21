import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Purse {

    private Map<Denomination, Integer> cash;
    private final List<PurseObserver> observers = new ArrayList<>();

    public Purse() {
        cash = new LinkedHashMap<>();
    }

    public void add(Denomination d, int numBills) {
        cash.put(d, numBills);
        notifyObservers();
    }

    public void removeAll() {
        cash.clear();
        notifyObservers();
    }

    public double getValue(){
        double total = 0;
        //for each map in the cash var - find the total of the bills in that mapping
        for (Map.Entry<Denomination, Integer> bills : cash.entrySet()) {
            //    amount attached to the bill   count of that bill
            total += bills.getKey().amt() * bills.getValue();
        }
        return total;
    }

    public String toString(){
        String rep = "";
        //for each map in the cash var - create a string representation of bills in each map
        for (Map.Entry<Denomination, Integer> bills : cash.entrySet()) {
            //   human-readable name of bill      count of that bill
            rep += bills.getKey().name() + ": " + bills.getValue() + "\n";
        }
        return rep;
    }

    public Map<Denomination, Integer> getCash() {
        return cash;
    }

    public void addObserver(PurseObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(PurseObserver observer) {
        observers.remove(observer);
    }

    // Notify all observers of a change in the purse
    private void notifyObservers() {
        for (PurseObserver observer : observers) {
            observer.update(this); // Pass the purse itself as the source
        }
    }



}
