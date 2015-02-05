import java.util.Arrays;


public class Mapper {

	String originalSource;
	String originalTarget;
	String mappedSource;
	String mappedTarget;
	
	public Mapper(String originalSource, String originalTarget)
	{
		this.originalSource = originalSource;
		this.originalTarget = originalTarget;
		Pair pair = map();
		this.mappedSource = pair.source;
		this.mappedTarget = pair.target;
		
		System.out.println("OS: " + this.originalSource);
		System.out.println("OT: " + this.originalTarget);
		System.out.println("MS: " + this.mappedSource);
		System.out.println("MT: " + this.mappedTarget);
	}

	public Pair map()
	{
		// Make mappedTargetGenome
		String newTarget = makeTargetGenome();
		
		// Make mappedSourceGenome
		String newSource = makeSourceGenome();
		
		Pair pair = new Pair(newSource, newTarget);
		
		return pair;
	}
	
	public String makeSourceGenome()
	{
		String newSource = null;
		
		String[] mapHolder = this.originalTarget.split(" ");
		
		// TRUE for positive
		// False for negative
		Boolean[] signHolder = new Boolean[mapHolder.length];
		Arrays.fill(signHolder, Boolean.TRUE);
		
		for(int i=0; i<mapHolder.length; i++)
		{
			String element = mapHolder[i];
			
			if(element.contains("-"))
			{
				signHolder[i] = false;
				element = element.substring(1);
				mapHolder[i] = element;
			}
		}
		
		String[] oldSourceHolder = this.originalSource.split(" ");
		String[] newSourceHolder = new String[oldSourceHolder.length];
		
		for(int i=0; i<oldSourceHolder.length; i++)
		{
			String oldElement = oldSourceHolder[i];
			Boolean oldSign = true;
			if(oldElement.contains("-"))
			{
				oldSign = false;
				oldElement = oldElement.substring(1);
			}
			
			Integer index = 0;
			for(int j=0; j<mapHolder.length; j++)
			{
				String newElement = mapHolder[j];
				if(newElement.equals(oldElement))
				{
					index = j;
					break;
				}
			}
			
			String newElement = mapHolder[index];
			Boolean newSign = signHolder[index];
			
			// String oldElement
			// Boolean oldSign
			
			Integer newValue = index + 1;
			Boolean flip = false;
			if(oldSign != newSign)
			{
				flip = true;
			}
			
			
			String value = newValue.toString();
		
			if(flip)
			{
				value = "-" + value;
			}
			
			newSourceHolder[i] = value;
		}
		
		newSource = newSourceHolder[0];
		for(int i=1; i<newSourceHolder.length; i++)
		{
			newSource = newSource + " " + newSourceHolder[i];
		}
		
		return newSource;
	}
	
	public String makeTargetGenome()
	{
		int genomeSize = this.originalTarget.split(" ").length;
		String[] mappedTargetHolder = new String[genomeSize];
		for(Integer i=0, index=1; i<genomeSize; i++, index++)
		{
			mappedTargetHolder[i] = index.toString();
		}
		
		String newTarget = mappedTargetHolder[0];
		
		for(int i=1; i<genomeSize; i++)
		{
			newTarget = newTarget + " " + mappedTargetHolder[i];
		}
		
		return newTarget;
	}
}
