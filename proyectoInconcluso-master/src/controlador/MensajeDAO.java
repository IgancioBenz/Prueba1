
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Mensaje;
import modelo.Usuario;

class MensajeDAO {
 
    Conexion con;

    public MensajeDAO() {
        this.con = new Conexion();
    }


public ArrayList<Mensaje> getMensajes() {

        ArrayList<Mensaje> Mensajes = new ArrayList<>();
        Connection accesoBD = con.getConexion();

        try {
            String sql = "SELECT * FROM mensaje ";

            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);

            while (resultados.next()) {
                
                String id_mensaje = resultados.getString("id_mensaje");
                String emisor = resultados.getString("emisor");
                String remitente = resultados.getString("remitente");
                String contenido = resultados.getString("contenido");
                
                
                Mensajes.add(new Mensaje(id_mensaje, emisor, remitente, contenido));
            }
            accesoBD.close();
            return Mensajes;
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error al obtener mensaje");
            e.printStackTrace();
            return null;
        }

    }

    public Mensaje obtenerMensaje(int id_mensaje) {

        Mensaje m;
        Connection accesoBD = con.getConexion();

        try {
            String sql = "SELECT * FROM mensaje WHERE id = " + id_mensaje + " ";

            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.first()) {
                String contenido = rs.getString("contenido");
                

                m = new Mensaje(id_mensaje, contenido);
                accesoBD.close();
                return m;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error al obtener usuario");
            e.printStackTrace();
            return null;
        }

    }

    
    }



    

