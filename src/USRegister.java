public class USRegister extends Register {
    public USRegister(Purse purse) {
        super(purse);
    }

    @Override
    void defineParameters() {
        //arrays meant for looping through each value of a bill//
        wholeAmounts = new int[]{100, 50, 20, 10, 5, 1};
        fractionalAmounts = new int[]{25, 10, 5, 1};
        billString = new String[]{"One-Hundred-Dollar Note", "Fifty-Dollar Note",
                "Twenty-Dollar Note", "Ten-Dollar Note", "Five-Dollar Note",
                "One-Dollar Note", "Quarter", "Dime", "Nickel", "Penny"};

        billType = new String[]{"bill", "bill", "bill", "bill", "bill", "bill", "coin", "coin", "coin", "coin"};
        billImg = new String[]{"images/100dollar.png", "images/50dollar.png", "images/20dollar.png", "images/10dollar.png", "images/5dollar.png",
                "images/1dollar.png", "images/quarter.png", "images/dime.png", "images/nickel.png", "images/penny.png"};
    }
}

