package edu.umb.cs.cs680;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;


public class DirectoryTest 
{
	
	
	@Test
	public void testGetChildren()
	{
		Directory root = new Directory(null, "root", "Vinit");
		Directory home = new Directory(root,"home","Vinit");
		Directory pictures = new Directory(root,"pictures","Vinit");
		root.appendChild(home);
		root.appendChild(pictures);
		int actualSize = root.getChildren().size();
		int expectedSize = 2;
		assertThat(actualSize, is(expectedSize));
	}
}
