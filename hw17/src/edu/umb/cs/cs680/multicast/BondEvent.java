package edu.umb.cs.cs680.multicast;
import java.util.EventObject;

public class BondEvent extends EventObject{

	private String issuer;
	private float value;
	
	public BondEvent(Object type,String issuer,float value) 
	{
		super(type);
		this.issuer = issuer;
		this.value = value;
	}

	public String getBondIssuer()
	{
		return this.issuer;
	}
	
	public float getBondValue()
	{
		return this.value;
	}
}
