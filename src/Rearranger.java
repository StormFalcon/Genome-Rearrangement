import java.util.ArrayList;


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
			
			Mapper mapper = new Mapper(sourceGenome, targetGenome);
			
			String mappedSource = mapper.mappedSource;
			String mappedTarget = mapper.mappedTarget;
			
			ArrayList<Component> sourceComponent = findComponents(mappedSource);
			ArrayList<Component> targetComponent = findComponents(mappedTarget);
			
			
			
			return count;
		}
	}
	
	public ArrayList<Component> findComponents(String sequence) 
	{
		ArrayList<Component> componentList = null;
		
		return componentList;
	}
	
}
