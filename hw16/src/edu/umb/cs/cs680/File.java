package edu.umb.cs.cs680;

public class File extends FSElement 
{

	public File(Directory parent, String name, String owner, int size) 
	{
		super(parent, name, owner, size, true);
	}

	public void accept(FSVisitor v)
	{
		v.visit(this);
	}

	public int getDiskUtil() 
	{
		return getSize();
	}
}
