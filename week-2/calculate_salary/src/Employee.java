public class Employee {

    //nitelikler ve değişkenler tanımlandı.
    String name;
    double salary;
    int workHours;
    int hireYear;
    double tax;
    double bonus;
    double raise;
    double  total;

    
    //employee sınıfından yeni bir nesne üretmek için parametreli kurucu method oluşturuldu.
    Employee (String name, double salary, int workHours, int hireYear){
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    //tax methodu oluşturuldu.
    void tax(){
        if(this.salary >= 1000){
            this.tax = this.salary * 0.03;
        }
    }

    // bonus methodu oluşturuldu.
    void bonus(){
        if(this.workHours >= 40){
            bonus = (this.workHours - 40) * 30;
        }
    }

    //maaş zammı methodu oluşturuldu
    void raiseSalary(){
        if(2021 - this.hireYear < 10){
            this.raise = this.salary * 0.05;
        } else if (2021 - this.hireYear < 20) {
            this.raise = this.salary * 0.10;
        } else if (2021 - this.hireYear > 20){
            this.raise = this.salary * 0.15;
        }
    }


    //çalışanlara ait bilgilerin yzdırılması için gerekli methodlar
    //toPrint methodunun içine çağrıldı.

    void toPrint(){
        tax();
        bonus();
        raiseSalary();
        this.total = (this.salary - this.tax + this.bonus) + this.raise;
        System.out.println("Adı: " + this.name);
        System.out.println("Maaşı: " + this.salary);
        System.out.println("Çalışma Saaati: " + this.workHours);
        System.out.println("Başlangıç Yılı: " + this.hireYear);
        System.out.println("Vergi: " + this.tax);
        System.out.println("Bonus: " + this.bonus);
        System.out.println("Vergi ve Bonuslarla birlikte maaş: " + (this.salary - this.tax + this.bonus));
        System.out.println("Maaş Artışı: " + this.raise);
        System.out.println("Toplam Maaş: " + this.total);
        System.out.println("==============");
    }

}
