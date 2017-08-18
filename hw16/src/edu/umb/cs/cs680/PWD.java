package edu.umb.cs.cs680;

public class PWD implements Command
{
	private FileSystem fs; 
	
	public PWD()
	{
		fs = FileSystem.getFileSystem();
	}
	
	@Override
	public String execute() 
	{
		return fs.getCurrentDirectory().getName();
	}
}
