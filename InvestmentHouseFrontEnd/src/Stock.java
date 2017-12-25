import java.io.Serializable;

public class Stock implements Serializable{
	String id;
	Double quote;
	String name;
	
	public Stock(){
		
	}
	public Stock(String id,Double quote,String name){
		setId(id);
		setQuote(quote);
		setName(name);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getQuote() {
		return quote;
	}
	public void setQuote(Double qoute) {
		this.quote = qoute;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
