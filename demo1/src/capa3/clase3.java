package capa3;

public class clase3 {

    public void MetodoVoid()
    {
        int suma = 5+5;
    }

    public int metodoEntero()
    {
        int suma = 5+5;

        return suma;
    }

    public String metodoString(int n)//método con un parámetro
    {
        if(n == 0)//Usamos el parámetro en la función
        {
            return "a"; //Si n es cero retorna a
            //Notar que de aquí para abajo no se ejecuta nada más
        }
        return "x";//Este return sólo se ejecuta cuando n NO es cero
    }

    static boolean metodoBoolean(boolean n, String mensaje)//Método con dos parámetros
    {
        if(n)//Usamos el parámetro en el método
        {
            System.out.println(mensaje);//Mostramos el mensaje
        }
        return n; //Usamos el parámetro como valor a retornar
    }

}
