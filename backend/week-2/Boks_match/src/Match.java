public class Match {

    //nitelikler tanımlandı.
    Fighter f1;
    Fighter f2;
    int minweight;
    int maxweight;



    //Eşleşme için gerekli parametreler tanımlandı.
    Match(Fighter f1,Fighter f2, int minweight, int maxweight){
        this.f1 = f1;
        this.f2 = f2;
        this.minweight = minweight;
        this.maxweight = maxweight;
    }


    //run methodu maçı başlatan ve sürdüren method.
    //sporcuların kiloları uyumlu mu, sağlıkları 0'dan yüksek mi
    //her rauntda ilk kim vuracak gibi çeşitli kontroller sağlanıyor.
    //sporculardan birinin canı 0'ın altına düşecek olursa maç sona eriyor.
    void run(){
        if (isCheck()){
            while(this.f1.health > 0 && this.f2.health > 0){
                System.out.println("====YENİ ROUND====");
                double randomNumber = Math.random() * 100;
                if (randomNumber < 50) {
                    this.f2.health = this.f1.hit(this.f2);
                    if (isWin()) {
                        break;
                    }
                    this.f1.health = this.f2.hit(this.f1);
                    if (isWin()) {
                        break;
                    }

                } else {
                    this.f2.health = this.f1.hit(this.f2);
                    if (isWin()) {
                        break;
                    }
                    this.f1.health = this.f2.hit(this.f1);
                    if (isWin()) {
                        break;
                    }
                }
                //her rauntta sporcuların sağlıkları yazdırılıyor.
                System.out.println(f1.name + " Sağlık: " + f1.health);
                System.out.println(f2.name + " Sağlık: " + f2.health);
            }

        } else {
            System.out.print("Sporcuların sikletleri uymuyor.");
        }
    }

    //sporcuların apırlıkları min ve max ağırlıklara uygun mu kontrolü
    boolean isCheck(){
        return (this.f1.weight >= minweight && this.f1.weight <= maxweight) && (this.f2.weight >= minweight && this.f2.weight <= maxweight);
    }

    //isWin kontrolü taraflardan birinin canının 0 olması halinde true'ya dönüyor.
    boolean isWin(){
        if(this.f1.health == 0){
            System.out.println(this.f2.name + " kazandı.");
            return true;
        }

        if(this.f2.health == 0){
            System.out.println(this.f1.name + " kazandı. ");
            return true;
        }
        return false;
    }
}
