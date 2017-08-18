package edu.umb.cs.cs680;

public class Shell 
{
	private CommandHistory commandhistory;

	public Shell()
	{
		commandhistory = CommandHistory.getInstance();
	}

	public void execute(Command command)
	{
		commandhistory.push(command);
		String result = command.execute();
		System.out.println(result);
	}

}
