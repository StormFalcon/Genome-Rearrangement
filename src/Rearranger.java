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
		// Tester code to show mappedSource
		System.out.println(mappedSource);
		
		String[] sourceHolder = mappedSource.split(" ");
		Interval[] intervalHolder = new Interval[sourceHolder.length];
		
		// Make artificial sourceHolder
		String[] duplicateSourceHolder = new String[sourceHolder.length+2];
		Integer artificialStart = 0;
		Integer artificialEnd = sourceHolder.length+1;
		
		// Tester code to check artificial start and end value
		System.out.println("Artificial: " + artificialStart + " " + artificialEnd);
		
		// duplicate sourceHolder to artificial sourceHolder
		duplicateSourceHolder[0] = artificialStart.toString();
		duplicateSourceHolder[duplicateSourceHolder.length-1] = artificialEnd.toString();
		
		for(int i=0, j=1; i<sourceHolder.length; i++, j++)
		{
			duplicateSourceHolder[j] = sourceHolder[i];
		}
		
		////////////////////////////////////////////////////////////////////
		/** DuplicateSourceHolder not used, but things are working correctly
		 * 	Possible logic error, need more checking here **/
		////////////////////////////////////////////////////////////////////
		
		Integer start = 0;
		Integer next = start + 1;
		
		for(int i=0; i<sourceHolder.length; i++)
		{
			// Look for start and next
			String strStart = start.toString();
			int startIndex = 0;

			String strNext = next.toString();
			int endIndex = 0;			
			
			for(int j=0; j<sourceHolder.length; j++)
			{
				String element = sourceHolder[j];

				// Remove negative sign if there
				if(element.contains("-"))
				{	
					element = element.substring(1);
				}
					
				if(element.equals(strStart))
				{
					startIndex = j;
				}
				
				if(element.equals(strNext))
				{
					endIndex = j;
				}
			}
			
			//System.out.println(startIndex + " " + endIndex);
			
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
			
			// Tester Code
			System.out.println(i);
			System.out.println(interval.interval);
			System.out.println(interval.oriented);
			System.out.println("------------------------");
			
			
			intervalHolder[i] = interval;
			/************ WORK IN PROGRESS ************/

			// Increment start and next
			start++;
			next++;
		}
		System.exit(0);
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
