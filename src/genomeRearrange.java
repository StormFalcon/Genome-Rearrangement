import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class genomeRearrange {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//File inputFile = new File("C:\\Users\\YIM Wai Tsun\\Google Drive\\School Work\\CS3225 Combinatorial Methods In Bioinformatics\\Project2\\data\\mitochondrial.txt");
		File inputFile = new File("/Users/Flyer/Documents/School Work/CS3225 Combinatorial Methods In Bioinformatics/Project2/data/mitochondrial.txt");
		
		FileReader fr = new FileReader(inputFile);
		BufferedReader br = new BufferedReader(fr);
		
		ArrayList<String> inputHolder = new ArrayList<String>();
		
		String inputLine = br.readLine();
		
		while(inputLine != null)
		{
			inputHolder.add(inputLine);
			// System.out.println(inputLine);
			inputLine = br.readLine();
		}
		
		//System.out.println(inputHolder.size());
		
		ArrayList<Genome> genomeHolder = new ArrayList<Genome>();
		
		String species = null;
		String genome = null;
		
		for(int i=0; i<inputHolder.size(); i++)
		{
			if(i%2 == 0)
			{
				// species
				species = inputHolder.get(i).substring(2);
			}
			else
			{
				// genome
				genome = inputHolder.get(i);
				Genome newGenome = new Genome(species, genome);
				genomeHolder.add(newGenome);
			}
		}
		
		System.out.println(genomeHolder.size());
		
		for(int i=0; i<genomeHolder.size(); i++)
		{
			for(int j=i+1; j<genomeHolder.size(); j++)
			{
				Genome source = genomeHolder.get(i);
				Genome target = genomeHolder.get(j);
				
				System.out.println(source.species + '\t' + target.species);
				
				Rearranger rearranger = new Rearranger(source, target);
				int reversalCount = rearranger.rearrange();
			}
		}
		
		if(br != null)
			br.close();
		if(fr != null)
			fr.close();
	}

}
