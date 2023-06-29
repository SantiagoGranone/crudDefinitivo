package com.api.crudDefinitivo.repositorios;

import com.api.crudDefinitivo.modelos.Usuario;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
///import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

import static org.hibernate.hql.internal.antlr.HqlTokenTypes.FROM;
import static org.hibernate.loader.Loader.SELECT;

@Repository
@Transactional
/// Indicamos que es un repositorio. Quiere decir que nos permite hacer consultas a una base de datos
public interface I_ManejoUsuario extends JpaRepository <Usuario, Long>
{

    /// Los objetos que pide el JPArepository son dos genericos.
    /// Le paso un usuario y como clave el ID del user.

    @Query("SELECT user from Usuario usuario where usuario.nombre=:nombre")
    List<Usuario> findByNombre(@Param("nombre")String nombre);

}
