package list;
public interface EstruturaElementar {
    //Métodos Consultivos
    public boolean buscaElemento(int valor);
    public int buscaIndice(int valor);
    public int minimo();
    public int maximo();
    public int predecessor(int valor);
    public int sucessor(int valor);

    //Metodos Modificadores
    public void insereElemento(int valor);
    public void insereElementoPosicao(int valor, int buscaIndice);
    public void insereInicio(int valor);
    public void insereFim(int valor);
    
    public void remove(int valor);
    public void removeIndice(int indice);
    public void removeInicio();
    public void removeFim();
}
