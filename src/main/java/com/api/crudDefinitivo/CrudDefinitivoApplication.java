package com.api.crudDefinitivo;

import com.api.crudDefinitivo.Controladores.UserController;
import com.api.crudDefinitivo.modelos.Usuario;
import com.api.crudDefinitivo.repositorios.I_ManejoUsuario;
import com.api.crudDefinitivo.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.api.crudDefinitivo.modelos.Usuario;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class CrudDefinitivoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDefinitivoApplication.class, args);


		ServicioUsuario servicioUsuario= new ServicioUsuario();

		List<Usuario> usuarios= new ArrayList<>();

		usuarios= servicioUsuario.getArrayUsuarios();

		for(Usuario usuario: usuarios) {
			System.out.println(usuario.toString());
		}

	}
}
