public class EURegister extends Register{
    public EURegister(Purse purse) {
        super(purse);
    }

    @Override
    void defineParameters() {
        //arrays meant for looping through each value of a bill//
        wholeAmounts = new int[]{500, 200, 100, 50, 20, 10, 5, 2, 1};
        fractionalAmounts = new int[]{50, 20, 10, 5, 2, 1};
        billString = new String[]{"five-hundred-euro note", "two-hundred-euro note", "one-hundred euro note", "fifty-euro Note",
                "twenty-euro note", "ten-euro note", "five-euro note", "two-euro coin",
                "one-euro coin", "fifty-euro-cent coin", "twenty-euro-cent coin", "ten-euro-cent coin", "five-euro-cent coin", "two-euro-cent coin", "one-euro-cent coin"};

        billType = new String[]{"bill", "bill", "bill", "bill", "bill", "bill", "bill", "coin", "coin", "coin", "coin", "coin", "coin", "coin", "coin"};
        billImg = new String[]{"images/500euro.png", "images/200euro.png", "images/100euro.png", "images/50euro.png", "images/20euro.png",
                "images/10euro.png", "images/5euro.png", "images/2euro.png", "images/1euro.png", "images/50centeuro.png", "images/20centeuro.png", "images/10centeuro.png", "images/5centeuro.png",
                "images/2centeuro.png", "images/1centeuro.png"};
    }
}
