
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
	}

	/**
	 * STILL UNDER CONSTRUCTION
	 * @return
	 */
	public Pair map()
	{
		String newSource = null;
		String newTarget = null;
		
		Pair pair = new Pair(newSource, newTarget);
		
		return pair;
	}
	
}
