import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Portfolio implements Serializable{
	
	private Long portfolioId;
	private Map<String, InvestorStock> investorStocks = new HashMap<>();
	private ArrayList<String> requests = new ArrayList<>();
	private Double commissionPercentage = 0.0035;
	
	public Portfolio() {
	}
	
	public Long getPortfolioId() {
		return portfolioId;
	}
	
	public void setPortfolioId(Long portfolioId) {
		this.portfolioId = portfolioId;
	}
	
	public Map<String, InvestorStock> getInvestorStocks() {
		return investorStocks;
	}
	
	public void setInvestorStocks(Map<String, InvestorStock> investorStocks) {
		this.investorStocks = investorStocks;
	}
	
	public ArrayList<String> getRequests() {
		return requests;
	}
	
	public void setRequests(ArrayList<String> requests) {
		this.requests = requests;
	}

	public Double getCommissionPercentage() {
		return commissionPercentage;
	}

	public void setCommissionPercentage(Double commissionPercentage) {
		this.commissionPercentage = commissionPercentage;
	}
	
}
