package edu.umb.cs.cs680;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Set;

public abstract class FileCache 
{
	private LinkedHashMap<String, File> cache;

	public FileCache() 
	{
		cache = new LinkedHashMap<String, File>();
	}

	public String fetch(String targetFile) throws FileNotFoundException
	{	
		File file = new File(targetFile);
		Set<String> keyset = this.cache.keySet();
		if(file.exists())
		{	
			if (keyset.contains(targetFile)) 
			{
				file = this.cache.get(targetFile);
				System.out.println("Cache contains this file");
				FiletoString(file);
			} 
			else if(cache.size() != 3)
			{
				cache.put(targetFile, file);
				System.out.println("File Cached");
				FiletoString(file);
			}
			else if(cache.size() == 3) 
			{
				replace(cache,file);
			}
		}	
		else
		{
			throw new FileNotFoundException("File does not exist");	
		}
		return targetFile;
	}

	private void FiletoString(File file) throws FileNotFoundException 
	{
		try 
		{
			FileInputStream fis = new FileInputStream(file);
			int content;		
			while ((content = fis.read()) != -1) 
			{
				System.out.print((char) content);
			}
			System.out.println("\n");
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println("File not available");
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}

	public abstract void replace(LinkedHashMap<String,File>cache,File targetFile);

	public abstract String fileFetch(String targetFile) throws FileNotFoundException;
	
}