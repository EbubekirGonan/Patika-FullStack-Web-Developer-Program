import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int select;

        Set<Book> allBooks = new HashSet<>();
        Set<Book> bookSetByName = new TreeSet<>(Book::compareTo);
        Set<Book> bookSetByNumOfPages = new TreeSet<>(Comparator.comparing(Book::getNumOfPages));


        Book book1 = new Book("Sefiller", 2000,"Victor Hugo", "1862");
        Book book2 = new Book("Mülksüzler", 335,"Ursula le Guin", "1974");
        Book book3 = new Book("Dublinliler", 254,"James Joyce", "1914");
        Book book4 = new Book("Ecinniler", 904,"Dostoyevski", "1872");
        Book book5 = new Book("Sarı Defterdekiler", 400,"Yaşar Kemal", "1997");

        allBooks.add(book1);
        allBooks.add(book2);
        allBooks.add(book3);
        allBooks.add(book4);
        allBooks.add(book5);

        bookSetByName.add(book1);
        bookSetByName.add(book2);
        bookSetByName.add(book3);
        bookSetByName.add(book4);
        bookSetByName.add(book5);

        bookSetByNumOfPages.add(book1);
        bookSetByNumOfPages.add(book2);
        bookSetByNumOfPages.add(book3);
        bookSetByNumOfPages.add(book4);
        bookSetByNumOfPages.add(book5);



            for(Book book : allBooks){
                System.out.println("Kitap ismi: " + book.getName() + "\n"+
                        " Yazar ismi: " + book.getAuthorName() + "\n"+
                        " Sayfa Sayısı: " + book.getNumOfPages() + "\n"+
                        " Yayın Tarihi: " + book.getPublishDate());
                System.out.println("=======================");
            }

            Scanner input = new Scanner(System.in);
            System.out.println("Kitapları nasıl sıralamak istersiniz:\n" +
                    "1 - İsimlerini alfabetik sıraya göre\n" +
                    "2 - Sayfa sayılarını küçükten büyüğe göre\n" +
                    "3 - Çıkış yap\n");
            select = input.nextInt();

            switch (select){
                case 1:
                    for(Book book : bookSetByName){
                        System.out.println("Kitap ismi: " + book.getName() + "\n"+
                                " Yazar ismi: " + book.getAuthorName() +"\n"+
                                " Sayfa Sayısı: " + book.getNumOfPages() +"\n"+
                                " Yayın Tarihi: " + book.getPublishDate());
                        System.out.println("=======================");
                    }
                    break;
                case 2:
                    for(Book book : bookSetByNumOfPages){
                        System.out.println(" Sayfa Sayısı: " + book.getNumOfPages() +"\n"  +
                                " Kitap ismi: " + book.getName() + "\n"+
                                " Yazar ismi: " + book.getAuthorName() +"\n"+
                                " Yayın Tarihi: " + book.getPublishDate());
                        System.out.println("=======================");
                    }
                    break;
                case 3:
                    break;
                default:
                    break;

            }








    }
}