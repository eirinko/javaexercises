import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Adjektivfortelling {

	public static void main(String[] args) 
		throws IOException
	{
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter(Pattern.compile("[\\n;]+"));
		System.out.println("Skriv inn så mange adjektiv du vil. Avslutt med ENTER.");
		String adjektiv = scan.next();
		String[] splittet = adjektiv.split("\\s+");
		
		ArrayList<String> adjektivliste = new ArrayList<String>();
		for (int i=0;i<splittet.length;i++) {
			adjektivliste.add(splittet[i]);
		}
		
		String[] utvalgteAdjektiv = new String[5];
		for (int i=0;i<5;i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(0,adjektivliste.size());
			utvalgteAdjektiv[i] = adjektivliste.get(randomNum);
			adjektivliste.remove(randomNum);
		}
		String adjektivfortelling = "Du er mest kjent for å være " + utvalgteAdjektiv[0] + ". Noen ganger kan du også være ganske " + utvalgteAdjektiv[1] + ". De som sier det er " + utvalgteAdjektiv[2] + ". Du vet at du egentlig er " + utvalgteAdjektiv[3] + ". Det er alle vi " + utvalgteAdjektiv[4] + "e folkene enige om.";
		System.out.println(adjektivfortelling);
		
		// Creating a path choosing file from local directory by creating an object of Path class
        Path fortelling
            = Path.of("C:\\Users\\eirin\\Documents\\Programmering\\javaexercises\\fortelling.txt");
 
        // Now calling Files.readString() method to read the file
        String str = Files.readString(fortelling);
        
        int count = 0;
        
        while (str.contains("[adjektiv]")) {
        	str = str.replaceFirst("\\[adjektiv\\]", utvalgteAdjektiv[count]);
        	count++;        
        }
        System.out.println(str);
	}
	
}
