package edu.umb.cs.cs680;

public class CD implements Command
{
	private FileSystem fs = FileSystem.getFileSystem();
	private Directory current;
	
	public CD(Directory dir)
	{
		//this.fs = FileSystem.getFileSystem();	
		this.current = dir;
	}

	public CD()
	{
		
		this.current = fs.getRootDirectory();
		//	fs = FileSystem.getFileSystem();
		//fs.setCurrentDirectory(fs.getRootDirectory());
	}

	@Override
	public String execute() {
		fs.setCurrentDirectory(current);
		return fs.getCurrentDirectory().getName();
	}
	
}
