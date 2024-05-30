import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        try {
            words = readWordsFromFile("src/HangmanWordsList(1).txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();


        }
        String word = selectRandomWord(words);
        String currentWord = displayWord(word);
        int incorrectGuesses = 0;
        int maxIncorrectGuesses = 7;
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Hangman!");
        System.out.println("Try to guess the word. You have 7 guesses.");
        while (!gameOver) {
            System.out.println("Word: " + currentWord);
            System.out.print("Enter a letter: ");
            char guess = scanner.next().charAt(0);// this bit of the code uses various programming methods to
            //pick, move into arraylist data structure and initialize a random word into my game
            // also initializes many important variables



            if (word.contains(String.valueOf(guess))) {
                currentWord = updateWord(word, guess, currentWord);
            } else {
                incorrectGuesses++;
                System.out.println("Incorrect guess. You have " + (maxIncorrectGuesses - incorrectGuesses) + " guesses left.");

                if (incorrectGuesses < maxIncorrectGuesses) {
                    hangmanImage(incorrectGuesses);
                }
            }
            // uses if else statement to calculate how many guesses are left


            if (currentWord.equals(word)) {
                System.out.println("Congratulations! You've guessed the word: " + word);
                break;
            }// victory message, if the word matches the word that the user inputted then the if statement breaks





            if (incorrectGuesses >= maxIncorrectGuesses) {
                System.out.println("You've run out of guesses. The word was: " + word);
                System.out.println("Wrong guess, try again");
                System.out.println(" ____________");
                System.out.println("   |      !");
                System.out.println("   |     { } ");
                System.out.println("   |    / ! \\");
                System.out.println("   |      !  ");
                System.out.println("   |     / \\");
                System.out.println("   |    /   \\");
                System.out.println("___|___");
                break;
            }// losing statement, if break statement, includes image view
        }
    }





    public static List<String> readWordsFromFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        List<String> words = new ArrayList<>();// array list where words from the txt file are stored


        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String word = scanner.next();
            word = word.toLowerCase(); // this method translates the selected word into lowercase
            words.add(word);
        }
        scanner.close();

        return words;
    }



    public static String selectRandomWord(List<String> words) {
        Random random = new Random();
        String word = words.get(random.nextInt(words.size()));
        return word;
    }// selectRandomWord method to pick a random word, gets set as "word" variable




    public static String displayWord(String word) {
        StringBuilder result = new StringBuilder();
        for (char c : word.toCharArray()) {
            result.append('-');
        }
        return result.toString();
    }// Displays the selected word, replaces all unguessed words with underscore
    // Uses character array to replace particular words





    public static String updateWord(String word, char guess, String currentWord) {
        char[] currentWordChars = currentWord.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                currentWordChars[i] = guess;
            }// sets 3 parameters, word, guess and current word
            // creates a character array currentWordChars by converting the currentWord string to a character array.
            //corresponding character in the currentWordChars array is updated to the guess character
        }
        return new String(currentWordChars);
    }






    public static void hangmanImage(int count) {
        switch (count) {
            case 1 ->{
                System.out.println("Wrong guess, try again");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("    ");
                System.out.println("   ");
                System.out.println("   ");
                System.out.println("   ");
                System.out.println("   ");
                System.out.println("___|___");

            }

            case 2 -> {
                System.out.println("Wrong guess, try again");
                System.out.println(" ____________");
                System.out.println("   |      ");
                System.out.println("   |     ");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("___|___");
            }
                case 3-> {
                    System.out.println("Wrong guess, try again");
                    System.out.println(" ____________");
                    System.out.println("   |      !");
                    System.out.println("   |     { }");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("___|___");
            }
            case 4 -> {
                System.out.println("Wrong guess, try again");
                System.out.println(" ____________");
                System.out.println("   |      !");
                System.out.println("   |     { }");
                System.out.println("   |      ！");
                System.out.println("   |      ！");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("___|___");

            }
            case 5 -> {
                System.out.println("Wrong guess, try again");
                System.out.println(" ____________");
                System.out.println("   |      !");
                System.out.println("   |     { } ");
                System.out.println("   |      !");
                System.out.println("   |      !  ");
                System.out.println("   |     / ");
                System.out.println("   |    /    ");
                System.out.println("___|___");
            }
            case 6 -> {
                System.out.println("Wrong guess, try again");
                System.out.println(" ____________");
                System.out.println("   |      !");
                System.out.println("   |     { } ");
                System.out.println("   |      !");
                System.out.println("   |      !  ");
                System.out.println("   |     / \\");
                System.out.println("   |    /   \\");
                System.out.println("___|___");
            }


        }
    }
}