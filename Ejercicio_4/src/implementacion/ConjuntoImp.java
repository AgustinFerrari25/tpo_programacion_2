package implementacion;

import interfaz.ConjuntoTDA;

public class ConjuntoImp implements ConjuntoTDA{
	int[] arr;
	int[] cantidades;
	int[] elementos;
	int cant;
	
	@Override
	public void InicializarConjunto() {
		arr = new int[20];
		cantidades = new int[20];
		elementos = new int[20];
		cant = 0;
	}

	@Override
	public void Agregar(int x) {
		int pos = buscarElemento(x);
        if (pos == -1) {
            if (cant < elementos.length) {
                elementos[cant] = x;
                cantidades[cant] = 1;
                cant++;
            } else {
                System.out.println("El conjunto está lleno.");
            }
        } else {
            cantidades[pos]++;
        }
	}

	@Override
	public void Sacar(int x) {
		int pos = buscarElemento(x);
        if (pos != -1) {
            if (cantidades[pos] > 1) {
                cantidades[pos]--;
            } else {
                elementos[pos] = elementos[cant - 1];
                cantidades[pos] = cantidades[cant - 1];
                cant--;
            }
        }	
	}

	@Override
	public int Elegir() {
		return elementos[0];
	}

	@Override
	public boolean Pertenece(int x) {
		return buscarElemento(x) != -1;
	}
	
	@Override
	public int Cantidad(int x) {
        int pos = buscarElemento(x);
        if (pos != -1) {
            return cantidades[pos];
        } else {
            return 0;
        }
    }
	
	private int buscarElemento(int x) {
        for (int i = 0; i < cant; i++) {
            if (elementos[i] == x) {
                return i;
            }
        }
        return -1;
    }

	@Override
	public boolean ConjuntoVacio() {
		return (cant == 0);
	}
}
