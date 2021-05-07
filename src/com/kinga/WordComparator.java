package com.kinga;

import java.util.Comparator;

public class WordComparator implements Comparator<Word> {

    @Override
    public int compare(Word o1, Word o2) {              //comparing two words by amount of characters
        Integer i1 = o1.getLogicCharactersAmount();
        Integer i2 = o2.getLogicCharactersAmount();
        return i1.compareTo(i2);
    }
}
