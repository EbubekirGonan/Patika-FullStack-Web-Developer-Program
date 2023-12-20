import java.nio.charset.CoderResult;

public class Main {
    public static void main(String[] args) {
        Teacher t1 = new Teacher("Mahmut Hoca", "TRH", "555");
        Teacher t2 = new Teacher("Graham", "FZK", "0000");
        Teacher t3 = new Teacher("Külyutmaz", "BIO", "111");

        Course tarih = new Course ("Tarih", "101", "TRH");
        tarih.addTeacher(t1);

        Course fizik = new Course("Fizik", "102", "FZK");
        fizik.addTeacher(t2);

        Course biyo = new Course("Biyoloji", "101", "BIO");
        biyo.addTeacher(t3);

        Student s1 = new Student("İnek Şaban", "123", "4", tarih, fizik, biyo);
        s1.addBulkExamNote(100, 78,50);
        s1.addBulkPerformNote(30, 45, 50);
        s1.isPass();

        Student s2 = new Student("Güdük Necmi", "444", "4", tarih, fizik, biyo);
        s2.addBulkExamNote(50,30,70);
        s2.addBulkPerformNote(65, 45, 50);
        s2.isPass();

        Student s3 = new Student("Damat Ferit", "324", "4", tarih,fizik,biyo);
        s3.addBulkExamNote(70, 45, 60);
        s3.addBulkPerformNote(50, 60, 65);
        s3.isPass();
    }
}