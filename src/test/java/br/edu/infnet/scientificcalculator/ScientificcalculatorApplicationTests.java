package br.edu.infnet.scientificcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ScientificcalculatorApplicationTests {

    private ScientificCalculator scientificCalculator;

    @BeforeEach
    void setup() {
        scientificCalculator = new ScientificCalculator();
    }

	@Test
	void contextLoads() {
	}
    @Test
    void adicionaNumerosPositivos() {
        double resultado = scientificCalculator.add(2, 3);
        assertEquals(5.0, resultado, 0.001);
    }
    @Test
    void subtraiNumerosPositivos() {
        //setup - arrange
        double a = 5;
        double b = 3;
        //execution - act
        double resultado = scientificCalculator.subtract(a, b);
        //assertion
        assertEquals(2.0, resultado, 0.001);
        //teardown
        //não há necessidade de limpar o ambiente para outros testes.
    }
    @Test
    void calculaRaizPositiva() {
        double raiz = 121;
        double resultado = scientificCalculator.squareRoot(raiz);
        assertEquals(11.0, resultado, 0.001);
    }
    @Test
    void calculaRaizNegativaLancaExcecao() {
        double numero = -9;
        assertThrows(IllegalArgumentException.class, () -> {
            scientificCalculator.squareRoot(numero);
        });
    }
    @Test
    void dividePorZeroLancaExcecao() {
        double dividendo = 10;
        double divisor = 0;
        assertThrows(IllegalArgumentException.class, () -> {
            scientificCalculator.divide(dividendo, divisor);
        });
    }
    @Test
    void calculaLogNumeroPositivo() {
        double numero = 1;
        double resultado = scientificCalculator.log(numero);
        assertEquals(0.0, resultado, 0.001);
    }
    @Test
    void calculaSenNumeroPositivo() {
        double angulo = 90;
        double resultado = scientificCalculator.sin(angulo);
        assertEquals(1.0, resultado, 0.001);
    }
//Métodos que merecem atenção são os que requerem exceção, os que
// precisam de mais de um teste para abranger os 100%.

//A cobertura mostra quais as partes do código foram testadas
// completamente, parcialmente e não foram testadas. Por meio de cores,
// conseguimos ajustar para ampliar a cobertura.

//Renomeados: testAddition para adicionaNumerosPositivos e subtraiNumerosPositivos para testSubtractPositive
//por não deixar claro o que o teste faz e prefiro no PT-BR.
}
