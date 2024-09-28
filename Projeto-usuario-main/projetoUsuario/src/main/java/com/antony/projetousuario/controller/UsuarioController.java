package com.antony.projetousuario.controller;

import com.antony.projetousuario.model.Usuario;
import com.antony.projetousuario.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioController {

    private UsuarioService usuarioService;

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Integer id) {
        Usuario usuario = usuarioService.findById(id);
        return ResponseEntity.ok().body(usuario);
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> usuarios = usuarioService.findAll();
        return ResponseEntity.ok().body(usuarios);
    }

    @PostMapping("/usuarios/adicionar")
    public ResponseEntity<Usuario> addUser(@RequestBody Usuario usuario) {
        Usuario usuarioAdicionado = usuarioService.adicionarUsuario(usuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                                                .path("/usuario/{id}")
                                                .buildAndExpand(usuarioAdicionado.getId())
                                                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/usuario/update/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id,@RequestBody Usuario usuario) {
        Usuario updatedUsuario = usuarioService.update(id, usuario);
        return ResponseEntity.ok().body(updatedUsuario);
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
