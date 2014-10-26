/**
 * 1.Найти наибольшее количество предложений текста, в которых есть одинаковые слова.
 */
package mvc.model.methods;

import java.util.*;

import mvc.model.instances.Sentence;
import mvc.model.instances.Text;
import mvc.model.instances.Word;

/**
 * @author Sergey
 *
 */
public class SentencesWithIdenticalWordsFinder {
	
	private Text text;

	private Map<String, Text> identicalWords = new HashMap<String, Text>();
	private String maxWord;
	private Text maxText;	
		
	public SentencesWithIdenticalWordsFinder(Text text) {
		this.text = text;
	}
	
	public void searchSntsWithIdentWords() {
		
		// create map of identical words
		for (Sentence sentence : this.text.getAllSentences()) {
			for (Word word : sentence.getWords()) {
				Text sentencesWithWord = new Text();
				for (Sentence s : this.text.getAllSentences()) {
					if (s.search(word.getString()) > 0) {
						sentencesWithWord.getAllSentences().add(s);
					}
				}
				identicalWords.put(word.getString(), sentencesWithWord);
			}
		}
		
		// get word with maximum sentences
		int max = 0;
		for (Map.Entry<String, Text> entry : identicalWords.entrySet()) {
			if (entry.getValue().getAllSentences().size() > max) {
				max = entry.getValue().getAllSentences().size() ;
				maxWord = entry.getKey();
				maxText = entry.getValue();
			}
		}

	}

	
	/**
	 * @return the text
	 */
	public Text getText() {
		return text;
	}

	/**
	 * @return the maxText
	 */
	public Text getMaxText() {
		return maxText;
	}

	/**
	 * @return the identicalWords2
	 */
	public Map<String, Text> getIdenticalWords2() {
		return identicalWords;
	}

	/**
	 * @return the maxWord
	 */
	public String getMaxWord() {
		return maxWord;
	}

	
	
}
