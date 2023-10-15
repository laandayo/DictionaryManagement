package Controller;

import View.Menu;
import Repository.DictionaryRepository;

public class DictionaryController extends Menu {
    private final DictionaryRepository dictionaryRepository;
    static String[] options = {"Add Word", "Delete Word", "Translate", "Exit"};
    public DictionaryController() {
        super("========= Dictionary program =========", options);
        dictionaryRepository = new DictionaryRepository();
    }
    public void execute(int choice) {
        switch (choice) {
            case 1:
                dictionaryRepository.addWord();
                break;
            case 2:
                dictionaryRepository.removeWord();
                break;
            case 3:
                dictionaryRepository.translate();
                break;
            case 4:
                System.out.println("Exit");
        }
    }
}



