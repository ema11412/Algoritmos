import java.math.BigInteger;
class PCR
{ PCR(){}
  public  BigInteger reprSimetrica(BigInteger m, BigInteger p)
  { BigInteger salida;
    BigInteger DOS  = new BigInteger("2");
    salida = m.mod(p);
    //representaci\'on sim\'etrica de Z_p =]-p/2,...-1,0,1,...,p/2]
    //si salida > p/2  -> salida= - p = -p/2 +i.    
  if(salida.compareTo(p.divide(DOS))==1)
       salida = salida.add(p.negate());
   return salida;
  }
  //Algoritmo Chino del Resto
  public static BigInteger Z_ACR(BigInteger Uis[], BigInteger Ms[])
  { //Requiere Ms[i]>2.
    int        n        = Ms.length-1; //Ms[0],...,Ms[n]
    BigInteger u        = BigInteger.ZERO;
    BigInteger producto = BigInteger.ONE;
    BigInteger temp;
    BigInteger gamma[]  = new BigInteger[n+1]; //gamma[1],...,gamma[n]
    BigInteger v[]      = new BigInteger[n+1];
    //para k=1,2,...,n, gamma_k = (Prod mi_{i=0}^{k-1})^{-1} Mod m_k.
    for(int k=1; k<=n; k++)
    {   producto = Ms[0].mod(Ms[k]);
        for(int i=1; i<= k-1; i++)
           producto = (producto.multiply(Ms[i])).mod(Ms[k]);
        gamma[k] = producto.modInverse(Ms[k]);
    }
    int j;
    v[0]=Uis[0];
    for(int k=1; k<=n; k++)
    {   temp = v[k-1];
        j=k-2;
        while(j>=0)
        {temp = ((temp.multiply(Ms[j])).add(v[j])).mod(Ms[k]);
         j=j-1;
        }
        v[k]= (Uis[k].subtract(temp)).multiply(gamma[k]).mod(Ms[k]);
    }
   u = v[n];
   j = n-1;
   while(j >= 0)
   {u = (u.multiply(Ms[j])).add(v[j]);
    j = j-1;
   }
   return u;
  }
  public static void main(String[] args)
  {
  System.out.print("\n\n");
  PCR        obj  = new PCR();

  BigInteger uis[]={new BigInteger("49"),new BigInteger("-21"),
                    new BigInteger("-30")};
  BigInteger mis[]={new BigInteger("99"),new BigInteger("97"),
                    new BigInteger("95")};

  System.out.println(""+obj.Z_ACR(uis, mis));
  System.out.print("\n\n");
  }
}
