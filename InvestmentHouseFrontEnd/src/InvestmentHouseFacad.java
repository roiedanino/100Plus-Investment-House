import java.io.IOException;
import java.util.ArrayList;


public interface InvestmentHouseFacad {
	
	public ClientServerRequest login(String email,String password) throws IOException, ClassNotFoundException;
    public Account signup(Account account);
    public ArrayList<AnalyzedStock> getAllStocks();
    public ArrayList<Request> getAccountsRequests(Account account);
    public void sendRequest(Request request);
    public Portfolio getPortfolioByInvokerId(Long portfolioId);
    public void logOut();
    public Double getBalanceByInvokerEmail(String email);

}
