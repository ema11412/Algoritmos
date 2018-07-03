import java.util.Vector;
import java.math.BigInteger;

public class Ensayo_Error
{
    private Vector    salida = new Vector(1);
    static BigInteger Ge     = new BigInteger("10000000");//10^7
    BigInteger        UNO    = new BigInteger("1");
    BigInteger        DOS    = new BigInteger("2");
    BigInteger        TRES   = new BigInteger("3");
    BigInteger        SEIS   = new BigInteger("4");
    BigInteger        Nf;
    int               pos    = 1; //posici\'on del exponente del factor

    public Ensayo_Error(){}

    public BigInteger reducir(BigInteger Ne, BigInteger p)
    {
        int exp = 0, posAct = pos;
        BigInteger residuo;
        residuo =  Ne.mod(p);

        if(residuo.compareTo(BigInteger.ZERO)==0)
        {
          salida.addElement(p); //p es objeto BigInteger
          salida.addElement(BigInteger.ONE); //exponente
          pos = pos+2; //posici\'on del siguiente exponente (si hubiera)
        }

        while(residuo.compareTo(BigInteger.ZERO)==0)
        {
         Ne      =  Ne.divide(p); // Ne = Ne/p
         residuo =  Ne.mod(p);
         exp=exp+1;
         salida.set(posAct, new BigInteger(""+exp)); //p es objeto BigInteger
        }
        return Ne; 
     }//

    public Vector Factzar_Ensayo_Error(BigInteger Ne, BigInteger limG)
    {
        BigInteger p    = new BigInteger("5");
        Nf = Ne;
        Nf = reducir(Nf, DOS);
        Nf = reducir(Nf, TRES);

        while(p.compareTo(limG)<=0)
        {
          Nf= reducir(Nf, p);          //dividir por p
          Nf= reducir(Nf, p.add(DOS)); //dividir por p+2
          p = p.add(SEIS); //p=p+6
        }

        if(Nf.compareTo(BigInteger.ONE)>0)
        {
          salida.addElement(Nf); //p es objeto BigInteger
          salida.addElement(BigInteger.ONE); //exponente
        }
        return salida;
    }

    // Solo un argumento.
    public Vector Factzar_Ensayo_Error(BigInteger Ne)
    {
        BigInteger limG = Ge.min(BIsqrt(Ne));
        return Factzar_Ensayo_Error(Ne, limG);
    }
    public BigInteger BIsqrt(BigInteger n)
    {
                    BigInteger xkm1 = n.divide(DOS);
                    BigInteger xk   = n;

                      if(n.compareTo(BigInteger.ONE)< 0)
                        return xkm1=n;
                    while(xk.add(xkm1.negate()).compareTo(BigInteger.ONE)>0)
                    {
                        xk=xkm1;
                        xkm1=xkm1.add(n.divide(xkm1));
                        xkm1=xkm1.divide(DOS);
                    }
                    return xkm1;
      }
     //Imprimir
     public String print(Vector lista)
     {
        String tira="";
        for(int p = 0; p < lista.size(); p++)
        {
            if(p%2==0)     tira= tira+lista.elementAt(p);
            else           tira= tira+"^"+lista.elementAt(p)+" * ";
        }
        return tira.substring(0,tira.length()-3);
     }

    public static void main(String[] args)
    {
       BigInteger limG;
       BigInteger Nduro   = new BigInteger("2388005888439481");
       BigInteger N       = new BigInteger("27633027771706698949");
       Ensayo_Error Obj   = new Ensayo_Error();
       Vector   factores;

       factores = Obj.Factzar_Ensayo_Error(N); //factoriza

   //Imprimir vector de factores primos
   System.out.println("\n\n");
   System.out.println("N = "+N+"\n\n");
   System.out.println("Hay " +factores.size()/2+" factores primos <= " + Ge+"\n\n");
   System.out.println("N = "+Obj.print(factores)+"\n\n");
   System.out.println("\n\n");
    }
}
