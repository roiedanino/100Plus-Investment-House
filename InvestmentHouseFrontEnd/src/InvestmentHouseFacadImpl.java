import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;



public class InvestmentHouseFacadImpl implements InvestmentHouseFacad{

	private Socket socket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	
	public InvestmentHouseFacadImpl() {
		try {
			this.socket = new Socket("localhost", 1234);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ClientServerRequest login(String email, String password) {
		ClientServerRequest csr = new ClientServerRequest(ClientServerRequest.ClientServerRequestType.LOGIN, email, password);
		sendClientServerRequestToTheInvestmentHouse(csr);
		return getAnswersFromInvestmentHouse();
	}

	@Override
	public Account signup(Account account) {
		ClientServerRequest csr = new ClientServerRequest(ClientServerRequest.ClientServerRequestType.SIGNUP, account);
		sendClientServerRequestToTheInvestmentHouse(csr);
		return getAnswersFromInvestmentHouse().getAccount();
	}

	@Override
	public ArrayList<AnalyzedStock> getAllStocks() {

		ClientServerRequest csr = new ClientServerRequest(ClientServerRequest.ClientServerRequestType.GETALLSTOCKS);
		sendClientServerRequestToTheInvestmentHouse(csr);
		return new ArrayList<>(getAnswersFromInvestmentHouse().getAllAnalyzedStocks());
	}

	@Override
	public ArrayList<Request> getAccountsRequests(Account account) {
		ClientServerRequest csr = new ClientServerRequest(ClientServerRequest.ClientServerRequestType.GETALLREQUESTSBYINVOKEREMAIL, account.getEmail());
		sendClientServerRequestToTheInvestmentHouse(csr);
		return new ArrayList<>(getAnswersFromInvestmentHouse().getAllRequests());
	}

	@Override
	public void sendRequest(Request request) {
		ClientServerRequest csr = new ClientServerRequest(ClientServerRequest.ClientServerRequestType.REQUEST, request);
		sendClientServerRequestToTheInvestmentHouse(csr);
	}
	
	@Override
	public Portfolio getPortfolioByInvokerId(Long portfolioId) {
		ClientServerRequest csr = new ClientServerRequest(ClientServerRequest.ClientServerRequestType.GETPORTFOLIO, portfolioId);
		sendClientServerRequestToTheInvestmentHouse(csr);
		return getAnswersFromInvestmentHouse().getPortfolio();
	}
	
	@Override
	public void logOut() {
		try {
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Double getBalanceByInvokerEmail(String email) {
		ClientServerRequest csr = new ClientServerRequest(ClientServerRequest.ClientServerRequestType.GETBALANCE,email);
		sendClientServerRequestToTheInvestmentHouse(csr);
		return getAnswersFromInvestmentHouse().getBalance();
	}

	private void sendClientServerRequestToTheInvestmentHouse(ClientServerRequest csr) {
		try {
			oos.writeObject(csr);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private ClientServerRequest getAnswersFromInvestmentHouse() {
		ClientServerRequest csr = null;
		while(csr == null) {
			try {
				csr = (ClientServerRequest) ois.readObject();
				if(csr != null) {
					System.out.println("GOT SOME NEWS:" + csr.getAccount() + " ");
					csr.getAllAnalyzedStocks().forEach(as -> System.out.print(as.getTurnOver()+" "));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return csr;
	}
	
}