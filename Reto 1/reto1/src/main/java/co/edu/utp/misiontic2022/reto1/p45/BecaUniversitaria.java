package co.edu.utp.misiontic2022.reto1.p45;

public class BecaUniversitaria {

    // Atributos
    double pMonto;
    double pInteres;
    int pTiempo;
    Double interesSimple;
    Double interesCompuesto;

    //Constructores
    public BecaUniversitaria(){
        this.pMonto = 0.0;
        this.pInteres = 0.0;
        this.pTiempo = 0;
    }

    public BecaUniversitaria(int pTiempo, double pMonto, double pInteres){
        this.pTiempo = pTiempo;
        this.pInteres = pInteres;
        this.pMonto = pMonto;
    }
    
    //Metodos
    public double calcularInteresSimple( ){
        this.interesSimple = pMonto * (pInteres/100)*pTiempo;
        return Math.round(interesSimple);
    } 
    
    public double calcularInteresCompuesto( ){
        this.interesCompuesto = pMonto*(((Math.pow(1+(pInteres/100), pTiempo))-1));
        return Math.round(interesCompuesto);
    } 
    
    public String compararInversion (int pTiempo, double pMonto, double pInteres){
        this.pTiempo = pTiempo;
        this.pMonto = pMonto;
        this.pInteres = pInteres;
        this.calcularInteresCompuesto();
        this.calcularInteresSimple();
        double diferencia = interesCompuesto - interesSimple;
        return "La diferencia entre la proyección de interés compuesto e interés simple es: $" + (double) Math.round(diferencia);
    }

    public String compararInversion ( ){
        return "No se obtuvo diferencia entre las proyecciones, revisar los parámetros de entrada.";
    }

    public static void main(String[] args) {
        BecaUniversitaria becaUniversitaria = new BecaUniversitaria();
        System.out.println(becaUniversitaria.calcularInteresSimple());
        System.out.println(becaUniversitaria.calcularInteresCompuesto());
        System.out.println(becaUniversitaria.compararInversion(48,10000,2.0));
    }
}
