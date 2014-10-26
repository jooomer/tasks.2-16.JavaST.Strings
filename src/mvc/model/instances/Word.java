/**
 * 
 */
package mvc.model.instances;

/**
 * @author Sergey
 *
 */
public class Word extends TextString {

	public Word(String word) {
		super(word);
	}

	public void cleanWord() {
		String word = this.text;
		PunctuationMark pm = PunctuationMark.OTHER_PUCTUATION_MARKS;
		for (char ch : pm.otherPunctuationMarks) {
			if (word.charAt(word.length() - 1) == ch) {
				word = word.substring(0, word.length() - 1);
			}
			if (word.charAt(0) == ch) {
				word = word.substring(1, word.length());
			}
		}
		this.text = word;
	}

}
