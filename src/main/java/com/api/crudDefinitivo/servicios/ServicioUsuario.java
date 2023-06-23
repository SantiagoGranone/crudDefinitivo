package com.api.crudDefinitivo.servicios;

import com.api.crudDefinitivo.modelos.Usuario;
import com.api.crudDefinitivo.repositorios.I_ManejoUsuario;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioUsuario {
    /// sirve para la inyección de dependencias, la lógica de negocio.
    @Autowired
    I_ManejoUsuario manejoUsuario;

    public ServicioUsuario() {
    }

    public ArrayList <Usuario> getArrayUsuarios() {
        ArrayList <Usuario> usuarios= new ArrayList<>();
        for(Usuario usuario: this.manejoUsuario.findAll())
        {
            usuarios.add(usuario);
        }
        return usuarios;
    }
    /// el findAll es un metodo que viene en JPArepository que importamos en nuestra interfaz
    /// hace un mapeo de todos los usuarios en nuestra base de datos.


    public Usuario guardarUsuario(Usuario unusuario) {
        return manejoUsuario.save(unusuario);
    }

    public Optional <Usuario> getUsuarioByID (Long id)
    {
        return manejoUsuario.findById(id);
    }

    /// ACA FALTA HACER UN TRY CATCH DE EXEPTION CUANDO NO ENCUENTRE EL USER
    public Usuario ModificarById (Usuario request, Long id)
    {
        Usuario user= manejoUsuario.findById(id).get();

        /// a traves del metodo copyProperties de la clase BeanUtils
        /// podemos copiar directamente nuestro obj entero para modificar
        /// todos sus atributos directamente sin setear uno por uno
        ///-------- BeanUtils.copyProperties(request, user);----------
        /// como no quiero actualizar el ID, no lo utilizo

        user.setNombre(request.getNombre());
        user.setApellido(request.getApellido());
        user.setEmail(request.getEmail());
        user.setLegajo(request.getLegajo());
        manejoUsuario.save(user);

        return user;
    }

    public Boolean EliminarUsuario(Long id)
    {
        try
        {
            manejoUsuario.deleteById(id);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
}
