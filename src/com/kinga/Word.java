package com.kinga;

public class Word {
    private String word;
    private int logicCharactersAmount;  //amount of letters (for example l,o,g,i,c) in a single word
    private String logicCharacters;     //letters (for example l,o,g,i,c) in a single word

    public Word(String word) {
        this.word = word;
        logicCharactersAmount = 0;
        logicCharacters = "";
    }

    public int countingLetters(char character) {            //functions counts a specific character in a word
        int amount = 0;                                     //amount of characters in a word
        for (int i = 0 ; i < this.word.length() ; i++){
            if(this.word.charAt(i) == character){           //compare a character in word to the character in the argument
                amount++;
            }
        }
        return amount;
    }

    public void addLogicCharacterAmount(int a){
        this.logicCharactersAmount += a;
    }

    public void addLogicCharacter(String character){
        this.logicCharacters += character;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getLogicCharactersAmount() {
        return logicCharactersAmount;
    }

    public void setLogicCharactersAmount(int logicCharactersAmount) {
        this.logicCharactersAmount = logicCharactersAmount;
    }

    public String getLogicCharacters() {
        return logicCharacters;
    }

    public void setLogicCharacters(String logicCharacters) {
        this.logicCharacters = logicCharacters;
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", logicCharactersAmount=" + logicCharactersAmount +
                ", logicCharacters='" + logicCharacters + '\'' +
                '}';
    }
}
