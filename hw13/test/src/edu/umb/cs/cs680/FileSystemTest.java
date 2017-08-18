package edu.umb.cs.cs680;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class FileSystemTest 
{
	@Test
	public void testShowAllElements()
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
		fs.showAllElements();


		ByteArrayOutputStream bOutput = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bOutput));
		fs.showAllElements();
		String expected = "Name  owner  created  modified  size\n\n\n"
				+"Name:root Owner: Vinit Date Created: Wed Dec 31 19:00:00 EST 1969 Date Modified: Wed Dec 31 19:00:00 EST 1969 Size: 8\n"
				+"Name:home Owner: Vinit Date Created: Wed Dec 31 19:00:00 EST 1969 Date Modified: Wed Dec 31 19:00:00 EST 1969 Size: 5\n"
				+"Name:pictures Owner: Vinit Date Created: Wed Dec 31 19:00:00 EST 1969 Date Modified: Wed Dec 31 19:00:00 EST 1969 Size: 3\n"
				+"Name:e Owner: Vinit Date Created: Wed Dec 31 19:00:00 EST 1969 Date Modified: Wed Dec 31 19:00:00 EST 1969 Size: 1\n"
				+"Name:f Owner: Vinit Date Created: Wed Dec 31 19:00:00 EST 1969 Date Modified: Wed Dec 31 19:00:00 EST 1969 Size: 1\n"
				+"Name:y Owner: Vinit Date Created: Wed Dec 31 19:00:00 EST 1969 Date Modified: Wed Dec 31 19:00:00 EST 1969 Size: 1\n"
				+"This is link to e\n"
				+"Name:d Owner: Vinit Date Created: Wed Dec 31 19:00:00 EST 1969 Date Modified: Wed Dec 31 19:00:00 EST 1969 Size: 1\n"
				+"Name:x Owner: Vinit Date Created: Wed Dec 31 19:00:00 EST 1969 Date Modified: Wed Dec 31 19:00:00 EST 1969 Size: 1\n"
				+"This is link to system\n"
				+"Name:system Owner: Vinit Date Created: Wed Dec 31 19:00:00 EST 1969 Date Modified: Wed Dec 31 19:00:00 EST 1969 Size: 3\n"
				+"Name:a Owner: Vinit Date Created: Wed Dec 31 19:00:00 EST 1969 Date Modified: Wed Dec 31 19:00:00 EST 1969 Size: 1\n"
				+"Name:b Owner: Vinit Date Created: Wed Dec 31 19:00:00 EST 1969 Date Modified: Wed Dec 31 19:00:00 EST 1969 Size: 1\n"
				+"Name:c Owner: Vinit Date Created: Wed Dec 31 19:00:00 EST 1969 Date Modified: Wed Dec 31 19:00:00 EST 1969 Size: 1\n";

		assertThat(bOutput.toString(),is(notNullValue()));
	}	
}