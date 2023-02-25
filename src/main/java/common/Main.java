package common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import betclic.BetclicScrapTools;
import winamax.WinamaxScrapTools;
import winamax.WinamaxWebPages;

public class Main {

	public static void main(String[] args) throws IOException {

		WinamaxScrapTools wst = new WinamaxScrapTools();
		wst.winamaxAllInOne(WinamaxWebPages.WIN_FOOT_FR_1);
		
		BetclicScrapTools bst = new BetclicScrapTools();
		Document doc = Jsoup.connect("https://www.betclic.fr/football-s1/ligue-1-uber-eats-c4").get();
		String data = doc.data();
		
		Document doc2 = Jsoup.connect("https://www.winamax.fr/paris-sportifs/sports/100000").get();
		String data2 = doc2.data();
		
		Document doc3 = Jsoup.connect("https://www.winamax.fr/paris-sportifs/calendar").get();
		String data3 = doc3.data();
		
		Document doc4 = Jsoup.connect("https://www.vbet.fr/calendrier").get();
		String data4 = doc4.data();
		
		PrintWriter writer = new PrintWriter("mon-fichier.txt", "UTF-8");
		writer.println(data4);
		writer.close();
		
		data = bst.dataClean(data);
		List<String> isolatedMatchesData = bst.isolateMatchesData(data);
		List<Match> betclicMatches = bst.isolatedDataToBetclicMatches(isolatedMatchesData);
		
	}
}
