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
public class Text extends TextString {
	private List<Sentence> allSentences = new ArrayList<Sentence>();

	public Text() {
	}

	public Text(String text) {
		super(text);
	}

	public void replaceTabAndMultispace() {
		StringBuffer stringBuffer = new StringBuffer(text);
		char space = ' ';

		// remove tabs and multispaces
		for (int i = 0; i < stringBuffer.length(); i++) {
			if (Character.isWhitespace(stringBuffer.charAt(i))) {
				int spaceNumber = spaceNumber(stringBuffer, i);
				if (spaceNumber >= 1) {
					stringBuffer.replace(i, i + spaceNumber,
							String.valueOf(space));
				}
			}
		}

		text = stringBuffer.toString().trim();
	}

	/**
	 * @param stringBuffer
	 * @param i
	 * @return
	 */
	private int spaceNumber(StringBuffer stringBuffer, int i) {
		int j;
		for (j = 0; j < stringBuffer.length() - i; j++) {
			if (!Character.isWhitespace(stringBuffer.charAt(i + j))) {
				return j;
			}
		}

		return j;
	}

	public void splitTextIntoSentences() {

		int indexBegin = 0;
		for (int i = 0; i < text.length() - 1; i++) {

			// put sentences into list except last one
			if (isSentenceDelimiter(text, i)) {
				putSentenceIntoList(text, indexBegin, i);
				indexBegin = i + 1;
			}

		}

		// put last sentence into list
		putSentenceIntoList(text, indexBegin, text.length());

	}

	/**
	 * @return
	 */
	private boolean isSentenceDelimiter(String text, int i) {
		char space = PunctuationMark.SPACE.punctuationMark;
		boolean sentenceDelimiter = text.charAt(i) == space
				&& isSentenceEnd(text, i)
				&& (Character.isUpperCase(text.charAt(i + 1)) || Character
						.isDigit(text.charAt(i + 1)));
		return sentenceDelimiter;
	}

	/**
	 * @param i
	 * @return
	 */
	private boolean isSentenceEnd(String text, int i) {
		char dot = PunctuationMark.DOT.punctuationMark;
		char exclamationMark = PunctuationMark.EXCLAMATION_MARK.punctuationMark;
		char quastionMark = PunctuationMark.QUESTION_MARK.punctuationMark;
		String threeDots = "" + dot + dot + dot;
		return text.charAt(i - 1) == dot 
				|| text.charAt(i - 1) == exclamationMark
				|| text.charAt(i - 1) == quastionMark
				|| text.substring(i - 3, i).equals(threeDots);
	}

	/**
	 * @param indexBegin
	 * @param i
	 */
	private void putSentenceIntoList(String text, int indexBegin, int i) {
		String s = text.substring(indexBegin, i);
		Sentence sentence = new Sentence(s);
		allSentences.add(sentence);
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

	/**
	 * @return the allSentences
	 */
	public List<Sentence> getAllSentences() {
		return allSentences;
	}

}
