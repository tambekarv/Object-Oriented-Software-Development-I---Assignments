package edu.umb.cs.cs680;
import java.util.Stack;

public class CommandHistory 
{
	private Stack<Command> commands;
	private static CommandHistory instance;
	
	private CommandHistory()
	{
		commands = new Stack<Command>();
	}

	public static CommandHistory getInstance()
	{
		if(instance == null)
		{
			instance = new CommandHistory();
		}
		return instance;
	}
	
	public void push(Command command)
	{
		this.commands.push(command);
	}

	public Command pop()
	{
		Command command = this.commands.pop();
		return command;
	}

	public Stack<Command> getHistory()
	{
		return this.commands;
	}
	
}
