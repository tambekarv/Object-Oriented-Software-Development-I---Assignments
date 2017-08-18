package edu.umb.cs.cs680;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Date;

public class FSElementTest 
{	
	private Directory home;
	private File p = new File(home, "p1", "Vinit", 1);
	FSElement fse;

	@Test
	public void testGetSetName()
	{	
		p.setName("P");
		String actual = "P";
		String expected = p.getName();
		assertThat(actual, is(expected));
	}

	@Test
	public void testGetSetOwner()
	{
		p.setOwner("Tom");
		String actual = "Tom";
		String expected = p.getOwner();
		assertThat(actual, is(expected));
	}

	@Test
	public void testGetSetModifiedDates(){
		Date d = new Date();
		p.setLastModifiedDate(d);
		assertThat(p.getLastModifiedDate(),is(d));
	}
	

	@Test
	public void testGetSize()
	{
		FileSystem fs = FileSystem.getFileSystem();
		Directory root = new Directory(null, "root", "Vinit");
		Directory home = new Directory(root,"home","Vinit");
		Directory system = new Directory(root,"system","Vinit");
		Directory pictures = new Directory(home,"pictures","Vinit");
		File a = new File(system, "a", "Vinit", 1);
		File b = new File(system, "b","Vinit", 1);
		File c = new File(system, "c","Vinit",1);
		File d = new File(home, "d","Vinit", 1);
		File e = new File(pictures, "e","Vinit", 1);
		File f = new File(pictures, "f","Vinit", 1);
		fs.setRootDirectory(root);
		root.appendChild(home);
		root.appendChild(system);
		system.appendChild(a);
		system.appendChild(b);
		system.appendChild(c);
		home.appendChild(pictures);
		home.appendChild(d);
		pictures.appendChild(e);
		pictures.appendChild(f);

		root.getSize();
		int expected = 6;
		int actual = root.getSize();
		assertThat(actual,is(expected));
	}
}
