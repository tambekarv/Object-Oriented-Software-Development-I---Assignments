package edu.umb.cs.cs680;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class ComparatorsTest 
{
	private FileSystem fs;
	private Directory root;
	private Directory system;
	private Directory home;
	private Shell shell = new Shell();

	public void setup()
	{
		fs = FileSystem.getFileSystem();

		root = new Directory(null, "root", "Vinit");
		home = new Directory(root,"home","Vinit");
		system = new Directory(root,"system","Vinit");
		Directory pictures = new Directory(home,"pictures","Vinit");
		File a = new File(system, "a.txt", "Vinit", 1);
		File b = new File(system, "b","Vinit", 1);
		File c = new File(system, "c","Vinit",1);
		File d = new File(home, "d.txt","Vinit", 1);
		File e = new File(pictures, "e","Vinit", 1);
		File f = new File(pictures, "f","Vinit", 1);
		Link x = new Link(home, "x", system, "Vinit", 1, false);
		Link y = new Link(pictures, "y", e,"Vinit", 1, false);
		fs.setRootDirectory(root);
		root.appendChild(home);
		root.appendChild(system);
		system.appendChild(a);
		system.appendChild(b);
		system.appendChild(c);
		home.appendChild(pictures);
		home.appendChild(d);
		home.appendChild(x);
		pictures.appendChild(e);
		pictures.appendChild(f);
		pictures.appendChild(y);		
	}

	@Test
	public void testAlphabeticalComparator()
	{
		setup();
		ArrayList<FSElement> children = new ArrayList<FSElement>();
		children = system.getChildren();
		assertThat(children,is(fs.getChildren(system)));
	}

	@Test
	public void testTimeStampComparator()
	{
		setup();
		ArrayList<FSElement> children = new ArrayList<FSElement>();
		children = home.getChildren();
		assertThat(children,is(fs.sort(home, new TimeStampComparator())));
	}
	
	/*@Test
	public void testReverseAlphabeticalComparator()
	{
		setup();
		ArrayList<FSElement> children = new ArrayList<FSElement>();
		children = home.getChildren();
		assertThat(children,is(fs.sort(home, new ReverseAlphabeticalComparator())));
	}*/
	
}