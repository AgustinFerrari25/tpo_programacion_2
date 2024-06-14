package Implementacion;

public class SuperConjunto extends ConjuntoEstatico {

    public boolean EsSubConjunto(ConjuntoEstatico conjunto) {
        int[] elementosConjunto = conjunto.getElementos();
        for (int elemento : elementosConjunto) {
            if (!this.Pertenece(elemento)) {
                return false;
            }
        }
        return true;
    }

    public ConjuntoEstatico Complemento(ConjuntoEstatico conjunto) {
        if (!EsSubConjunto(conjunto)) {
            throw new IllegalArgumentException("El conjunto no es un subconjunto del superconjunto.");
        }

        ConjuntoEstatico complemento = new ConjuntoEstatico();
        int[] elementosSuperConjunto = this.getElementos();
        int[] elementosConjunto = conjunto.getElementos();

        for (int elemento : elementosSuperConjunto) {
            if (!conjunto.Pertenece(elemento)) {
                complemento.Agregar(elemento);
            }
        }

        return complemento;
    }
}