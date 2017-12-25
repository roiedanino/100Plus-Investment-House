/**
 * Created by roie on 31/05/2017.
 */
public class InvestorStock extends AnalyzedStock {
    private double boughtPrice;
    private int shares;

    public InvestorStock(String symbol, double closingPrice, String name,double turnOver, float change, double payedPrice, int shares) {
        super(symbol,closingPrice,name, turnOver, change);
        setBoughtPrice(payedPrice);
        setShares(shares);
    }


    public double getBoughtPrice() {
        return boughtPrice;
    }

    public void setBoughtPrice(double boughtPrice) {
        this.boughtPrice = boughtPrice;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }
}
