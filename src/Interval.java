
public class Interval {

	public String interval;
	public boolean oriented;
	
	public Interval()
	{
		
	}
	
	public Interval(String interval)
	{
		this.interval = interval;
		
		String[] intervalHolder = interval.split(" ");
		String start = intervalHolder[0];
		String end = intervalHolder[intervalHolder.length-1];

		Boolean startSign = true;
		if(start.contains("-"))
			startSign = false;
		
		Boolean endSign = true;
		if(end.contains("-"))
			endSign = false;
		
		// start	end		oriented
		// true		true	false
		// true		false	true
		// false	false	false
		
		this.oriented = false;
		
		// Set (true, true) & (false, true) to be oriented = true
		if(startSign || endSign)
			this.oriented = true;
		
		// Set (true, true) to be oriented = false
		if(startSign && endSign)
			this.oriented = false;
	}
	
}
