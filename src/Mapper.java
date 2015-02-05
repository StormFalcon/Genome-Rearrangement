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
		String mappedSource = null;
		
		String[] originalTargetHolder = this.originalTarget.split(" ");
		
		// TRUE for positive
		// False for negative
		Boolean[] signOriginalTargetHolder = new Boolean[originalTargetHolder.length];
		Arrays.fill(signOriginalTargetHolder, Boolean.TRUE);
		
		for(int i=0; i<originalTargetHolder.length; i++)
		{
			String originalTargetElement = originalTargetHolder[i];
			
			if(originalTargetElement.contains("-"))
			{
				signOriginalTargetHolder[i] = false;
				originalTargetElement = originalTargetElement.substring(1);
				originalTargetHolder[i] = originalTargetElement;
			}
		}
		
		String[] originalSourceHolder = this.originalSource.split(" ");
		String[] mappedSourceHolder = new String[originalSourceHolder.length];
		
		for(int i=0; i<originalSourceHolder.length; i++)
		{
			String originalSourceElement = originalSourceHolder[i];
			Boolean signOriginalSource = true;
			if(originalSourceElement.contains("-"))
			{
				signOriginalSource = false;
				originalSourceElement = originalSourceElement.substring(1);
			}
			
			Integer positionIndex = 0;
			
			for(int j=0; j<originalTargetHolder.length; j++)
			{
				String originalTargetElement = originalTargetHolder[j];
				if(originalTargetElement.equals(originalSourceElement))
				{
					positionIndex = j;
					break;
				}
			}
			
			Boolean newSign = signOriginalTargetHolder[positionIndex];
			
			Integer newValue = positionIndex + 1;

			if(signOriginalSource != newSign)
			{
				newValue = newValue * -1;
			}
			mappedSourceHolder[i] = newValue.toString();
		}
		
		mappedSource = mappedSourceHolder[0];
		for(int i=1; i<mappedSourceHolder.length; i++)
		{
			mappedSource = mappedSource + " " + mappedSourceHolder[i];
		}
		
		return mappedSource;
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
