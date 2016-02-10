import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by branden on 2/10/16 at 12:15.
 */
public class BookStore {
    static Scanner scanner = new Scanner(System.in);
    static HashMap<String, Book> bookMap = new HashMap<>();


    public static void main(String[] args) {

        //lets just go ahead and load in our file if it exists
        try {
            readFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        System.out.println("Would you like to:");
        System.out.println("1. Enter a new book");
        System.out.println("2. View a book");
        int userChoice = Integer.valueOf(scanner.nextLine());

        //if to handle choice. Zach; can I use Ternary op to do this?
        if (userChoice == 1) {
            newEntry();
        } else {
            viewEntry();
        }

    }





    public static void newEntry() {
        System.out.println("What is the books title?");
        String book = scanner.nextLine();
        bookMap.put(book, new Book());
        System.out.printf("Let's enter some info about %s%n", book);
        bookMap.get(book).setTitle(book);
        bookMap.get(book).setAuthor();
        bookMap.get(book).setShortDescription();
        bookMap.get(book).setYear();
        bookMap.get(book).setIsbn();
        bookMap.get(book).setRating();

        System.out.println(bookMap.get(book));
        try {
            saveToFile(bookMap.get(book));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void viewEntry() {
        int i = 1;
        for (String key : bookMap.keySet() ) {
            System.out.printf("%d. %s%n", i, key);
            i++;
        }
        System.out.println("Please choose a book to view");
        int bookChoice = Integer.parseInt(scanner.nextLine());

    }


    public static void saveToFile(Book b) throws IOException {
        File f = new File("BookStoreInventory.json");
        FileWriter fw = new FileWriter(f, true);


        JsonSerializer serializer = new JsonSerializer();
        String output = serializer.include("*").serialize(b);

        fw.append(output).append("\n");
        fw.close();

    }

    public static void readFromFile() throws FileNotFoundException {
        File f = new File("BookStoreInventory.json");
        if (f.exists()) {
            Scanner s = new Scanner(f);

            JsonParser parser = new JsonParser();


            while (s.hasNextLine()) {   ///UGH! hasNextLine() NOT hasNext()
                String contents = s.nextLine();
                Book temp = parser.parse(contents, Book.class);
                if (!bookMap.containsKey(temp.getTitle())) {
                    bookMap.put(temp.getTitle(), temp);
                }
            }
        }

    }
}




