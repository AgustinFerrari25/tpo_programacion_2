package Implementacion;

public class Main {
    public static void main(String[] args) {
        ConjuntoEstatico superConjunto = new SuperConjunto();
        superConjunto.Agregar(1);
        superConjunto.Agregar(2);
        superConjunto.Agregar(3);
        superConjunto.Agregar(4);
        superConjunto.Agregar(5);

        ConjuntoEstatico subConjunto = new ConjuntoEstatico();
        subConjunto.Agregar(2);
        subConjunto.Agregar(3);

        SuperConjunto sc = (SuperConjunto) superConjunto;

        System.out.println("Es subconjunto: " + sc.EsSubConjunto(subConjunto));

        ConjuntoEstatico complemento = sc.Complemento(subConjunto);
        int[] elementosComplemento = complemento.getElementos();

        System.out.println("Complemento: ");
        for (int elem : elementosComplemento) {
            System.out.println(elem);
        }
    }
}