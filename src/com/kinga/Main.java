package com.kinga;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type a sentence: ");
        String sentence = scanner.nextLine();
        System.out.println("Type a word: ");
        String word = scanner.nextLine();

        Algorithm algorithm = new Algorithm(sentence, word);
        algorithm.execute();
    }
}
