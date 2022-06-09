import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;

public class AdjectiveStory {
	public static void main(String[] args) 
		throws IOException
	{
		Scanner scan = new Scanner(System.in);
		//Resource leak: 'scan' is never closed. Should it be closed? 
		scan.useDelimiter(Pattern.compile("[\\n;]+"));

		System.out.println("Write path and file to use and then ENTER: ");
		String filepos = scan.next();
		filepos = filepos.substring(0, filepos.length()-1);
		Path story = Path.of(filepos);
		String str = Files.readString(story);
				
		String strFind = "[adjective]";
		int count = 0, fromIndex = 0;		
		while ((fromIndex = str.indexOf(strFind, fromIndex)) != -1 ){
			count++;
			fromIndex++;
		}

		System.out.println("Type in at least " + count + " adjectives. When you're finished, press ENTER.");
		String adjective = scan.next();
		String[] split = adjective.split("\\s+");

		if (split.length < count) {
			System.out.println("Start again, you need more adjectives.");
			System.exit(0);
		}
		
		ArrayList<String> adjectivelist = new ArrayList<String>();
		for (int i=0;i<split.length;i++) {
			adjectivelist.add(split[i]);
		}
		
		String[] selectedAdjectives = new String[count];
		for (int i=0;i<count;i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(0,adjectivelist.size());
			selectedAdjectives[i] = adjectivelist.get(randomNum);
			adjectivelist.remove(randomNum);
		}
		
        int countadj = 0;
        while (str.contains("[adjective]")) {
        	str = str.replaceFirst("\\[adjective\\]", selectedAdjectives[countadj]);
        	countadj++;
        }

        System.out.println(str);

		scan.close();
	}
}
