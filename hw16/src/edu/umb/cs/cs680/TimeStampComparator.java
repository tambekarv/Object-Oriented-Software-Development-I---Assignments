package edu.umb.cs.cs680;
import java.util.Comparator;

public class TimeStampComparator implements Comparator<FSElement> {

	@Override
	public int compare(FSElement o1, FSElement o2)
	{	
		return o1.getLastModifiedDate().compareTo(o2.getLastModifiedDate());
	}

}
