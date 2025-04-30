package task1.Gates;

public class Gate {

    private String symbol;

    public Gate(String symbol){
        this.symbol = symbol;
    }

    public boolean evaluate(boolean a, boolean b) {
        return false;
    }

    public void table() {
        String finalPrint = "";
        String header = String.format(" A | B | Y= A %s B \n", this.symbol);
        String separator = "___|___|___\n";
        finalPrint += header + separator;

        for (int i = 0; i < 2; i++) {

            for (int y = 0; y < 2; y++) {
                boolean rowA = i < 1 ? false : true;
                boolean rowB = y == 0 ? false : true;
                boolean rowResult = this.evaluate(rowA, rowB);
                String line = String.format(" %s | %s | %s \n",
                        this.boolToString(rowA), this.boolToString(rowB), this.boolToString(rowResult));
                finalPrint += line + separator;
            }

        }
        System.out.println(finalPrint);
    }

    private String boolToString(boolean input) {
        return input ? "1" : "0";
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
