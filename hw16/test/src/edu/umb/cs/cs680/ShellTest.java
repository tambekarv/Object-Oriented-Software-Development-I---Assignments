package edu.umb.cs.cs680;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class ShellTest {
	private FileSystem fs;
	private Directory root;
	private Directory system;
	private Shell shell = new Shell();
	
	public void setup()
	{
		fs = FileSystem.getFileSystem();

		root = new Directory(null, "root", "Vinit");
		Directory home = new Directory(root,"home","Vinit");
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
	public void testShell()
	{
		setup();
		Command c = new CD(system);
		shell.execute(c);
		Directory expected = system;
		Directory actual = fs.getCurrentDirectory();
		assertThat(actual,is(expected));
	}
	
}
