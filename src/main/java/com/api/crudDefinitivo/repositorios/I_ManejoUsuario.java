package com.api.crudDefinitivo.repositorios;

import com.api.crudDefinitivo.modelos.Usuario;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
///import org.springframework.stereotype.Repository;

import java.util.List;

import static org.hibernate.hql.internal.antlr.HqlTokenTypes.FROM;
import static org.hibernate.loader.Loader.SELECT;

///@Repository
/// Indicamos que es un repositorio. Quiere decir que nos permite hacer consultas a una base de datos
public interface I_ManejoUsuario extends JpaRepository <Usuario, Long>
{
    /// Los objetos que pide el JPArepository son dos genericos.
    /// Le paso un usuario y como clave el ID del user.

    /*
    List<Usuario> RetornarTodosLosUsuarios();

     @Query (SELECT com.api.crudDefinitivo.UsuarioDTO S(S.id, S.nombre, S.apellido, S.legajo)
           + "FROM Usuario S")
    List<Usuario> RetornarTodosLosUsuariosConAtributos();
    */
}
