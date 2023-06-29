package com.api.crudDefinitivo.Controladores;

import com.api.crudDefinitivo.modelos.Usuario;
import com.api.crudDefinitivo.servicios.ServicioUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController /// la notación controller que contiene la utilizamos para definir que esta clase va a ser un controlador
/// la notación de responsebody se usa para indicar que el valor de retorno de nuestros métodos será por defecto un JSON.
@RequiredArgsConstructor
@RequestMapping("/user") /// ruta
public class UserController
{
    /// En esta clase van a ir todas las peticiones que hagamos

    /// El controlador se va a comunicar con los métodos de nuestra interfaz.
    /// Para ello importamos nuestro Servicio Usuario inyectándolo a través de autowired.

    @Autowired private ServicioUsuario servicioUsuario;

    public UserController(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    @PostMapping /// crear un nuevo usuario
    public ResponseEntity <Usuario> create(@RequestBody Usuario usuario)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicioUsuario.guardarUsuario(usuario));
    }
    /// Con el método create que acabamos de crear, vamos a recibir un usuario por parámetro
    /// y vamos a guardarlo y devolver un codigo de estado (201 si se crea correctamente).



    @RequestMapping (value = "/user")
    public List<Usuario> getUsuarios()
    {
        return this.servicioUsuario.getArrayUsuarios();
    }


    ///Recibimos un usuario que buscamos por ID
    @GetMapping(path="/{id}")  ///al ser un valor variable, va entre corchetes
    public Optional<Usuario> getUsuarioPorId(@PathVariable ("id") Long id)
    {
        return this.servicioUsuario.getUsuarioByID(id);
    }
    /// estaria bueno crear una excepcion en el caso de que no encuentre el ID que le pasamos

    @PutMapping(path="/{id}")
    public Usuario ModificarUsuarioPorID(@RequestBody Usuario request, @PathVariable Long id)
    {
        return this.servicioUsuario.ModificarById(request, id);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<?> EliminarPorID(@PathVariable("id") Long id)
    {
        if(!servicioUsuario.getUsuarioByID(id).isPresent())
        {
            return ResponseEntity.notFound().build();
        }
        servicioUsuario.EliminarUsuario(id);

        return ResponseEntity.ok().build();
    }


}
