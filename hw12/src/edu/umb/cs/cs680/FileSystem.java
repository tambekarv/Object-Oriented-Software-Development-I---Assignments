package edu.umb.cs.cs680;
import java.util.ArrayList;

public class FileSystem 
{

	private Directory rootDirectory;
	private static FileSystem instance = null;

	private FileSystem(){}


	public static FileSystem getFileSystem()
	{
		if(instance == null) 
		{
			instance = new FileSystem();
		}
		return instance;
	}

	public void setRootDirectory(Directory rootDirectory)
	{
		this.rootDirectory = rootDirectory;
	}


	public void showAllElements()
	{
		if(rootDirectory == null)
		{
			System.out.println("File System is Empty");
		}
		else
		{
			System.out.println("Name  owner  created  modified  size");
			System.out.println("\n");
			display(rootDirectory);
		}
	}


	private void display(FSElement element) 
	{
		if(element.isFile() == false)
		{
			Directory directory = (Directory) element;
			System.out.println("Name:"+directory.getName()+
					" Owner: "+directory.getOwner()+
					" Date Created: "+directory.getDateCreated()+
					" Date Modified: "+directory.getLastModifiedDate()+
					" Size: "+directory.getSize());
			ArrayList<FSElement> e = directory.getChildren();	
			for(int i = 0; i< e.size(); i++)
			{
				display(e.get(i));
			}		
		}
		else
		{
			System.out.println("Name:"+element.getName()+
					" Owner: "+element.getOwner()+
					" Date Created: "+element.getDateCreated()+
					" Date Modified: "+element.getLastModifiedDate()+
					" Size: "+element.getSize());
		}

	}

	public static void main(String args[])
	{
		FileSystem fs = getFileSystem();

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
		fs.setRootDirectory(root);
		root.appendChild(home);
		root.appendChild(system);
		system.appendChild(a);
		system.appendChild(b);
		system.appendChild(c);
		home.appendChild(pictures);
		home.appendChild(d);
		pictures.appendChild(e);
		pictures.appendChild(f);
	
		fs.showAllElements();
	}
}
