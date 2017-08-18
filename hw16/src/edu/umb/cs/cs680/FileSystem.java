package edu.umb.cs.cs680;
import java.util.ArrayList;
import java.util.Comparator;

public class FileSystem 
{

	private Comparator<FSElement> comparator;
	private ArrayList<FSElement> children;
	private Directory rootDirectory;
	private static FileSystem instance = null;
	private Directory current;

	private FileSystem()
	{
		comparator = new AlphabeticalComparator();
	}

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

	public Directory getRootDirectory()
	{
		return this.rootDirectory;
	}

	public void setCurrentDirectory(Directory current)
	{
		this.current = current;
	}

	public Directory getCurrentDirectory()
	{
		return this.current;
	}

	public void addChild(Directory parent, FSElement child)
	{
		parent.addChild(child, getInsertionLocation(parent, child));
	}

	public int getInsertionLocation(Directory dir, FSElement element) 
	{	
		children = new ArrayList<FSElement>();
		children = dir.getChildren();
		children.add(element);
		children.sort(comparator);
		return children.indexOf(element);
	}

	public ArrayList<FSElement> sort(Directory dir,Comparator<FSElement> comparator)
	{
		children = new ArrayList<FSElement>();
		children = dir.getChildren();
		children.sort(comparator);
		return children;
	}
	
	public ArrayList<FSElement> getChildren(Directory current)
	{
		ArrayList<FSElement> children = new ArrayList<FSElement>();
		children = current.getChildren();
		children.sort(this.comparator);
		return children;
	}

	public void accept(FSVisitor v)
	{
		rootDirectory.accept(v);
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

		if(element instanceof Link)
		{
			Link link = (Link) element;
			System.out.println("Name:"+link.getName()+
					" Owner: "+link.getOwner()+
					" Date Created: "+link.getDateCreated()+
					" Date Modified: "+link.getLastModifiedDate()+
					" Size: "+link.getSize());
			System.out.println("This is link to "+link.getProxy().getName());
		}

		else if(element.isFile() == false)
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
		fs.showAllElements();

		FileSearchVisitor visitor = new FileSearchVisitor(".txt");
		root.accept(visitor);
		System.out.println("\n This is FileSearchVisitor");
		System.out.println("No of files found with extension");
		System.out.println(visitor.getFoundFiles().size());

		SizeCountingVisitor visitor1 = new SizeCountingVisitor();
		root.accept(visitor1);
		System.out.println("\n This is SizeCountingVisitor");
		System.out.println("Total Size After Counting");
		System.out.println(visitor1.getTotalSize());

		CountingVisitor visitor2 = new CountingVisitor();
		root.accept(visitor2);
		System.out.println("\n This is CountingVisitor");
		System.out.println("Total Directories");
		System.out.println(visitor2.getDirNum());
		System.out.println("Total Files");
		System.out.println(visitor2.getFileNum());
		System.out.println("Total Links");
		System.out.println(visitor2.getLinkNum());

		Shell shell = new Shell();
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
		shell.execute(c5);
		
		fs.sort(root, new AlphabeticalComparator());

		fs.sort(home, new TimeStampComparator());

	}
}
