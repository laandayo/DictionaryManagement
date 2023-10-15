package DataAccess;
import Controller.Validation;

import java.util.*;

public class DictionaryDao {

    private final HashMap<String, String> hshm;
    private static DictionaryDao instance = null;
    public static DictionaryDao Instance() {
        if (instance == null) {
            synchronized (DictionaryDao.class) {
                if (instance == null) {
                    instance = new DictionaryDao();
                }
            }
        }
        return instance;
    }

    public DictionaryDao() {
        this.hshm = new HashMap<>();
    }

    public void addWord() {
        System.out.println("------------- Add -------------");
        System.out.print("Enter English: ");
        String english = Validation.checkInputString();
        if (!checkKeywordExist(english)) {
            if (!Validation.checkInputYN()) {
                return;
            }
        }
        System.out.print("Enter Vietnamese: ");
        String vietnam = Validation.checkInputString();
        hshm.put(english, vietnam);
        System.err.println("Successfully Added .");
        System.out.println("\n");
    }

    public void removeWord() {
        System.out.println("------------ Delete ----------------");
        System.out.print("Enter English: ");
        String english = Validation.checkInputString();
        hshm.remove(english);
        System.err.println("Successfully Deleted .");
        System.out.println("\n");
    }

    public void translate() {
        System.out.println("------------- Translate ------------");
        System.out.print("Enter English: ");
        String english = Validation.checkInputString();
        Set<Map.Entry<String, String>> entries = hshm.entrySet();
        for (Map.Entry entry : entries) {
            if (entry.getKey().equals(english)) {
                System.out.println("Vietnamese: " + entry.getValue());
                return;
            }
        }
        System.err.println("Not found");
    }

    public boolean checkKeywordExist(String english) {
        return !hshm.containsKey(english);
    }
}
