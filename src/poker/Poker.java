
package poker;

import java.util.Scanner;

/**
 *
 * @author LuisRamirez
 */
public class Poker {
    int mano=3,cant_combinacion=3,tamano_muestra,grados_libertad;
    float estadistico=0,significancia;
    Scanner teclado=new Scanner(System.in);
     float[] Frec_Esperada=new float[mano];
     float[] Prob_comb=new float[cant_combinacion];
     int[] frec_observada=new int [mano];
     int[] mustra=new int[tamano_muestra];
    public static void main(String[] args) {
    }
    public void Pedir_datos(){
        System.out.println("Tamano de la muestra a tomar");
        tamano_muestra=teclado.nextInt();
        System.out.println("Porcentaje de nivel de confiabilidad [default: 95%]");
        significancia=teclado.nextFloat();
        
    }
    public void Calcular_Prob_Comb(){
       Prob_comb[0]=(float) (10*9*8/Math.pow(10, mano));
       Prob_comb[1]=(float) (10*1*1*1/Math.pow(10, mano));
       Prob_comb[2]=(float) (10*9*1*3/Math.pow(10, mano));
    }
    public void Calcular_Frec_Esp(){
       
       Frec_Esperada[0]=(float) (Prob_comb[0]*Math.pow(10, mano-1));
       Frec_Esperada[1]=(float) (Prob_comb[1]*Math.pow(10, mano-1));
       Frec_Esperada[2]=(float) (Prob_comb[2]*Math.pow(10, mano-1));
        
    }
    public void Calcular_Frec_Obs(){
        String num;
        frec_observada[0]=0;
        frec_observada[1]=0;
        frec_observada[2]=0;
        for (int i = 0; i < tamano_muestra; i++) {
            num=String.valueOf(mustra[i]);
            if(num.substring(0)!=num.substring(1)&&num.substring(0)!=num.substring(2)&&num.substring(1)!=num.substring(2))
                frec_observada[0]++;
            if((num.substring(0)==num.substring(1)&&num.substring(0)!=num.substring(2))||(num.substring(0)==num.substring(2)&&num.substring(0)!=num.substring(1))||(num.substring(1)==num.substring(2)&&num.substring(1)!=num.substring(0)))
                frec_observada[1]++;
            if(num.substring(0)==num.substring(1)&&num.substring(1)==num.substring(2))
                frec_observada[2]++;
        }
    }
    public void Calcular_estadistico(){
        for (int i = 0; i < mano; i++) {
            estadistico+=Math.pow(frec_observada[i]-Frec_Esperada[i],2)/(Frec_Esperada[i]);
        }
    }
    public void Comp_Tabla(){
        if(estadistico<0)
            System.out.println("Los numeros cumplen con la prueba de independencia");
    }
    public void Obtener_Muestra(){
        
        //muestra=leer(50);
    }
}
