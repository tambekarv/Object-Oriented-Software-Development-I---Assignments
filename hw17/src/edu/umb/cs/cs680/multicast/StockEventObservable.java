package edu.umb.cs.cs680.multicast;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockEventObservable 
{
	private ArrayList<StockEvObserver> observers;
	private Map<String, Float> stockEvents;

	public StockEventObservable()
	{
		observers = new ArrayList<StockEvObserver>();
		stockEvents = new LinkedHashMap<String,Float>();
	}
	
	public void addEventListener(EventListener stockObserver)
	{
		observers.add((StockEvObserver) stockObserver);
	}
	
	public void notifyObservers(StockEvent stockevent)
	{
		for(int i = 0; i<observers.size();i++)
		{
			observers.get(i).updateStock(stockevent);
		}
	}

	public void ChangeQuote(String ticker,float quote)
	{
		StockEventObservable seo = new StockEventObservable();
		stockEvents.put(ticker, quote);
		notifyObservers(new StockEvent(seo, ticker, quote));
	}

}