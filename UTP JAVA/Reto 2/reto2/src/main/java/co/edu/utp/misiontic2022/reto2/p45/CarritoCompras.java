package co.edu.utp.misiontic2022.reto2.p45;

import java.util.ArrayList;

public class CarritoCompras {
    
    //Atributos
    private double totalVerduras;
    private double totalVerdurasOrganicas;
    private double totalVerdurasConvencionales;
    private ArrayList<Verdura> listaVerduras = new ArrayList<Verdura>();
    private int VerduraObsequio = -1;//Índice de la Verdura más costosa en el listado recibido (alojado)

    //Constructor
    public CarritoCompras(ArrayList<Verdura> pListaVerduras){
        this.listaVerduras = pListaVerduras;
        this.totalVerduras = 0;
        this.totalVerdurasOrganicas = 0;
        this.totalVerdurasConvencionales = 0;
    }

    public void mostrarTotales(){

        //Cantidad de productos convencionales y orgánicos
        int numConvencionales = 0;
        int numOrganicas = 0;

        for (int i = 0; i < this.listaVerduras.size(); i++) {
            
            if( this.listaVerduras.get(i) instanceof Convencional ){
                numConvencionales++;
                this.totalVerdurasConvencionales += this.listaVerduras.get(i).calcularPrecio();
            }else if( this.listaVerduras.get(i) instanceof Organica){
                
                numOrganicas++;
                this.totalVerdurasOrganicas += this.listaVerduras.get(i).calcularPrecio();

                if(this.VerduraObsequio == -1){
                    this.VerduraObsequio = i;
                }else{                    
                    if( this.listaVerduras.get(this.VerduraObsequio).calcularPrecio() <
                        this.listaVerduras.get(i).calcularPrecio() ){
                        this.VerduraObsequio = i;
                    }
                }        

            }else if(this.listaVerduras.get(i) instanceof Verdura){
                this.totalVerduras += this.listaVerduras.get(i).calcularPrecio();
            }

        }

        System.out.println("Valor Verduras cultivo convencional = " + this.totalVerdurasConvencionales);
        System.out.println("Valor Verduras cultivo orgánico = " + this.totalVerdurasOrganicas);

        double totalCompra = this.totalVerduras + this.totalVerdurasConvencionales + this.totalVerdurasOrganicas;

        if( numOrganicas > numConvencionales &&
            this.VerduraObsequio != -1
        ){
            
            double descuento = this.listaVerduras.get(this.VerduraObsequio).calcularPrecio() * 0.5; 
            totalCompra -= descuento;
        }
        //Error subido a plataforma sumatoria dos veces del total de Verduras que son intermediadas
        System.out.println("Valor total compra = " + (this.totalVerduras + totalCompra));
        //System.out.println("Valor total compra = " + (totalCompra));//Forma correcta 
        
    }
}