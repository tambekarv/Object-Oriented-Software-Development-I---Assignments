package edu.umb.cs.cs680;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;


public class CommandHistoryTest {

	CommandHistory commandHistory = CommandHistory.getInstance();
	
	@Test
	public void testCommandHistory()
	{
		Command list = new LS();
		commandHistory.push(list);
		Command expected = commandHistory.pop();
		assertThat(list, is(expected));
	}
	
}
