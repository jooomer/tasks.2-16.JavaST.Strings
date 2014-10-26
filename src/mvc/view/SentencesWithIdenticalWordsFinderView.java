/**
 * 
 */
package mvc.view;

import java.util.Map;

import mvc.model.instances.Text;
import mvc.model.methods.SentencesWithIdenticalWordsFinder;

/**
 * @author Sergey
 *
 */
public class SentencesWithIdenticalWordsFinderView extends View {
	private SentencesWithIdenticalWordsFinder finder;
	
	public SentencesWithIdenticalWordsFinderView(SentencesWithIdenticalWordsFinder finder) {
		this.finder = finder;
	}
		
	public void printFinder() {
		System.out.println();
		System.out.println("**************************************************************************************");
		System.out.println("* 1.Найти наибольшее количество предложений текста, в которых есть одинаковые слова. *");
		System.out.println("**************************************************************************************");
		System.out.println();
		System.out.println("Words:             " + "Sentences quantity:");
		System.out.println("-----              ------------------");
		for (Map.Entry<String, Text> entry : finder.getIdenticalWords2().entrySet()) {
			System.out.printf("%-25s", entry.getKey());
			System.out.println(entry.getValue().getAllSentences().size());
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Word with maximum quantity of sentences:");
		System.out.println("----------------------------------------");
		System.out.println("'" + finder.getMaxWord() + "'");
		System.out.println();
		System.out.println(finder.getMaxText().getAllSentences().size() + " following sentences consist the word '" + finder.getMaxWord() + "':");
		System.out.println("-----------------------------");
		printAllSentences(finder.getMaxText());
		
		
	}


}
