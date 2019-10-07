
package controlador;


import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Usuario;
class UsuarioDAO {
 
    Conexion con;

    public UsuarioDAO() {
        this.con = new Conexion();
    }
   
    public ArrayList<Usuario> getUsuarios() {

        ArrayList<Usuario> Usuarios = new ArrayList<>();
        Connection accesoBD = con.getConexion();

        try {
            String sql = "SELECT * FROM usuario ";

            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);

            while (resultados.next()) {
                int id_usuario = resultados.getInt("id_usuario");
                String nombre = resultados.getString("nombre");
                
                

                Usuarios.add(new Usuario(id_usuario, nombre));
            }
            accesoBD.close();
            return Usuarios;
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }

    }

    public Usuario obtenerUsuario(int id_usuario) {

        Usuario u;
        Connection accesoBD = con.getConexion();

        try {
            String sql = "SELECT * FROM usuario WHERE id = " + id_usuario + " ";

            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.first()) {
                String nombre = rs.getString("nombre");
                

                u = new Usuario(id_usuario, nombre);
                accesoBD.close();
                return u;
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



    

