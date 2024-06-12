package interfaz;

public interface ConjuntoTDA {
	void InicializarConjunto();
	void Agregar(int x);
	void Sacar(int x);
	int Elegir();
	boolean Pertenece(int x);
	int Cantidad(int x);
	boolean ConjuntoVacio();
}
