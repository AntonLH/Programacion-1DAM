/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays_bidimensionales3;

/**
 *
 * @author admin1
 */
public class Arrays_bidimensionales3 {

    /**
     * @param args the command line arguments
     */
    static int [ ][ ] array_clientes ={{200,210,111,612,123,0,78},{697,120,42,0,0,89,789},{0,0,377,366,300,490,345},{278,589,10,0,0,90,780},{123,45,78,0,230,180,100},{0,78,67,45,190,900,0}};
    static String[] bancos ={"BBVA","BBK","LA CAIXA","C. LABORAL", "SANTANDER", "KUTXA"};
    static String[] distritos ={"Deusto","Uribar.","Otxark.","Begoña", "Abando", "Rekalde","Basurto"};
    static int[] clientes_banco=new int [6];
    static int[] clientes_distrito=new int [7];
    static int total_total=0;
    
    
    public static void main(String[] args) {
        
        clientes_banco=clientesPorBanco(array_clientes);
        clientes_distrito=clientesPorDistrito(array_clientes);
        mostrarDatos(array_clientes,clientes_distrito,clientes_banco,bancos,distritos);
    }
        
    
    public static int[] clientesPorBanco(int[][] array_clientes){
        for (int i=0;i<array_clientes.length;i++){
            for (int j=0; j<array_clientes[0].length;j++){
                clientes_banco[i]+=array_clientes[i][j];
            }
        }
        return clientes_banco;
    }    
    public static int[] clientesPorDistrito(int[][] array_clientes){
        for (int i=0;i<array_clientes[0].length;i++){
            for (int j=0; j<array_clientes.length;j++){
                clientes_distrito[i]+=array_clientes[j][i];
                
            }
        }
        return clientes_distrito;

    }
    public static void mostrarDatos(int[][] array_clientes,int[]clientes_distrito,int[]clientes_banco, String[]bancos, String[]distritos){
        System.out.print("\t");
        for (int i=0;i<distritos.length;i++){
            System.out.print("\t"+distritos[i]);
        }
        System.out.print("\t Totales");
        System.out.println("");
        for(int i=0;i<array_clientes.length;i++){
            System.out.print(bancos[i]+"\t");
            if(i==0||i==1||i==5){
                System.out.print("\t");
            }

                for(int j=0;j<array_clientes[0].length;j++){
                System.out.print(array_clientes[i][j]+"\t");
            }
            System.out.print(clientes_banco[i]);

                System.out.println();
        }
        System.out.print("Tot:\t");

        for(int j=0;j<clientes_distrito.length;j++){
            System.out.print("\t"+clientes_distrito[j]);
            total_total+=clientes_distrito[j];
            
        }
        System.out.println("\t"+total_total);
        
        System.out.println("Lista de bancos ordenada por clientes:");
        
        for(int i=0;i<clientes_banco.length;i++){
            for(int j=i+1;j<clientes_banco.length;j++){
                if(clientes_banco[i]<clientes_banco[j]){
                   int p=clientes_banco[i];
                   clientes_banco[i]=clientes_banco[j];
                   clientes_banco[j]=p;
                   String c = bancos[i];
                   bancos [i]=bancos[j];
                   bancos [j]=c;
                }
            }
        }
            System.out.println("\tBANCO\t\tCLIENTES\n");
        for(int x=0;x<bancos.length;x++){
                    
            System.out.print("\t"+bancos[x]);
            if (x==2||x==3||x==4){
                System.out.print("\t");
            }
            System.out.println("\t"+clientes_banco[x]);
                

    }
}
}
