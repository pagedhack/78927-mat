using System;
using WSDL.mensajes;

namespace WSDL.operaciones
{
    public class Operaciones : Mensajes
    {
        List<string> saludos = new List<string>();
        public String Saludar(string nombre)
        {
            String msj = "Hola: " +nombre;
            saludos.add(msj);
            return msj;
        }
        public String Mostrar(int id)
        {
            return "x";
        }
    }
}