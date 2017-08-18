package edu.umb.cs.cs680;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class FileTest 
{
	private Directory home = new Directory(null, "home", "Vinit");
	private File p = new File(home, "p", "Vinit", 1);
	@Test
	public void testConstructor()
	{
		String actualName = "p";
		String expectedName = p.getName();
		String actualOwner = "Vinit";
		String expectedOwner = p.getOwner();
		Directory actualParent = home;
		Directory expectedParent = p.getParent();
		int actualSize = 1;
		int expectedSize = p.getSize();
		assertThat(actualName,is(expectedName));
		assertThat(actualOwner,is(expectedOwner));
		assertThat(actualParent,is(expectedParent));
		assertThat(actualSize,is(expectedSize));
		
	}
}
