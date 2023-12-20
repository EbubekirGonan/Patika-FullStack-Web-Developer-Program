public class Course {
    Teacher teacher;
    String name;
    String code;
    String prefix;

    int note;
    int perform;
    double gradnote;

    //Course sınıfında parametreli constructure course metodu
    Course(String name, String code, String prefix){
        this.name = name;
        this.code = code;
        this.prefix = prefix;
        int note = 0;
    }

    void addTeacher(Teacher teacher){
        if(teacher.branch.equals(this.prefix)){
            this.teacher = teacher;
        }else {
            System.out.print("Öğretmen ve ders bölümleri uyuşmuyor.");
        }

    }

    void printTeacherInfo(){
        this.teacher.print();
    }

}
