package com.antony.projetousuario.service;

import com.antony.projetousuario.model.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuariosWithHandler")
@AllArgsConstructor
public class UsuarioControllerWithHandler {

    private UsuarioService usuarioService;

    @PutMapping("/usuario/update")
    public ResponseEntity<Usuario> update(@RequestBody Usuario usuario){
        Usuario usuarioAtualizado = usuarioService.updateUsuario(usuario);
        return ResponseEntity.ok().body(usuarioAtualizado);
    }

    @PutMapping("/usuarioWithHandler/update")
    public ResponseEntity<?> updateWithHandler(@RequestBody Usuario usuario){
        try{
            Usuario usuarioAtualizado = usuarioService.updateUsuario(usuario);
            return ResponseEntity.ok().body(usuarioAtualizado);
        }catch (Exception erro){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao atualizar usuario erro:"+erro.getMessage());
        }
    }

    @PostMapping("/usuarios/adicionar")
    public ResponseEntity<Usuario> addUser(@RequestBody Usuario usuario) {
        Usuario usuarioAdicionado = usuarioService.adicionarUsuarioWithHandler(usuario);
        return ResponseEntity.ok().body(usuarioAdicionado);
    }

    @PostMapping("/usuariosWithHandler/adicionar")
    public ResponseEntity<?> addUserWithHandler(@RequestBody Usuario usuario) {
        try{
            Usuario usuarioAdicionado = usuarioService.adicionarUsuarioWithHandler(usuario);
            return ResponseEntity.ok().body(usuarioAdicionado);
        }catch (Exception erro){
            return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body("Erro ao inserir usuario erro:"+erro.getMessage());
        }

    }

    @GetMapping("/usuariosWithHandler")
    public ResponseEntity<?> findAllWithHandler() {
        List<Usuario> usuarios = usuarioService.findAll();
        if (usuarios == null || usuarios.size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sem usuarios cadastrados");
        }else{
            return ResponseEntity.ok().body(usuarios);
        }
    }

    @DeleteMapping("/usuariosWithHandler/{id}")
    public ResponseEntity<?> deleteByIdWithHandler(@PathVariable Integer id) {
        try{
            usuarioService.deleteByIdWithHandler(id);
            return ResponseEntity.ok().body("Usuario deletado");
        }catch (Exception erro){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel deletar usuario erro: "+erro.getMessage());
        }
    }

}
