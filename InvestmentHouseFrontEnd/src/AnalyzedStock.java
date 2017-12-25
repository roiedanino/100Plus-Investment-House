/**
 * Created by roie on 27/05/2017.
 */
public class AnalyzedStock extends Stock{
    private double openingPrice;
    private double turnOver;
    private float change;

    public AnalyzedStock(String id,  double quote,String name, double turnOver, float change) {
        super(id,quote,name);
        this.turnOver = turnOver;
        this.change = change;
    }


    public float getChange() {
        return change;
    }

    public void setChange(float change) {
        this.change = change;
    }

    public double getTurnOver() {
        return turnOver;
    }

    public void setTurnOver(double turnOver) {
        this.turnOver = turnOver;
    }


	public double getOpeningPrice() {
		return openingPrice;
	}


	public void setOpeningPrice(double openingPrice) {
		this.openingPrice = openingPrice;
	}







}
