import com.ziroh.fhe.securenumeric.Key;
import com.ziroh.fhe.securenumeric.KeyGenerator;

public class Client {
    double output_d;
    String output;
    public static void main(String[] args) {
    }
    public String input(int c, int a)
    {

        //Scanner scanner = new Scanner(System.in);

        //System.out.print("Enter an integer to generate random points: ");
        int iter = a;
        int choice=c;

        KeyGenerator keyGen = new KeyGenerator();
        Key key = keyGen.generateKey();

        Compilation1 server = new Compilation1(key);
        if(choice==1) {
            output_d=server.Monte(iter);
             output=Double.toString(output_d);
        }
        else if(choice==3) {
            //output=server.MontePoly(iter);
        }
        else if(choice==2) {
            //output=server.SinFinal(iter);
        }

        return output;
    }
}
