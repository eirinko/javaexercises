import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
// import java.util.List;
// import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// Next time: sjekke antall adjektiv i adjektivfortellingen og deretter sørge for at det er så mange eller flere adjektiv å velge fra.
public class Adjektivfortelling {

	public static void main(String[] args) 
		throws IOException
	{
		Scanner scan = new Scanner(System.in);
		//Resource leak: 'scan' is never closed. Should it be closed? 
		scan.useDelimiter(Pattern.compile("[\\n;]+"));
		System.out.println("Skriv inn adjektivene dine. Avslutt med ENTER.");
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
		
		// Creating a path choosing file from local directory by creating an object of Path class
		String filepos = scan.next();
		System.out.println("Write path and file to use and then ENTER: ");
		filepos = filepos.substring(0, filepos.length()-1);
        Path fortelling = Path.of(filepos);

        String str = Files.readString(fortelling);
        int count = 0;
        
        while (str.contains("[adjektiv]")) {
        	str = str.replaceFirst("\\[adjektiv\\]", utvalgteAdjektiv[count]);
        	count++;        
        }
        System.out.println(str);
	}
	
}
