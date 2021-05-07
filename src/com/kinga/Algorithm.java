package com.kinga;

import java.util.ArrayList;

public class Algorithm {
    private String sentence;
    private String logic;

    public Algorithm(String sentence, String logic) {
        this.sentence = sentence.toLowerCase();
        this.logic = logic.toLowerCase();
    }

    public void execute(){
        String[] words = this.sentence.split("\\s+");     //split a sentence into words
        ArrayList<Word> wordList = new ArrayList<>();           //creating list of words
        int amount = 0;                                         //amount of logic letters
        int totalAmount = 0;                                    //amount of all letters

        for(int i = 0; i < words.length; i++){
            words[i] = words[i].replaceAll("[^\\w]", "");   //if there are special characters,
                                                                            //they will be replaced
            System.out.print(words[i] + ", ");
            totalAmount += words[i].length();
            wordList.add(new Word(words[i]));                   //converting strings to words
        }
        System.out.println(" ");

        for(int i = 0; i < this.logic.length(); i++){           //finding logic characters in a word
            for(int j = 0; j < wordList.size(); j++) {
                int temp = wordList.get(j).countingLetters(logic.charAt(i));
                if (temp > 0) {                                 //if characters are found in the word
                    wordList.get(j).addLogicCharacterAmount(temp);
                    wordList.get(j).addLogicCharacter(String.valueOf(logic.charAt(i)));
                    amount += temp;
                }
            }
        }

        addDuplicates(wordList);                    //if there are words in sentence with the same length and they both
                                                    //have the same letter, then they are summed to one word

        wordList.sort(new WordComparator());        //sorting list by amount

        for(Word word: wordList){
            System.out.println("{" + word.getLogicCharacters() + ", " + word.getWord().length() + "} = " +
                    divide(word.getLogicCharactersAmount(), amount) + " (" + word.getLogicCharactersAmount() +
                    "/" + amount + ")");
        }

        System.out.println("TOTAL FREQUENCY: " + divide(amount, totalAmount) + " (" + amount + "/" + totalAmount + ")");

    }

    private double divide(int number1, int number2) {       //dividing two numbers with a precision to 2 decimals
        double value = (double) number1 / number2;
        return Math.round(100.0 * value) / 100.0;
    }


    private void addDuplicates(ArrayList<Word> words){      //if there are words with the same logic characters and the
                                                            //same length then one of the words is removed and amount
                                                            //of logic letters will be added to the first one
        for(int i = 0; i < words.size(); i++){
            for(int j = i + 1; j < words.size(); j++){
                Word word1 = words.get(i);
                Word word2 = words.get(j);
                if(word1.getWord().length() == word2.getWord().length()){
                    if(word1.getLogicCharacters().equals(word2.getLogicCharacters())){
                        words.remove(word2);
                        word1.setLogicCharactersAmount(word1.getLogicCharactersAmount() + word2.getLogicCharactersAmount());
                        words.set(i, word1);
                    }
                }
            }
        }
    }
}
