import java.math.BigInteger;
public class rhoPollard
{
rhoPollard(){}

public BigInteger f(BigInteger x)
{
    return x.multiply(x).add(BigInteger.ONE);//x^2+1
}

 public  void FactorPollard(BigInteger N)
 {
     int i, k;
     BigInteger xi,xj;
     BigInteger g   = BigInteger.ONE;
     BigInteger x0  = new BigInteger(""+2);;
     boolean salir  = false;

     k = 0;
     xi= x0;
     xj= x0;
     while(salir==false)
     { i=(int)(Math.pow(2,k)-1);
       for(int j=i+1; j<=2*i+1; j++)
       {
           xj=f(x0).mod(N);
           if(xi.compareTo(xj)==0)//si son iguales
           {salir=true;
            System.out.print("Fallo"+"\n\n");
            break;
           }
           g= N.gcd(xi.subtract(xj));
           if(g.compareTo(BigInteger.ONE)==1 && g.compareTo(N)==-1)//1<g<N
           {salir=true;
            System.out.print("Factor = "+g+"\n\n");
            break;
           }
           x0=xj;
       }
       xi=xj;
       k++;
     }
     System.out.print(N+" =  "+g+" . "+N.divide(g)+"\n\n");
  }

  public static void main(String[] args)
  {
   System.out.print("\n\n");
      rhoPollard obj = new rhoPollard();
      BigInteger N = new BigInteger("10001449242860005111762859");
      obj.FactorPollard(N);
   System.out.print("\n\n");
 }
}//
