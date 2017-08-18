package edu.umb.cs.cs680.multicast;
import java.util.EventObject;

public class StockEvent extends EventObject{
	private String ticker;
	private float quote;

	public StockEvent(Object type,String ticker,float quote) {
		super(type);
		this.ticker = ticker;
		this.quote = quote;
	}

	public String getTicker()
	{
		return this.ticker;
	}

	public float getQuote()
	{
		return this.quote;
	}
}
