import java.io.Serializable;
import java.util.List;

public class ClientServerRequest implements Serializable{
	
	private static final long serialVersionUID = 2L;
	public enum ClientServerRequestType {SIGNUP , REQUEST, LOGIN, GETALLSTOCKS, GETALLREQUESTSBYINVOKEREMAIL, GETPORTFOLIO,GETBALANCE}
	private ClientServerRequestType type;
	private Account account= new Account();
	private Portfolio portfolio ;
	private String email;
	private String password;
	private List<AnalyzedStock> allAnalyzedStocks;
	private List<Request> allRequests;
	private Request request;
	private Double balance;
	private Long portfolioId;
	
	/** Default constructor */
	public ClientServerRequest() {
	}
	
	/** Login constructor */
	public ClientServerRequest(ClientServerRequestType type, String email, String password) {
		setType(type);
		setEmail(email);
		setPassword(password);
	}
	
	/** Sign up constructor */
	public ClientServerRequest(ClientServerRequestType type, Account account) {
		setType(type);
		setAccount(account);
	}
	
	/** Portfolio constructor */
	public ClientServerRequest(ClientServerRequestType type, Portfolio portfolio) {
		setType(type);
		setPortfolio(portfolio);
	}
	
	/** Bid/Ask constructor */
	public ClientServerRequest(ClientServerRequestType type, Request request) {
		setType(type);
		setRequest(request);
	}
	
	/** Get all stocks constructor */
	public ClientServerRequest(ClientServerRequestType type) {
		setType(type);
	}
	
	/** Multiple purpose constructor */
	public ClientServerRequest(ClientServerRequestType type, String Email) {
		setType(type);
		setEmail(Email);
	}
	/** Multiple purpose constructor */
	public ClientServerRequest(ClientServerRequestType type, Long portfolioId) {
		setType(type);
		setPortfolioId(portfolioId);
	}

	public Long getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(Long portfolioId) {
		this.portfolioId = portfolioId;
	}
	
	public ClientServerRequestType getType() {
		return type;
	}

	public void setType(ClientServerRequestType type) {
		this.type = type;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<AnalyzedStock> getAllAnalyzedStocks() {
		return allAnalyzedStocks;
	}

	public void setAllAnalyzedStocks(List<AnalyzedStock> allAnalyzedStocks) {
		this.allAnalyzedStocks = allAnalyzedStocks;
	}

	public List<Request> getAllRequests() {
		return allRequests;
	}

	public void setAllRequests(List<Request> allRequests) {
		this.allRequests = allRequests;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
}
