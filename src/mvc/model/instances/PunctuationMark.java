/**
 * 
 */
package mvc.model.instances;

/**
 * @author Sergey
 *
 */
public enum PunctuationMark {
	SPACE(' '), 
	DOT('.'), 
	EXCLAMATION_MARK('!'), 
	QUESTION_MARK('?'), 
	OTHER_PUCTUATION_MARKS(',', ';', ':', '(', ')', '[', ']', '{', '}');
	
	char punctuationMark;
	char[] otherPunctuationMarks;
	
	private PunctuationMark(char pMark, char... otherPm) {
		this.punctuationMark = pMark;
		this.otherPunctuationMarks = otherPm;
	}
		
	static public PunctuationMark getPunctuationMark(char punctuationMark) {
	       for (PunctuationMark pm: PunctuationMark.values()) {
	            if (pm.getPunctuationMark() == (punctuationMark)) {
	                return pm;
	            }
	        }
	        throw new RuntimeException("Unknown type");
	    }
	
	public char getPunctuationMark() {
		return punctuationMark;
	}
		
}
