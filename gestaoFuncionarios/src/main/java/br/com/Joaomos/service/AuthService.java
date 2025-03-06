package br.com.Joaomos.service;

import java.util.regex.Pattern;

import br.com.Joaomos.infra.DAO;
import br.com.Joaomos.model.Usuario;

public class AuthService {
	private final DAO<Usuario> usuarioDAO = new DAO<>();
	
	public boolean autenticar(String email, String senha) {
		Usuario usuario = usuarioDAO.buscarPorEmail(email);
		return usuario != null && usuario.getSenha().equals(senha);
	}
	
	public boolean usuarioExiste(String email) {
		Usuario usuario = usuarioDAO.buscarPorEmail(email);
		return usuario != null;
	}
	
	public boolean isSenhaIncorreta(String email, String senha) {
		Usuario usuario = usuarioDAO.buscarPorEmail(email);
		if(usuario != null &&  usuario.getSenha().equals(senha)) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        
        Pattern pattern = Pattern.compile(emailRegex);
        
        if (email == null) {
            return false;
        }
        
        return pattern.matcher(email).matches();
    }
	
	public void registrarUsuario(String nome, String email, String senha) {
        if (usuarioDAO.buscarPorEmail(email) != null) {
            throw new IllegalArgumentException("E-mail já cadastrado!");
        }
        Usuario novoUsuario = new Usuario(nome, email, senha);
        usuarioDAO.incluirAtomico(novoUsuario);
        usuarioDAO.fechar();
    }
	
	public String getNome(String email) {
		Usuario usuario = usuarioDAO.buscarPorEmail(email);
		return usuario.getNome();
	}
}