package br.com.Joaomos.service;

import br.com.Joaomos.infra.DAO;
import br.com.Joaomos.model.Cargo;

public class CargoService {
	private final DAO<Cargo> cargoDAO = new DAO<>();
	
	public void registrarCargo(String nomeCargo, String nivelExperiencia) {
		Cargo cargo = new Cargo(nomeCargo, nivelExperiencia);
		cargoDAO.incluirAtomico(cargo);
		cargoDAO.fechar();
	}
	
	public boolean nomeCargoExiste(String nome) {
		Cargo cargo = cargoDAO.buscarPorNome(nome);
		return cargo != null;
	}
	public boolean nivelExperienciaExiste(String nivelExperiencia) {
		Cargo cargo = cargoDAO.buscarPorNivelExperiencia(nivelExperiencia);
		return cargo != null;
	}
}