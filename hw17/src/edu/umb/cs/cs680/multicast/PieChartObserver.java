package edu.umb.cs.cs680.multicast;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class PieChartObserver implements BondEvObserver,StockEvObserver
{
	private Map<String,Float> bondEvents;
	private Map<String,Float> stockEvents;
	
	public PieChartObserver()
	{
		bondEvents = new LinkedHashMap<String, Float>(); 
		stockEvents = new LinkedHashMap<String, Float>();
	}

	@Override
	public void updateBond(BondEvent bondevent) 
	{
		bondEvents.put(bondevent.getBondIssuer(), bondevent.getBondValue());
		bondDraw(bondevent.getBondIssuer(),bondevent.getBondValue());
	}
	
	private void bondDraw(String issuer, float yeild) 
	{
		System.out.println("\nAfter Updating Pie Chart");
		Set<Entry<String, Float>> keys = bondEvents.entrySet();
		for(Entry<String, Float> k:keys)
		{
			System.out.println("Issuer:" +k.getKey()+ "Value:" +k.getValue());
		}
	}

	@Override
	public void updateStock(StockEvent stockevent) 
	{
		stockEvents.put(stockevent.getTicker(), stockevent.getQuote());
		stockDraw(stockevent.getTicker(),stockevent.getQuote());
	}

	private void stockDraw(String ticker, float quote) 
	{
		System.out.println("\nAfter Updating Pie Chart");
		Set<Entry<String, Float>> keys = stockEvents.entrySet();
		for(Entry<String, Float> k:keys)
		{
			System.out.println("Ticker:" +k.getKey()+ "Quote:" +k.getValue());
		}
	}
}
