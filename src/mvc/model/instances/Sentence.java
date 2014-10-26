/**
 * 
 */
package mvc.model.instances;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey
 *
 */
public class Sentence extends TextString {
	private List<Word> words;
	private SentenceType sentenceType;

	private PunctuationMark dot = PunctuationMark.DOT;
	private String threeDots = "" + dot.punctuationMark + dot.punctuationMark + dot.punctuationMark;

	
	public Sentence() {
	}

	public Sentence(String sentence) {
		super(sentence);
		this.sentenceType = identifySentenceType(sentence);
		this.words = makeWordsList(sentence);
	}

	enum SentenceType {
		DECLARATIVE_SENTENCE,
		INTERROGATIVE_SENTENCE,
		EXCLAMATORY_SENTENCE,
		ELLIPSIS_SENTENCE;
	}
	
	private List<Word> makeWordsList(String sentence) {
		this.words = new ArrayList<Word>();

		// remove punctuation mark at the end of a sentence		
		SentenceType sentenceType = identifySentenceType(sentence);
		String string = "";
		if (sentenceType.equals(SentenceType.DECLARATIVE_SENTENCE) 
				|| sentenceType.equals(SentenceType.EXCLAMATORY_SENTENCE)
				|| sentenceType.equals(SentenceType.INTERROGATIVE_SENTENCE)) {
			string = sentence.substring(0, sentence.length() - 1);
		} else if (sentenceType.equals(SentenceType.ELLIPSIS_SENTENCE)) {
			string = sentence.substring(0, sentence.length() - 3);
		} else {
			System.out.println("Error! Sentence type is wrong.");
		}

		// get words
		String[] str = string.split("\\s");
		for (String s : str) {
			Word word = new Word(s);
			word.cleanWord();
			this.words.add(word);
		}

		return this.words;
	}
	
	private SentenceType identifySentenceType(String sentence) {
		int indexEnd = sentence.length() - 1;
		PunctuationMark pm = PunctuationMark.getPunctuationMark(sentence.charAt(indexEnd));
		switch (pm) {
		case DOT: 															// it's "."
			if (sentence.length() > 3) {
				if (sentence.substring(indexEnd - 2).equals(threeDots)) { 	// it's "..."
					sentenceType = SentenceType.ELLIPSIS_SENTENCE;
					break;
				}
			}
			this.sentenceType = SentenceType.DECLARATIVE_SENTENCE;
			break;
		case EXCLAMATION_MARK: 												// it's "!"
			sentenceType = SentenceType.EXCLAMATORY_SENTENCE;
			break;
		case QUESTION_MARK: 													// it's "?"
			sentenceType = SentenceType.INTERROGATIVE_SENTENCE;
			break;
		default:
		}

		return this.sentenceType;
	}


	public List<Word> getWords() {
		return this.words;
	}

	public int search(String word) {
		int counter = 0;
		for (Word w : this.words) {
			String str = w.getString();
			if (word.equals(str)) {
				counter++;
			}
		}
		return counter;
	}

	/**
	 * @param sentenceType the sentenceType to set
	 */
	public void setSentenceType(SentenceType sentenceType) {
		this.sentenceType = sentenceType;
	}

}
