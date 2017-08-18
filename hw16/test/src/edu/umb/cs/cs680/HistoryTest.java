package edu.umb.cs.cs680;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class HistoryTest {
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
	public void testHistory()
	{
		setup();
		fs.setCurrentDirectory(home);

		Command c1 = new PWD();
		System.out.println("\n This is PWD");
		shell.execute(c1);

		Command c2 = new CD(system);
		System.out.println("\n This is CD");
		shell.execute(c2);

		Command c3 = new LS();
		System.out.println("\n This is LS");
		shell.execute(c3);

		Command c4 = new CD();
		System.out.println("\n Changing current directory to root directory");
		shell.execute(c4);

		Command c5 = new History();
		System.out.println("\n This is command history");
		ByteArrayOutputStream bOutput = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bOutput));
		shell.execute(c5);
		String expected = "History\nCD\nLS\nCD\nPWD\n \n";
		assertThat(bOutput.toString(),is(notNullValue()));
	}
}
