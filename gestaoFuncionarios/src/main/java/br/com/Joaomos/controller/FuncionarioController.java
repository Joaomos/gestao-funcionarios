package br.com.Joaomos.controller;

import java.util.Random;

public class FuncionarioController {

	public Long gerarId() {
		Random random = new Random();
        return 1000 + random.nextLong(1000);
	}
}
