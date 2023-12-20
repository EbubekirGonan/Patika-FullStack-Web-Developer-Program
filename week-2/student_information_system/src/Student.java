public class Student {
    Course c1;
    Course c2;
    Course c3;
    String name;
    String stuNo;
    String classes;
    double average;
    boolean isPass;


    Student (String name, String stuNo, String classes, Course c1, Course c2, Course c3){
        this.name = name;
        this.stuNo = stuNo;
        this.classes = classes;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.average = 0.0;
        this.isPass = false;
    }

    void addBulkExamNote(int note1, int note2, int note3){
        if(note1>= 0 && note1<=100) {
            c1.note = note1;
        }
        if(note2>= 0 && note2<=100) {
            c2.note = note2;
        }
        if(note3>= 0 && note3<=100) {
            c3.note = note3;
        }
    }

    void addBulkPerformNote(int perform1, int perform2, int perform3){
        if(perform1>= 0 && perform1<=100) {
            c1.perform = perform1;
        }
        if(perform2>= 0 && perform2<=100) {
            c2.perform = perform2;
        }
        if(perform3>= 0 && perform3<=100) {
            c3.perform = perform3;
        }
    }

    void  isPass(){
        System.out.println("==================");
        printName();
        this.c1.gradnote = (this.c1.note * 0.8 + this.c1.perform * 0.2);
        this.c2.gradnote = (this.c2.note * 0.8 + this.c2.perform * 0.2);
        this.c3.gradnote = (this.c3.note * 0.8 + this.c2.perform * 0.2);

        this.average = (this.c1.gradnote + this.c2.gradnote + this.c3.gradnote)/3.0;
        if (this.average > 55){
            System.out.println("Hababam sınıfı uyanıyor.");
            this.isPass = true;
        } else {
            System.out.println("Hababam sınıfı sınıfta kaldı.");
            this.isPass = false;
        }
        printNote();
    }

    void printNote () {
        System.out.println(c1.name + " Notu: " + c1.note);
        System.out.println(c2.name + " Notu: " + c2.note);
        System.out.println(c3.name + " Notu: " + c3.note);
        System.out.println("Ortalamanız: " + this.average);
    }

    void printName(){
        System.out.println(name);
    }
}
