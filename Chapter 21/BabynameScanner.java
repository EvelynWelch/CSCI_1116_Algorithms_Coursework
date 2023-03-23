import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Author: Evie Welch
// date: 02/22/23
public class BabynameScanner {
	public static String makeUrlString(String year) {
		String urlString = "http://liveexample.pearsoncmg.com/data/babynamesranking";
		return urlString + year + ".txt";
	}

	public static URL URLfactory(String urlString) {
		try {
			URL url = new URL(urlString);
			return url;
		} catch (MalformedURLException e) {
			System.out.println("URLfactory() error: " + e.getMessage());
			return null;
		}
	}

	public static Map[] getNameRankings(String year) throws Exception {
		Map<String, Integer> boyNames = new HashMap<String, Integer>();
		Map<String, Integer> girlNames = new HashMap<String, Integer>();
		
		URL babyNameURL = URLfactory(makeUrlString(year));

		Scanner input = new Scanner(babyNameURL.openStream());
		while (input.hasNextLine()) {
			String l = input.nextLine();
			String[] v = l.split("\\s+");
			int rank = Integer.valueOf(v[0]);
//			System.out.println("v[3]: " + v[3]);
			String boyName = v[1];
			String girlName = v[3];
			boyNames.put(boyName, rank);
			girlNames.put(girlName, rank);
		}

		input.close();
		Map[] nameRankings = {girlNames, boyNames};
		
		return nameRankings;
	}
}
