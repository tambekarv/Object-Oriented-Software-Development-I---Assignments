package edu.umb.cs.cs680;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;

public class FIFO extends FileCache 
{
	private static FIFO instance = null;
	private String targetFile;
	private FIFO(){}

	public static FIFO getInstance()
	{
		if(instance == null) 
		{
			instance = new FIFO();
		}
		return instance;
	}

	@Override
	public void replace(LinkedHashMap<String, File> cache,File targetFile) {
		Object key  = cache.keySet().iterator().next();
		cache.remove(key);
		cache.put((String) key, targetFile);
		System.out.println("cache replaced");
		System.out.println(key+" is replaced by " +targetFile);
	}

	@Override
	public String fileFetch(String targetFile)  throws FileNotFoundException
	{
		super.fetch(targetFile);
		return targetFile;
	}

	public static void main(String args[]) throws FileNotFoundException 
	{
		String file1 = "src/vinit";
		instance = FIFO.getInstance();
		instance.fetch(file1);

		String file2 = "src/a";
		instance = FIFO.getInstance();
		instance.fetch(file2);

		String file3 = "src/b";
		instance = FIFO.getInstance();
		instance.fetch(file3);

		String file4 = "src/c";
		instance = FIFO.getInstance();
		instance.fetch(file4);

		/*String file5 = "src/d";
		instance = FIFO.getInstance();
		instance.fetch(file5);
		 */
	}


}