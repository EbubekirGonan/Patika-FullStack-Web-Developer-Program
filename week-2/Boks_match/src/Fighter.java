public class Fighter {
    //Fighter sınıfına dövüşçülerin isim, hasar, sağlık, ağırlık ve kaçınma nitelikleri tanımlandı.
    String name;
    int damage;
    int health;
    int weight;
    int dodge;


    //fighter parametreli kurucu methodu oluşturuldu.
    Fighter(String name, int damage, int health, int weight, int dodge){
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.weight = weight;
        if (dodge >= 0 && dodge <= 100){
            this.dodge = dodge;
        } else{
            this.dodge = 0;
        }
    }

    //Her dövüşçünün vuruş yaptığında rakibinin sağlığından eksilmesi sağlandı.
    int hit (Fighter foe){
        System.out.println(this.name + " => " + foe.name + " " + this.damage + " hasar vurdu.");
        if (foe.isDodge()){
            System.out.println(foe.name + " gelen hasarı blokladı. ");
            System.out.println("-------------");
            return foe.health;
        }
        //Eğer rakibin sağlığı alınan hasarla birlikte 0'ın altına düşmüşse, sağlık 0 olarak dödürüldü.
        if(foe.health - this.damage < 0){
            return 0;
        }
        //her vuruşta sağlıktan hasar çıkarıldı.
        return (foe.health - this.damage);
    }

    //kaçınma yüzdesi rastgele oluşturuldu.
    boolean isDodge(){
        double randomNumber = Math.random() * 100;
        return randomNumber <= this.dodge;
    }

}
