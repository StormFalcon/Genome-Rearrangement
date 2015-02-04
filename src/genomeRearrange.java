import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class genomeRearrange {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		File inputFile = new File("/Users/Flyer/Documents/School Work/CS3225 Combinatorial Methods In Bioinformatics/Project2/data/mitochondrial.txt");
		FileReader fr = new FileReader(inputFile);
		BufferedReader br = new BufferedReader(fr);
		
		ArrayList inputHolder = new ArrayList();
		
		String inputLine = br.readLine();
		
		while(inputLine != null)
		{
			inputHolder.add(inputLine);
			// System.out.println(inputLine);
			inputLine = br.readLine();
		}
		
		System.out.println(inputHolder.size());
		
		if(br != null)
			br.close();
		if(fr != null)
			fr.close();
	}

}
