import java.lang.reflect.Array;


public class Rearranger {

	Genome source;
	Genome target;
	
	public Rearranger(Genome source, Genome target)
	{
		this.source = source;
		this.target = target;
	}
	
	//////////////////////////////////////////////////////////////////////
	// Under construction
	//////////////////////////////////////////////////////////////////////
	public int rearrange()
	{
		String sourceGenome = this.source.genome;
		String targetGenome = this.target.genome;
		
		if(sourceGenome.equals(targetGenome))
			return 0;
		else
		{
			int count = 0;
			
			Mapper mapper = new Mapper(sourceGenome, targetGenome);
			
			String mappedSource = mapper.mappedSource;
			String mappedTarget = mapper.mappedTarget;
			
			// Tester Code
			//System.out.println(mappedSource);
			//System.out.println(mappedTarget);
		
			Interval[] intervalHolder = findInterval(mappedSource);
			
			
			
			/************ WORK IN PROGRESS ************/
			
			//ArrayList<Component> sourceComponent = findComponents(mappedSource);
			//ArrayList<Component> targetComponent = findComponents(mappedTarget);
			
			
			
			return count;
		}
	}
	
	public Interval[] findInterval(String mappedSource)
	{
		String[] sourceHolder = mappedSource.split(" ");
		Interval[] intervalHolder = new Interval[sourceHolder.length];
		
		Integer start = 1;
		Integer next = start + 1;
		
		/************ NOTE TO SELF: check last interval next value ************/
		for(int i=0; i<sourceHolder.length; i++)
		{
			// Look for start and next
			String strStart = start.toString();
			int startIndex = 0;

			String strNext = next.toString();
			int endIndex = 0;			
			
			for(int j=0; j<sourceHolder.length; j++)
			{
				String element = sourceHolder[i];
				
				// Remove negative sign if there
				if(element.contains("-"))
					element = element.substring(1);
				
				if(element.equals(strStart))
				{
					startIndex = j;
				}
				
				if(element.equals(strNext))
				{
					endIndex = j;
				}
			}
			
			// Determine order
			int buildStartIndex = 0; 
			int buildEndIndex = 0;
			
			if(startIndex < endIndex)
			{
				buildStartIndex = startIndex;
				buildEndIndex = endIndex;
			}
			
			if(startIndex > endIndex)
			{
				buildStartIndex = endIndex;
				buildEndIndex = startIndex;
			}
			
			
			// Form Interval Object
			String strInterval = sourceHolder[buildStartIndex];
			
			for(int j=buildStartIndex+1; j<=buildEndIndex; j++)
			{
				strInterval = strInterval + " " + sourceHolder[j];
			}
			
			Interval interval = new Interval(strInterval);
			
			intervalHolder[i] = interval;
			/************ WORK IN PROGRESS ************/
			
			// Increment start and next
			start++;
			next++;
		}
		
		return intervalHolder;
	}
/**	
	public ArrayList<Component> findComponents(String sequence) 
	{
		ArrayList<Component> componentList = null;
		
		return componentList;
	}
**/
}
