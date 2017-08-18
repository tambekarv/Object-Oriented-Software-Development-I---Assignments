package edu.umb.cs.cs680;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;

public class FileCacheTest {

	private FileCache cache;
	private CacheReplacementPolicy replacementPolicy;

	@Test
	public void testEnterFileIntoCache() throws FileNotFoundException
	{
		cache = FileCache.getInstance();
		String file1 = "src/vinit";
		String actual = cache.fetch(file1); 
		String expected = "src/vinit";
		assertThat(actual,is(expected));
	}

	@Test
	public void testFilePresentInCache() throws FileNotFoundException
	{
		cache = FileCache.getInstance();
		String file1 = "src/vinit";
		cache.fetch(file1);
		String file2 = "src/a";
		cache.fetch(file2);
		String file3 = "src/b";
		cache.fetch(file3);

		String actual = cache.fetch(file1);
		String expected = "src/vinit";
		assertThat(actual,is(expected));
	}

	@Test
	public void testFileReplaceSuccess() throws FileNotFoundException
	{
		cache = FileCache.getInstance();
		String file1 = "src/vinit";
		cache.fetch(file1);
		String file2 = "src/a";
		cache.fetch(file2);
		String file3 = "src/b";
		cache.fetch(file3);

		String file4 = "src/c";
		String actual = cache.fetch(file4);
		String expected = "src/c";
		assertThat(actual ,is(expected));
	}

	@Test(expected = FileNotFoundException.class)
	public void testFileNotFound() throws FileNotFoundException
	{
		cache = FileCache.getInstance();
		String file1 = "src/v";
		cache.fetch(file1);
	}
}
