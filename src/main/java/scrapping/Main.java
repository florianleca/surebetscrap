package scrapping;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main {

	public static void main(String[] args) throws IOException {

		WinamaxScrapTools wst = new WinamaxScrapTools();
		wst.winamaxAllInOne(WinamaxWebPages.WIN_FOOT_FR_1);
		
		BetclicScrapTools bst = new BetclicScrapTools();
		Document doc = Jsoup.connect("https://www.betclic.fr/football-s1/ligue-1-uber-eats-c4").get();
		String data = doc.data();
		
		data = bst.dataClean(data);
		List<String> isolatedMatchesData = bst.isolateMatchesData(data);
		List<BetclicMatch> betclicMatches = bst.isolatedDataToBetclicMatches(isolatedMatchesData);
		
	}
}
