package edu.umb.cs.cs680;
import java.util.Comparator;

public class ReverseAlphabeticalComparator implements Comparator<FSElement>
{

	@Override
	public int compare(FSElement o1, FSElement o2) 
	{
		return o2.getLastModifiedDate().compareTo(o1.getLastModifiedDate());
	}

}
