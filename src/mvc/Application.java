/**
 * 1.Найти наибольшее количество предложений текста, в которых есть одинаковые слова.
 */
package mvc;

import mvc.controller.Controller;
import mvc.model.Model;
import mvc.view.View;

/**
 * @author Sergey
 *
 */
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Model model = new Model();
		View view = new View();
		Controller controller = new Controller(model, view);
		
		controller.startProgram();

	}

}
