import java.math.BigInteger;
import java.util.*;
public class Miller_Rabin
{   
    static final BigInteger ZERO=new BigInteger("0");
    static final BigInteger ONE=new BigInteger("1");

   public Miller_Rabin(){}
    public boolean esPrimoMR(BigInteger N)
    {   //n>3 e impar. Respuesta 100% segura si N <341 550 071 728 321
        BigInteger  N1      = N.subtract(BigInteger.ONE);//N-1
        BigInteger  DOS     = new BigInteger("2");
        int[]       primo   = {2,3,5,7,11,13,17,19};
        int         s       = 0;
        boolean     esPrimo = true;
        BigInteger  a,r,y;
        int         j;   
        while(N1.remainder(DOS).compareTo(BigInteger.ZERO)==0)//n-1 = 2^s r
        {    N1=N1.divide(DOS);
             s=s+1;
        }
        r  = N1;
        N1 = N.subtract(BigInteger.ONE);
        for(int i=0; i<=7; i++)
        {   a = new BigInteger(""+primo[i]);
            y = a.modPow(r, N);
            if( y.compareTo(BigInteger.ONE)!=0 && y.compareTo(N1)!=0)
            { j=1;
               while(j<= s-1 && y.compareTo(N1)!=0 )
               {  y = y.modPow(DOS, N);
                  if(y.compareTo(BigInteger.ONE)==0) esPrimo=false;
                  j++;
               }
               if(y.compareTo(N1)!=0) esPrimo = false;
            }
        }
       return esPrimo;
    }

    public static void main(String[] args)
    {
      System.out.println("\n\n");
      BigInteger  N     = new BigInteger("10011572903");
      Miller_Rabin  obj = new Miller_Rabin();

      System.out.println(N+" es primo = "+obj.esPrimoMR(N)+"\n\n");

      System.out.println("\n\n");
    }
}
