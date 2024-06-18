package Implementacion;

public class Main {
    public static void main(String[] args) {

        //Agregar elementos al SuperConjunto
        ConjuntoEstatico superConjunto = new SuperConjunto();
        superConjunto.Agregar(1);
        superConjunto.Agregar(2);
        superConjunto.Agregar(3);
        superConjunto.Agregar(4);
        superConjunto.Agregar(5);
        superConjunto.Agregar(6);
        superConjunto.Agregar(7);
        superConjunto.Agregar(8);
        superConjunto.Agregar(9);
        superConjunto.Agregar(10);

        //subConjunto parte del superConjunto
        ConjuntoEstatico subConjunto = new ConjuntoEstatico();
        subConjunto.Agregar(2);
        subConjunto.Agregar(3);
        subConjunto.Agregar(5);
        subConjunto.Agregar(8);

        //SubConjunto NO parte del superConjunto
        ConjuntoEstatico subConjunto2 = new ConjuntoEstatico();
        subConjunto2.Agregar(2);  //este si pertenece
        subConjunto2.Agregar(11); //este no pertenece

        SuperConjunto sc = (SuperConjunto) superConjunto;

        System.out.println("SubConjunto: " );
        subConjunto.imprimirElementos();
        System.out.println("SubConjunto2: ");
        subConjunto2.imprimirElementos();

        System.out.println("subConjunto es subconjunto del superConjunto: " + sc.EsSubConjunto(subConjunto));

        System.out.println("subConjunto2 es subconjunto del superConjunto: " + sc.EsSubConjunto(subConjunto2));

        ConjuntoEstatico complemento = sc.Complemento(subConjunto);
        int[] elementosComplemento = complemento.getElementos();

        System.out.println("Complemento: ");
        for (int elem : elementosComplemento) {
            System.out.println(elem);
        }
    }
}