import java.math.BigInteger;
import java.util.*;
public class Teoria_Numeros3
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



   public static Vector Primos(int m, int n)
   {
	Vector  salida = new Vector(1);
	int k,mip,p,q,q2;
	int min = (m+1-3)/2;
	int max = (n-3)/2;
	int total = max-min+1;
	int sqrtn = BIsqrt(new BigInteger(""+n)).intValue();
	boolean[]   esPrimo  = new boolean[max+1];
	Vector primos;
	primos = Primos(sqrtn);

    if(0<= m && m < 3)
      return Primos(n);

	for(int i = 0; i < total; i++)
		esPrimo[i]=true;
    //primos(0)=2, inicia en primos(1)=3
	for(int i = 1; i< primos.size() ; i++)
	{ p =((Integer)primos.elementAt(i)).intValue();
	  if(m <= p*p)
	  { k=(p-1)/2;
		while((2*k+1)*p<=n)
		{
		  esPrimo[((2*k+1)*p-3)/2-min]=false;
		  k= k+1;
		}
	  }
	  if(p*p<m)
	  { q=(m-1)/p;
		q2=q%2;
		k=q2;
		mip=(2*k+1-q2+q)*p;
		while(mip<=n)
		{
		  esPrimo[(mip-3)/2-min]=false;
		  k= k+1;
		  mip=(2*k+1-q2+q)*p;
		}
	  }
	}
   //Imprimir
  for(int i = 0; i < total; i++)
      if(esPrimo[i])
         salida.addElement(new Integer(2*(i+min)+3));

   salida.trimToSize();
   return salida;
}// Primos m,n


 public static BigInteger BIsqrt(BigInteger n)
    {
      BigInteger DOS  = new BigInteger("2");
      BigInteger xkm1 = n.divide(DOS);
      BigInteger xk   = n;

      if(n.compareTo(BigInteger.ONE)< 0)
        return xkm1=n;
      while(xkm1.compareTo(xk)<0)
      {
          xk=xkm1;
          xkm1=xkm1.add(n.divide(xkm1));
          xkm1=xkm1.divide(DOS);
      }
      return xkm1;
    }//BIsqrt




//----------------------------------------------------------------//
 public static void main(String[] args)
 {     
      System.out.println("\n\n");
    //--------------------------------------------------------------
        //primos entre m,n
      int m  = 20;
      int nn = 50;
      Vector primosmn;
	         primosmn = Primos(m,nn);
      for(int j = 0; j < primosmn.size(); j++)
	  {       Integer num = (Integer)primosmn.elementAt(j);
	  	      System.out.println(""+(int)num.intValue());
      }
    //--------------------------------------------------------------
      System.out.println("\n\n");
 }//fin main
}//fin de la clase
