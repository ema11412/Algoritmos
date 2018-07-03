import java.math.BigInteger;
import java.util.*;
public class Teoria_Numeros2
{
  static final BigInteger ZERO=new BigInteger("0");
  static final BigInteger ONE=new BigInteger("1");
  static final BigInteger TWO=new BigInteger("2");
  static final BigInteger THREE=new BigInteger("3");
  static final BigInteger FOUR=new BigInteger("4");
  
//--------------------- M\'etodos---------------------------------//   
public static Vector Primos(int n)
 {
            Vector        salida = new Vector(1);
            int k   = 1;
            int max = (n-3)/2;
            boolean[]   esPrimo  = new boolean[max+1];

            for(int i = 0; i <= max; i++)
                esPrimo[i]=true;

            for(int i = 0; (2*i+3) <= n/(2*i+3); i++)
            {
              k = i+1;
              if(esPrimo[i])
              {
                while( 2*k+1<= n/(2*i+3) )
                {
                    esPrimo[((2*k+1)*(2*i+3)-3)/2]=false;
                    k++;
                }
              }
             }
             salida.addElement(new Integer(2));
             for(int i = 0; i <=max; i++)
             { if(esPrimo[i])
               salida.addElement(new Integer(2*i+3));
             }
             salida.trimToSize();
             return salida; 
}//Fin M\'todo Primos

//----------------------------------------------------------------//
 public static void main(String[] args)
 {     
      System.out.println("\n\n");
    //--------------------------------------------------------------
      int    n = 20;
      Vector primos;
             primos = Primos(n);
      //Cantidad de primos <= n
      System.out.println("Primos <="+ n+": "+primos.size()+"\n");
      //Imprimir vector (lista de primos)
      for(int p = 1; p < primos.size(); p++)
      {
          Integer num = (Integer)primos.elementAt(p);
          System.out.println(""+(int)num.intValue());
      }
    //--------------------------------------------------------------
      System.out.println("\n\n");
 }//fin main
}//fin de la clase
