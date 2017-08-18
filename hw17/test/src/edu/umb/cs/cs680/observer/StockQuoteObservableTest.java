package edu.umb.cs.cs680.observer;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class StockQuoteObservableTest {
	StockQuoteObservable stockObservable = new StockQuoteObservable();
	
	public void setup()
	{
		stockObservable.addObserver(new TableObserver());
		stockObservable.addObserver(new PieChartObserver());
		stockObservable.addObserver(new ThreeDObserver());
	}
	
	@Test
	public void testObserver()
	{
		setup();
		ByteArrayOutputStream bOutput = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bOutput));
		stockObservable.ChangeQuote("Google",56);
		stockObservable.ChangeQuote("Google", 56.3f);
		stockObservable.ChangeQuote("Apple", 92);
		String expected = "\nAfter Updating 3D Representation\n"
		+"Ticker:Google Quote:56.0\n\n"
				+"After Updating Pie Chart\n"
		+"Ticker:Google Quote:56.0\n\n"
				+"After Updating Table\n"
		+"Ticker:Google Quote:56.0\n\n"
				+"After Updating 3D Representation\n"
		+"Ticker:Google Quote:56.3\n\n"
				+"After Updating Pie Chart\n"
		+"Ticker:Google Quote:56.3\n\n"
				+"After Updating Table\n"
		+"Ticker:Google Quote:56.3\n\n"
				+"After Updating 3D Representation\n"
		+"Ticker:Google Quote:56.3\n"
				+"Ticker:Apple Quote:92.0\n\n"
		+"After Updating Pie Chart\n"
				+"Ticker:Google Quote:56.3\n"
		+"Ticker:Apple Quote:92.0\n\n"
				+"After Updating Table\n"
		+"Ticker:Google Quote:56.3\n"
				+"Ticker:Apple Quote:92.0\n";
		assertThat(bOutput.toString(),is(notNullValue()));
	}
}
