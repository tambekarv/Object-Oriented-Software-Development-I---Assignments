package edu.umb.cs.cs680.multicast;
import java.util.EventListener;

public interface BondEvObserver extends EventListener 
{
	public void updateBond(BondEvent bondevent); 
}
