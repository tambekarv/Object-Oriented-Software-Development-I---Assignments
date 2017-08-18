package edu.umb.cs.cs680.multicast;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.LinkedHashMap;
import java.util.Map;

public class BondEventObservable
{
	private ArrayList<BondEvObserver> observers;
	private Map<String, Float> bondEvents;

	public BondEventObservable()
	{
		bondEvents = new LinkedHashMap<String, Float>();
		observers = new ArrayList<BondEvObserver>();
	}

	public void addEventListener(EventListener bondObserver)
	{
		observers.add((BondEvObserver) bondObserver);
	}

	public void notifyObservers(BondEvent bondEvent)
	{
		for(int i = 0; i<observers.size();i++)
		{
			observers.get(i).updateBond(bondEvent);
		}
	}

	public void ChangeBond(String issuer,float value)
	{
		BondEventObservable beo = new BondEventObservable();
		bondEvents.put(issuer, value);
		notifyObservers(new BondEvent(beo,issuer,value));
	}

	public static void main(String args[])
	{
		BondEventObservable bondEvent = new BondEventObservable();
		bondEvent.addEventListener(new PieChartObserver());
		bondEvent.addEventListener(new TableObserver());
		bondEvent.addEventListener(new ThreeDObserver());
		bondEvent.ChangeBond("EMC", 1000);
		bondEvent.ChangeBond("EMC", 5000);
		bondEvent.ChangeBond("Dell", 5500);
		/*bondEvent.addObserver(new TableObserver());
		bondEvent.addObserver(new PieChartObserver());
		bondEvent.addObserver(new ThreeDObserver());
		bondEvent.ChangeQuote("Google",56);
		bondEvent.ChangeQuote("Google", 56.3f);
		bondEvent.ChangeQuote("Apple", 92);
*/	}

}
