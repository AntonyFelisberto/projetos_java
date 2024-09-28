package com.antony.projetousuario.service;

import com.antony.projetousuario.exceptions.ObjectsException;
import com.antony.projetousuario.model.Usuario;
import com.antony.projetousuario.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public Usuario findById(Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElseThrow(() -> new ObjectsException(
                "Objeto não encontrado! Id:"+id+", Tipo "+Usuario.class.getName())
        );
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario adicionarUsuario(Usuario usuario) {
        usuario.setId(null);
        return usuarioRepository.save(usuario);
    }

    public Usuario update(Integer id, Usuario usuario) {
        Usuario usuarioAtualizado = findById(id);
        usuarioAtualizado.setSenha(usuario.getSenha());
        usuarioAtualizado.setNome(usuario.getNome());
        usuarioAtualizado.setLogin(usuario.getLogin());
        return usuarioRepository.save(usuarioAtualizado);
    }

    public void deleteById(Integer id) {
        usuarioRepository.findById(id);
        usuarioRepository.deleteById(id);
    }

    //METODOS DELETE,UPDATE E INSERT MELHORADOS

    public Usuario adicionarUsuarioWithHandler(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteByIdWithHandler(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

}
