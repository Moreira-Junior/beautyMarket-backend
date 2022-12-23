package br.ifpb.pweb1.beautyMarket.controller;

import br.ifpb.pweb1.beautyMarket.model.Usuario;
import br.ifpb.pweb1.beautyMarket.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public List<Usuario> listarUsuarios(){
        return this.usuarioService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario listarUsuario(@PathVariable("id") Long id){
        return this.usuarioService.listarUsuario(id);
    }

    @GetMapping("/email/{email}")
    public Usuario listarUsuarioPorEmail(@PathVariable("email") String email){
        return this.usuarioService.listarUsuarioPorEmail(email);
    }

    @PostMapping()
    public Usuario criarUsuario(@RequestBody Usuario usuario){
        return this.usuarioService.criarOuAtualizarUsuario(usuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@RequestBody Usuario usuario){
        return this.usuarioService.criarOuAtualizarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable("id") Long id){
        this.usuarioService.deletarUsuario(id);
    }
}
