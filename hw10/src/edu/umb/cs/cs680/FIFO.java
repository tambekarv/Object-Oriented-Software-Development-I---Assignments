package edu.umb.cs.cs680;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class FIFO implements CacheReplacementPolicy
{
	private static FIFO instance = null;
	
	private FIFO(){}
	
public static FIFO getInstace()
	{
		if(instance == null) 
		{
            instance = new FIFO();
        }
        return instance;
	}
	
	@Override
	public void replace(LinkedHashMap<String, File> cache, File targetFile) 
	{
		Object key  = cache.keySet().iterator().next();
		//Object value = cache.get(key);
		cache.remove(key);
		cache.put((String) key, targetFile);
		System.out.println("cache replaced");
		System.out.println(key+" is replaced by "+targetFile);
	}
}