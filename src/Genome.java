
public class Genome {

	public String species;
	public String genome;
	
	public Genome(String species, String genome)
	{
		this.species = species;
		String[] temp = genome.split(",");
		this.genome = temp[0];
		
		for(int i=1; i<temp.length; i++)
		{
			this.genome = this.genome + temp[i];
		}
	}
	
}
