package br.ifpb.pweb1.beautyMarket.service;

import br.ifpb.pweb1.beautyMarket.model.Usuario;
import br.ifpb.pweb1.beautyMarket.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios() {
        return this.usuarioRepository.findAll();
    }

    @Transactional
    public Usuario criarOuAtualizarUsuario(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    public Usuario listarUsuario(Long id){
        return this.usuarioRepository.findById(id).orElse(null);
    }

    public void deletarUsuario(Long id) {
        this.usuarioRepository.deleteById(id);
    }

    public Usuario listarUsuarioPorEmail(String email) {
        return this.usuarioRepository.findByEmail(email).orElse(null);
    }
}
