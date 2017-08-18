package edu.umb.cs.cs680.multicast;
import java.util.EventListener;

public interface StockEvObserver extends EventListener 
{
	public void updateStock(StockEvent stockevent);
}
