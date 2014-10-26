/**
 * 
 */
package mvc.model.instances;

/**
 * @author Sergey
 *
 */
public abstract class TextString {
	protected String text;
	
	public TextString(){}
	
	public TextString(String string) {
		this.text = string;
	}

	/**
	 * @return the string
	 */
	public String getString() {
		return text;
	}

}
