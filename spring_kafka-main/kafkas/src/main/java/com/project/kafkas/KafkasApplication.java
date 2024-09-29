package com.project.kafkas;


import com.project.kafkas.model.Venda;
import com.project.kafkas.resources.KafkaEnvio;
import com.project.kafkas.resources.KafkaRecebimento;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Random;


@SpringBootApplication
public class KafkasApplication {

	private static Random rand=new Random();
	private static long operacao=0;
	private static BigDecimal valorIngresso = BigDecimal.valueOf(500);

	public static void main(String[] args) {
		Venda venda = gerarVenda();

		KafkaEnvio producer = new KafkaEnvio();
		producer.enviar(venda);

		KafkaRecebimento consumer = new KafkaRecebimento();
		consumer.receber();

		SpringApplication.run(KafkasApplication.class, args);
	}

	private static Venda gerarVenda() {
		long cliente = rand.nextLong();
		int qtdIngressos = rand.nextInt(10);
		return new Venda(operacao++,cliente,qtdIngressos,valorIngresso.multiply(BigDecimal.valueOf(qtdIngressos)));
	}

}

