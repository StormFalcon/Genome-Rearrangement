
public class Rearranger {

	Genome source;
	Genome target;
	
	public Rearranger(Genome source, Genome target)
	{
		this.source = source;
		this.target = target;
	}
	
	public int rearrange()
	{
		String sourceGenome = this.source.genome;
		String targetGenome = this.target.genome;
		
		if(sourceGenome.equals(targetGenome))
			return 0;
		else
		{
			int count = 0;
			
			
			
			return count;
		}
	}
	
}
