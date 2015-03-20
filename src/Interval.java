
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
		
		String startSign = start.substring(0);
		String endSign = end.substring(0);
		
		Boolean startPos = true;
		if(startSign.equals("-"))
			startPos = false;
		
		Boolean endPos = true;
		if(endSign.equals("-"))
			endPos = false;
		
		// start	end		oriented
		// true		true	false
		// true		false	true
		// false	false	false
		
		this.oriented = false;
		
		// Set (true, true) & (false, true) to be oriented = true
		if(startPos || endPos)
			this.oriented = true;
		
		// Set (true, true) to be oriented = false
		if(startPos && endPos)
			this.oriented = false;
	}
	
}
