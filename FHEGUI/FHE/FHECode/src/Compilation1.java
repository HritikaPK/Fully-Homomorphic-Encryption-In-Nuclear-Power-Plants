
import java.util.*;
import com.ziroh.fhe.securenumeric.Key;
import com.ziroh.fhe.securenumeric.SecureNumericClient;
import ziroh.fhe.securenumeric.SecureNumeric;


public class Compilation1 {

    private Key key;
double output=0.00;
    public Compilation1(Key key) {
        this.key = key;
    }


    public static void main(String[] args) {
        System.out.println("This is just a main function. it isnt called");


    }


    public double Monte(int iter)
    {
        //System.out.println(" ");
        //System.out.println(" ");
        //System.out.print("************************* SIMPLE INTEGRATION ***********************************");
        //System.out.println(" ");
// //for integral of ct.dt

        /**
         * Create instance of numeric encryptor/decryptor client.
         */

        SecureNumericClient client=new SecureNumericClient(key);
        //SecureNumeric = new SecureNumeric();
        SecureNumeric secureNumeric=new SecureNumeric();

        double max = 60;
        double min = 0;
        double c = 0.1152;
        //double c = 0.4597;

        byte[] c_Cipher=client.encryptDouble(c);
        double diff = max - min;

        byte[] minCipher=client.encryptDouble(min);
        byte[] maxCipher=client.encryptDouble(max);
        byte[] diffCipher=client.encryptDouble(diff);

        Random r = new Random();

        double buffer = 0;
        byte[] bufferCipher=client.encryptDouble(buffer);


        for (int i = 0; i < iter; i++)
        {
            double rval = r.nextDouble();
            byte[] rvalCipher=client.encryptDouble(rval);
            byte[] maxmin= secureNumeric.SubtractDouble(maxCipher, minCipher); //max - min
            byte[] mult = secureNumeric.MultiplyDouble(rvalCipher, maxmin); // rval * (max - min)
            byte[] sumcipher = secureNumeric.AddDouble(mult, minCipher); // x = rval * (max - min) + min

            byte[] finalsumcipher = secureNumeric.AddDouble(bufferCipher, sumcipher); //finalsumcipher = t in our equation
            bufferCipher =  finalsumcipher;

            //byte[] finalsumCipher = secureNumeric.AddDouble(sumcipher, finalsumCipher); //sum = sum + x
            //double x = min + (max - min) * rval; // assign x in correct range
            //sum += x;

            // sum = buffer + x;
            // buffer = sum;

            if(i == (iter - 1))
            {
                //byte[] sumCipher=client.encryptDouble(sum);
                //byte[] answer = secureNumeric.MultiplyDouble(diffCipher, sumCipher);
                byte[] answer = secureNumeric.MultiplyDouble(diffCipher, finalsumcipher);

                byte[] answernew=secureNumeric.DivideDouble(answer, iter);
                byte[] answerfinal=secureNumeric.MultiplyDouble(answernew, c_Cipher);

                //double ans = diff * sum / iter;
                //System.out.println("Integral of c.t.dt = ");
                output=client.decryptDouble(answerfinal);
                //


            }
        }
        //System.out.println(" ");
        //System.out.println(" ");
        //System.out.println(" ");
        //return 0.0;
        return output;

    }

    public void MontePoly(int iter)
    {

        System.out.print("************************* POLYNOMIAL INTEGRATION ***********************************");
        System.out.println(" ");
//for integral of c(x^2+x)dx
        /**
         * Create instance of numeric encryptor/decryptor client.
         */

        SecureNumericClient client=new SecureNumericClient(key);
        //SecureNumeric = new SecureNumeric();
        SecureNumeric secureNumeric=new SecureNumeric();

        double max = 60;
        double min = 0;
        double c = 0.1152;
        byte[] c_Cipher=client.encryptDouble(c);
        double diff = max - min;

        byte[] minCipher=client.encryptDouble(min);
        byte[] maxCipher=client.encryptDouble(max);
        byte[] diffCipher=client.encryptDouble(diff);

        Random r = new Random();
        double sum = 0;
        double temp;

        double buffer = 0;
        byte[] bufferCipher=client.encryptDouble(buffer);
        byte[] bufferCipher2=client.encryptDouble(buffer);

        byte[] ans1 = null;
        byte[] ans2 = null;

        for (int i = 0; i < iter; i++)
        {
            double rval = r.nextDouble();
            byte[] rvalCipher=client.encryptDouble(rval);
            byte[] maxmin= secureNumeric.SubtractDouble(maxCipher, minCipher); //max - min
            byte[] mult = secureNumeric.MultiplyDouble(rvalCipher, maxmin); // rval * (max - min)
            byte[] sumcipher = secureNumeric.AddDouble(mult, minCipher); // x = rval * (max - min) + min

            byte[] finalsumcipher = secureNumeric.AddDouble(bufferCipher, sumcipher); //finalsumcipher = t in our equation
            bufferCipher =  finalsumcipher;

            //byte[] finalsumCipher = secureNumeric.AddDouble(sumcipher, finalsumCipher); //sum = sum + x
            //double x = min + (max - min) * rval; // assign x in correct range
            //sum += x;

            // sum = buffer + x;
            // buffer = sum;

            if(i == (iter - 1))
            {
                //byte[] sumCipher=client.encryptDouble(sum);
                //byte[] answer = secureNumeric.MultiplyDouble(diffCipher, sumCipher);
                byte[] answer = secureNumeric.MultiplyDouble(diffCipher, finalsumcipher);

                byte[] answernew=secureNumeric.DivideDouble(answer, iter);
                //byte[] answerfinal=secureNumeric.MultiplyDouble(answernew, c_Cipher);

                //double ans = diff * sum / iter;
                //System.out.println("Integral of = ");
                //System.out.println(client.decryptDouble(answernew));
                ans1 = answernew;

            }
        }

        for (int j = 0; j < iter; j++)
        {
            double rval2 = r.nextDouble();
            byte[] rval2Cipher=client.encryptDouble(rval2);
            byte[] maxmin2= secureNumeric.SubtractDouble(maxCipher, minCipher); //max - min
            byte[] mult2 = secureNumeric.MultiplyDouble(rval2Cipher, maxmin2); // rval * (max - min)
            byte[] sumcipher2 = secureNumeric.AddDouble(mult2, minCipher); // x = rval * (max - min) + min
            byte[] sumcipher3 = sumcipher2;
            byte[] sumcipherfinal = secureNumeric.MultiplyDouble(sumcipher2, sumcipher3); // x^2

            byte[] finalsumcipher2 = secureNumeric.AddDouble(bufferCipher2, sumcipherfinal); //finalsumcipher = t in our equation
            bufferCipher2 =  finalsumcipher2;

            //byte[] finalsumCipher = secureNumeric.AddDouble(sumcipher, finalsumCipher); //sum = sum + x
            //double x = min + (max - min) * rval; // assign x in correct range
            //sum += x;

            // sum = buffer + x;
            // buffer = sum;

            if(j == (iter - 1))
            {
                //byte[] sumCipher=client.encryptDouble(sum);
                //byte[] answer = secureNumeric.MultiplyDouble(diffCipher, sumCipher);
                byte[] answer2 = secureNumeric.MultiplyDouble(diffCipher, finalsumcipher2);

                byte[] answernew2=secureNumeric.DivideDouble(answer2, iter);
                //byte[] answerfinal=secureNumeric.MultiplyDouble(answernew, c_Cipher);

                //double ans = diff * sum / iter;
                //System.out.println("Integral of = ");
                //System.out.println(client.decryptDouble(answernew2));
                ans2= answernew2;


            }
        }
        byte[] finalans = secureNumeric.AddDouble(ans1, ans2); // x = rval * (max - min) + min
        byte[] cfinalans=secureNumeric.MultiplyDouble(finalans, c_Cipher);

        System.out.println("Final Integral of c(t+t^2).dt =  ");
        System.out.println(client.decryptDouble(cfinalans));

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");


    }

    public void SinFinal(int iter) {
        System.out.print("************************* SIN INTEGRATION ***********************************");
        System.out.println(" ");
//Integral of  (Integral of (sinx.dx).t.dt)
        /**
         * Create instance of numeric encryptor/decryptor client.
         */

        SecureNumericClient client=new SecureNumericClient(key);
        //SecureNumeric = new SecureNumeric();
        SecureNumeric secureNumeric=new SecureNumeric();


        // LIMITS HAVE TO BE UPTO 0 ONLY
        double max = 1.00;
        double min = 0.00;
        double diff = max - min;
        Random r = new Random();
        double sum=0.0;

        byte[] minCipher=client.encryptDouble(min);
        byte[] maxCipher=client.encryptDouble(max);
        byte[] diffCipher=client.encryptDouble(diff);



        byte[] sum2Cipher=client.encryptDouble(sum);


        for (int i = 0; i < iter; i++){
            double rval = r.nextDouble();

            // double x = min + (max - min) * rval;
            byte[] rvalCipher=client.encryptDouble(rval);
            byte[] maxmin= secureNumeric.SubtractDouble(maxCipher, minCipher); //max - min
            byte[] mult = secureNumeric.MultiplyDouble(rvalCipher, maxmin); // rval * (max - min)
            byte[] sumcipher = secureNumeric.AddDouble(mult, minCipher); // x = rval * (max - min) + min




            //double x2= (x * 180)/3.14;
            //sin func *******************************
            int n = 10; // number of terms in the Maclaurin series
            double sinX = 0.0;
            double sign = 1.0;
            byte[] powerCipher;
            powerCipher=sumcipher;
            double result = 1.0;
            double minusone= -1.0;
            byte[] sinXCipher=client.encryptDouble(sinX);
            byte[] signCipher=client.encryptDouble(sign);
            byte[] minusoneCipher=client.encryptDouble(minusone);

            // BUFFERS***************
            double buff1=0.0;
            double buff2=0.0;
            double buff3=1.0;
            double buff4=1.0;
            byte[] buff1Cipher=client.encryptDouble(buff1);
            byte[] buff2Cipher=client.encryptDouble(buff2);
            byte[] buff3Cipher=client.encryptDouble(buff3);
            byte[] buff4Cipher=client.encryptDouble(buff4);
            //*****************

            byte[] x_squareCipher;


            for (int d = 1; d <= n; d++) {
                int p = 2 * d - 1;
                // factorial start ******************
                {

                    for (int m = 1; m <= p; m++)
                    {
                        result *= m;
                    }
                }
                // factorial end *****************

                //term = signCipher * powerCipher / result;

                byte[] powbyresultCipher= secureNumeric.DivideDouble(powerCipher, result);
                byte[] term = secureNumeric.MultiplyDouble(signCipher,powbyresultCipher);

                //sinX += term;
                sinXCipher = secureNumeric.AddDouble(buff1Cipher, term); //finalsumcipher = t in our equation
                buff1Cipher =  sinXCipher;

                //sign = -1 * sign;
                buff3Cipher=signCipher;
                signCipher=secureNumeric.MultiplyDouble(minusoneCipher, buff3Cipher);

                //power *= x * x;
                x_squareCipher=secureNumeric.MultiplyDouble(sumcipher, sumcipher);
                buff4Cipher=powerCipher;
                powerCipher=secureNumeric.MultiplyDouble(buff4Cipher, x_squareCipher);

                // sinX= sinx
                //System.out.println("x is radian  = " + x);
                //System.out.println("x is degrees  = " + x2);

            }
            // System.out.println(" sin(x) = ");
            // System.out.println(client.decryptDouble(sinXCipher));

            // sin func finish *****************************

            //sum += sinX; // call lamdafn
            sum2Cipher=secureNumeric.AddDouble(sum2Cipher, sinXCipher);
            //buff2Cipher=sum2Cipher;


        }

        //double ans = diff * sum / iter;
        byte[] ans1 =secureNumeric.DivideDouble(sum2Cipher, iter);
        byte[] ans2=secureNumeric.MultiplyDouble(ans1, diffCipher);


        System.out.println("Integral of sin(x) = ");
        System.out.println(client.decryptDouble(ans2));
        //-----------------------------------------------------------------------


        //double c = 0.1152;
        byte[] c_Cipher= ans2;
        double max2 = 60;
        double min2 = 0;
        double diff2 = max2 - min2;

        byte[] min2Cipher=client.encryptDouble(min2);
        byte[] max2Cipher=client.encryptDouble(max2);
        byte[] diff2Cipher=client.encryptDouble(diff2);

        Random r2 = new Random();


        double bufferr = 0;
        byte[] bufferrCipher=client.encryptDouble(bufferr);


        for (int i = 0; i < iter; i++)
        {
            double rval = r2.nextDouble();
            byte[] rval2Cipher=client.encryptDouble(rval);
            byte[] maxmin2= secureNumeric.SubtractDouble(max2Cipher, min2Cipher); //max - min
            byte[] mult = secureNumeric.MultiplyDouble(rval2Cipher, maxmin2); // rval * (max - min)
            byte[] sumcipher = secureNumeric.AddDouble(mult, minCipher); // x = rval * (max - min) + min

            byte[] finalsumcipher = secureNumeric.AddDouble(bufferrCipher, sumcipher); //finalsumcipher = t in our equation
            bufferrCipher =  finalsumcipher;

            //byte[] finalsumCipher = secureNumeric.AddDouble(sumcipher, finalsumCipher); //sum = sum + x
            //double x = min + (max - min) * rval; // assign x in correct range
            //sum += x;

            // sum = buffer + x;
            // buffer = sum;

            if(i == (iter - 1))
            {
                //byte[] sumCipher=client.encryptDouble(sum);
                //byte[] answer = secureNumeric.MultiplyDouble(diffCipher, sumCipher);
                byte[] answer = secureNumeric.MultiplyDouble(diff2Cipher, finalsumcipher);

                byte[] answernew=secureNumeric.DivideDouble(answer, iter);
                byte[] answerfinal=secureNumeric.MultiplyDouble(answernew, c_Cipher);

                //double ans = diff * sum / iter;
                System.out.println("Integral of  (Integral of (sinx.dx).t.dt)  = ");
                System.out.println(client.decryptDouble(answerfinal));

                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");


            }
        }


    }

    public void SimpleIntegrationNoFhe (int iter)
    {
        System.out.print("************************* SIMPLE INTEGRATION NO FHE***********************************");
        System.out.println(" ");

        double max = 60;
        double min = 0;
        double c = 0.1152;
        double sum = 0;
        double t = 0;
        double diff = max - min;
        Random r = new Random();
        for (int i = 0; i < iter; i++)
        {
            double rval = r.nextDouble();
            t = rval * (max - min) + min;
            sum = sum + t;
            if(i == (iter - 1))
            {
                double ans1 = diff * sum / iter;
                double ans = ans1 * c;
                System.out.println("Integral of c.t.dt with no FHE= ");
                System.out.println(ans);
            }



        }


    }

    public void PolyNoFHE(int iter)
    {
        System.out.print("************************* POLYNOMIAL INTEGRATION NO FHE ***********************************");
        System.out.println(" ");
        double max = 60;
        double min = 0;
        double c = 0.1152;
        double sum = 0;
        double sum2 = 0;
        double t = 0;
        double t2 = 0;
        double diff = max - min;
        double ans1 = 1;
        double ans2 = 1;
        Random r = new Random();
        for (int i = 0; i < iter; i++)
        {
            double rval = r.nextDouble();
            t = rval * (max - min) + min;
            sum = sum + t;
            if(i == (iter - 1))
            {
                ans1 = diff * sum / iter;

            }
        }
        for (int i = 0; i < iter; i++)
        {
            double rval2 = r.nextDouble();
            t2 = rval2 * (max - min) + min;
            t2 = t2*t2;
            sum2 = sum2 + t2;
            if(i == (iter - 1))
            {
                ans2 = diff * sum2 / iter;

            }
        }
        double ans = ans1 + ans2;
        double answerfinal = ans * c;
        System.out.println("Integral of c(t^2+t).dt without FHE= ");
        System.out.println(answerfinal);


        System.out.println(" ");
        System.out.println(" ");
//		Instant endTime2 = Instant.now();
//	    Duration elapsedTime2 = Duration.between(startTime2, endTime2);
//	    System.out.println("Elapsed time: " + elapsedTime2.toMillis() + " milliseconds");
    }

    public void SinSimple(int iter) {

        System.out.print("************************* SIN INTEGRATION WITHOUT FHE ***********************************");
        System.out.println(" ");
        // LIMITS HAVE TO BE UPTO 0 ONLY
        double max = 1.00;
        double min = 0.00;
        double diff = max - min;
        Random r = new Random();
        double sum = 0;
        double temp;
        double answ = 0;

        for (int i = 0; i < iter; i++) {
            double rval = r.nextDouble();
            double x = min + (max - min) * rval;

            // int x=12;
            //double x2= (x * 180)/3.14;
            //sin func *********************************************************************************************
            int n = 10; // number of terms in the Maclaurin series
            double sinX = 0.0;
            double sign = 1.0;
            double power = x;
            double result = 1.0;

            for (int d = 1; d <= n; d++) {
                int p = 2 * d - 1;
                // factorial start **************************************************
                {

                    for (int m = 1; m <= p; m++)
                    {
                        result *= m;
                    }
                }
                // factorial end ***************************************************

                double term = sign * power / result;
                sinX += term;

                sign = -sign;
                power *= x * x;

            }


            // sin func finish *************************************************************************************

            sum += sinX; // call lamdafn
        }
        double ans = diff * sum / iter;
        System.out.println("Integral of sin(x) without using FHE = " + ans);
        //------------------------------------------------------
        System.out.println(" ");
        System.out.println(" ");

    }


    ////////fin
}
