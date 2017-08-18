package edu.umb.cs.cs680;
import java.util.ArrayList;

public class LS implements Command{

	private FileSystem fs;
	
	public LS()
	{
		fs = FileSystem.getFileSystem();
	}
	
	@Override
	public String execute() 
	{	
		Directory current = fs.getCurrentDirectory();
		ArrayList<FSElement> children = current.getChildren();
		for(int i=0; i<children.size();i++)
		{
			System.out.println(children.get(i).getName());
		}
	//	return "Files in directory\t"+ current.getName() +"\tare listed above";
		return " ";
		
	}

}
