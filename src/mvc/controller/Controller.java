/**
 * 
 */
package mvc.controller;

import mvc.model.Model;
import mvc.model.ReadWriteFile;
import mvc.view.SentencesWithIdenticalWordsFinderView;
import mvc.view.View;
import mvc.model.instances.*;
import mvc.model.methods.*;

/**
 * @author Sergey
 *
 */
public class Controller {
	private Model model;							// the model is not used for this task
	private View view;
	
	public Controller(Model model, View view) {
		this.model = model;							// the model is not used for this task
		this.view = view;
	}

	/**
	 * 
	 */
	public void startProgram() {
		
		// get text from file
		ReadWriteFile readWriteFile = new ReadWriteFile();
		Text text = new Text(readWriteFile.readFile());
		
		// remove all tabs and multispaces
		text.replaceTabAndMultispace();
//		view.printText(text.getText());
		
		// get all sentences
		text.splitTextIntoSentences();
//		view.printAllSentences(text);
		
		// 1.Найти наибольшее количество предложений текста, в которых есть одинаковые слова.
		// search sentences with identical words
		SentencesWithIdenticalWordsFinder finder = new SentencesWithIdenticalWordsFinder(text);
		finder.searchSntsWithIdentWords();
		SentencesWithIdenticalWordsFinderView finderView = new SentencesWithIdenticalWordsFinderView(finder);
		finderView.printFinder();
		

		
	}
}
