/**
 * 
 */
package mvc.view;

import java.util.*;

import mvc.model.instances.Sentence;
import mvc.model.instances.Text;

/**
 * @author Sergey
 *
 */
public class View {
	private StringBuffer text;
	
	public void printText(StringBuffer text) {
		System.out.println(text);
	}
	
	public void printText(String text) {;
		System.out.println(text);
	}
	
	public void printText(List<String> list) {
		StringBuffer text = new StringBuffer();
		for (String str : list) {
			str += "\n";
			text.append(str);
		}
		System.out.println(text);
	}
	
	public void printAllSentences(Text text) {
		for (Sentence s : text.getAllSentences()) {
			printText(s.getString());
//			System.out.println("- Words quantity: " + s.getWords().size() + ", Sentence type: " + s.getSentenceType());
//			System.out.println();
		}
	}
		
	
	public void setText(StringBuffer text) {
		this.text = text;
	}
	
	public StringBuffer getText() {
		return this.text;
	}
}
