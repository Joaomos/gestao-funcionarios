package br.com.Joaomos.service;

import java.util.Random;

public class FuncionarioService {

	public Long gerarId() {
		Random random = new Random();
        return 1000 + random.nextLong(1000);
	}
}
