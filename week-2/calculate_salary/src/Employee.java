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
        } else if (2021 - this.hireYear >= 20){
            this.raise = this.salary * 0.15;
        }
    }


    //çalışanlara ait bilgilerin yzdırılması için gerekli methodlar
    //toString methodunun içine çağrıldı.

    public String toString(){
        tax();
        bonus();
        raiseSalary();
        this.total = (this.salary - this.tax + this.bonus) + this.raise;
        String result = "Adı: " + this.name + "\n" +
                "Maaşı: " + this.salary + "\n" +
                "Çalışma Saaati: " + this.workHours + "\n" +
                "Başlangıç Yılı: " + this.hireYear + "\n" +
                "Vergi: " + this.tax + "\n" +
                "Bonus: " + this.bonus + "\n" +
                "Vergi ve Bonuslarla birlikte maaş: " + ((this.salary - tax) + bonus) + "\n" +
                "Maaş Artışı: " + this.raise + "\n" +
                "Toplam Maaş: " + this.total + "\n" +
                "==============" ;
        return result;
    }

}
