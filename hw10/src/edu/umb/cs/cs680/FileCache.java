package edu.umb.cs.cs680;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class FileCache 
{
	
	private static FileCache instance ;
	private CacheReplacementPolicy replacementPolicy;
	private LinkedHashMap<String, File> cache;
	
	
	
	
	private  FileCache() 
	{
		replacementPolicy = FIFO.getInstace();
		cache = new LinkedHashMap<String, File>();
	}
/*
	public void getPolicy()
	{
		this.replacementPolicy = replacementPolicy; 
		
	}
*/	
	
	public static FileCache getInstance() 
	{
		if(instance == null)
			{
				instance = new FileCache();
			}
		return instance;
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
				FiletoString(file);
			}
			else if(cache.size() == 3) 
			{
				replace(file);
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
				
					//char c = (char) content;
				}
				System.out.println("\n");
			} 
			catch (FileNotFoundException e) 
			{
				System.err.println("File not available");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	
	}

	private void replace(File targetFile)
	{
		// FIFO.getInstace().replace(cache, targetFile);
		//replacementPolicy.replace(cache, targetFile);
		replacementPolicy.replace(cache, targetFile);
	}

	public static void main(String args[]) throws FileNotFoundException 
	{
		instance = getInstance();
		
		String file1 = "src/vinit";
//		File f1 = new File(file1);
		instance = FileCache.getInstance();
		instance.fetch(file1);
	
		String a = "src/a";
		//File f2 = new File(a);
		instance = FileCache.getInstance();
		instance.fetch(a);
	
		String b = "src/b";
		instance.fetch(b);
				
		String c = "src/c";
		//File f4 = new File(c);
		instance = FileCache.getInstance();
		instance.fetch(c);
		
		
	/*	String v = "src/v";
		//File f3 = new File(v);
		instance = FileCache.getInstance();
		instance.fetch(v);
	
		String d = "src/d";
		instance.fetch(d); */
	
	}
}