import java.util.Scanner;
class Solution{
    public static void main(String []argh)
    {



        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        for(int i=0;i<t;i++)
        {

            try
            {
                long x= sc.nextLong();
                System.out.println(x + " can be fitted in:");
                if ((x >= -128) && (128 >= x)) {
                    System.out.println("* byte");
                }
                if (x >= -32768 && x <= 32767) {
                    System.out.println("* short");
                }
                if (x >= Math.pow(-2, 31) && x <= (Math.pow(2,31) - 1)) {
                    System.out.println("* int");
                }
                if (x >= Math.pow(-2, 63) && x <= (Math.pow(2, 63) - 1)) {
                    System.out.println("* long");
                }

            }
            catch(Exception e)
            {
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }

        }
    }
}

/*
byte -128 to 127
short -32,768 -to 32,767
ınt -2,147,483,648 to 2,147,483,647
long –9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
*/
