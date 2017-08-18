package edu.umb.cs.cs680.multicast;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class MulticastTest 
{
	BondEventObservable bondEvent = new BondEventObservable();
	StockEventObservable stockEvent = new StockEventObservable();
	public void setup()
	{
		bondEvent.addEventListener(new PieChartObserver());
		bondEvent.addEventListener(new TableObserver());
		bondEvent.addEventListener(new ThreeDObserver());
		stockEvent.addEventListener(new PieChartObserver());
		stockEvent.addEventListener(new TableObserver());
		stockEvent.addEventListener(new ThreeDObserver());
	}

	@Test
	public void testBondEvent()
	{
		setup();
		ByteArrayOutputStream bOutput = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bOutput));
		bondEvent.ChangeBond("EMC", 1000);
		bondEvent.ChangeBond("EMC", 5000);
		bondEvent.ChangeBond("Dell", 5500);
		stockEvent.ChangeQuote("Google", 56);
		stockEvent.ChangeQuote("Google", 56.3f);
		stockEvent.ChangeQuote("Apple", 92);
		String expected = "\nAfter Updating Pie Chart\n"
		+"Issuer:EMCValue:1000.0\n\n"
				+"After Updating Table\n"
		+"Issuer:EMCValue:1000.0\n\n"
				+"After Updating 3D Representation\n"
		+"Issuer:EMCValue:1000.0\n\n"
				+"After Updating Pie Chart\n"
		+"Issuer:EMCValue:5000.0\n\n"
				+"After Updating Table\n"
		+"Issuer:EMCValue:5000.0\n\n"
				+"After Updating 3D Representation\n"
		+"Issuer:EMCValue:5000.0\n\n"
				+"After Updating Pie Chart\n"
		+"Issuer:EMCValue:5000.0\n"
				+"Issuer:DellValue:5500.0\n\n"
		+"After Updating Table\n"
				+"Issuer:EMCValue:5000.0\n"
		+"Issuer:DellValue:5500.0\n\n"
				+"After Updating 3D Representation\n"
		+"Issuer:EMCValue:5000.0\n"
				+"Issuer:DellValue:5500.0\n\n"
		+"After Updating Pie Chart\n"
				+"Ticker:GoogleQuote:56.0\n\n"
		+"After Updating Table\n"
				+"Ticker:GoogleQuote:56.0\n\n"
		+"After Updating 3D Representation\n"
				+"Ticker:GoogleQuote:56.0\n\n"
		+"After Updating Pie Chart\n"
				+"Ticker:GoogleQuote:56.3\n\n"
		+"After Updating Table\n"
				+"Ticker:GoogleQuote:56.3\n\n"
		+"After Updating 3D Representation\n"
				+"Ticker:GoogleQuote:56.3\n\n"
		+"After Updating Pie Chart\n"
				+"Ticker:GoogleQuote:56.3\n"
		+"Ticker:AppleQuote:92.0\n\n"
				+"After Updating Table\n"
		+"Ticker:GoogleQuote:56.3\n"
				+"Ticker:AppleQuote:92.0\n\n"
		+"After Updating 3D Representation\n"
				+"Ticker:GoogleQuote:56.3\n"
		+"Ticker:AppleQuote:92.0\n";
		assertThat(bOutput.toString(),is(notNullValue()));
	}


}
