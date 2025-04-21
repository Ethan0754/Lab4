import java.util.Objects;
import java.util.Scanner;

public abstract class Register {
    protected Purse purse;
    protected int[] wholeAmounts;
    protected int[] fractionalAmounts;
    protected String[] billString;
    protected String[] billType;
    protected String[] billImg;


    public Register(Purse purse) {
        this.purse = purse;
    }

    public void Count(double amt) {
        purse.removeAll();
        int integerPart = (int) amt; // Extracts the whole dollar part
        int fractionalPart = (int) Math.round((amt - integerPart) * 100); // Extracts the coin part
        defineParameters();
        makeChange(integerPart, fractionalPart);
    }

    public void makeChange(int integerPart, int fractionalPart) {
        int billCount;
        //loop through the bills portion of the array
        int i = 0;
        while (integerPart > 0) {
            billCount = (int) (integerPart / wholeAmounts[i]);
            if (billCount > 0) {
                purse.add(new Denomination(billString[i], wholeAmounts[i], billType[i], billImg[i]), billCount);
                integerPart -= (int) (wholeAmounts[i] * billCount);//subtract the total amount just added to the purse
            }
            i++;
        }
        i=0;
        while (fractionalPart > 0) {
            billCount = (int) (fractionalPart / fractionalAmounts[i]);
            if (billCount > 0) {
                purse.add(new Denomination(billString[i+wholeAmounts.length], fractionalAmounts[i] / 100, billType[i+wholeAmounts.length], billImg[i+wholeAmounts.length]), billCount);
                fractionalPart -= (int) (fractionalAmounts[i] * billCount);//subtract the total amount just added to the purse
            }
            i++;
        }

    }

    abstract void defineParameters();
}


