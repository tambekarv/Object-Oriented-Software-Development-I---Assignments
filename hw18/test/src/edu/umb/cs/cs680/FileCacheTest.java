package edu.umb.cs.cs680;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import java.io.FileNotFoundException;

public class FileCacheTest {

	private FIFO instance = FIFO.getInstance();
	
	@Test
	public void testEnterFileIntoCache() throws FileNotFoundException
	{
		String file1 = "src/vinit";
		String actual = instance.fileFetch(file1); 
		String expected = "src/vinit";
		assertThat(actual,is(expected));
	}

	@Test
	public void testFilePresentInCache() throws FileNotFoundException
	{
		String file1 = "src/vinit";
		instance.fileFetch(file1);
		String file2 = "src/a";
		instance.fileFetch(file2);
		String file3 = "src/b";
		instance.fileFetch(file3);

		String actual = instance.fileFetch(file1);
		String expected = "src/vinit";
		assertThat(actual,is(expected));
	}

	@Test
	public void testFileReplaceSuccess() throws FileNotFoundException
	{
		String file1 = "src/vinit";
		instance.fileFetch(file1);
		
		String file2 = "src/a";
		instance.fileFetch(file2);
		
		String file3 = "src/b";
		instance.fileFetch(file3);
		
		String file4 = "src/c";
		String actual = instance.fileFetch(file4);
		
		String expected = "src/c";
		assertThat(actual ,is(expected));
	}

	@Test(expected = FileNotFoundException.class)
	public void testFileNotFound() throws FileNotFoundException
	{
		String file1 = "src/v";
		instance.fileFetch(file1);
	}
}
