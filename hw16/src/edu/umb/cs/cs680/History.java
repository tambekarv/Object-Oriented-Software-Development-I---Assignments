package edu.umb.cs.cs680;
import java.util.Stack;

public class History implements Command 
{
	private CommandHistory history;
	private Stack<Command> commands;
	
	public History()
	{
		history = CommandHistory.getInstance();
		commands = new Stack<Command>();
	}
	
	@Override
	public String execute() 
	{
		this.commands = history.getHistory();
		
		while(!commands.isEmpty())
		{
			Command c = commands.pop();
			//System.out.println(c.getClass().getName());
			System.out.println(c.getClass().getSimpleName());
		}
		
		return " ";
	}

}
