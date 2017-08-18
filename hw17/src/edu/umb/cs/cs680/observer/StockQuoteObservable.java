package edu.umb.cs.cs680.observer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Observable;

public class StockQuoteObservable extends Observable
{
	private Map<String, Float> events;

	public StockQuoteObservable()
	{
		events = new LinkedHashMap<String, Float>();
	}

	public void ChangeQuote(String t,float q)
	{
		events.put(t, q);
		setChanged();
		notifyObservers(new StockEvent(t,q));
	}

public static void main(String args[])
{
	StockQuoteObservable stockObservable = new StockQuoteObservable();
	stockObservable.addObserver(new TableObserver());
	stockObservable.addObserver(new PieChartObserver());
	stockObservable.addObserver(new ThreeDObserver());
	stockObservable.ChangeQuote("Google",56);
	stockObservable.ChangeQuote("Google", 56.3f);
	stockObservable.ChangeQuote("Apple", 92);
}


}

