package Repository;

import DataAccess.DictionaryDao;

public class DictionaryRepository implements IDictionaryRepository {
    private final DictionaryDao data = new DictionaryDao();

    @Override
    public void addWord() {
        data.addWord();
    }

    @Override
    public void removeWord() {
        data.removeWord();
    }

    @Override
    public void translate() {
        data.translate();
    }
}
