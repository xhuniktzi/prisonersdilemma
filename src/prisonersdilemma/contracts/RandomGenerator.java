/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package prisonersdilemma.contracts;

/**
 *
 * @author xhuni
 */
/**
 * Interfaz que define el contrato para generadores de números aleatorios.
 * Permite a los estudiantes implementar diferentes estrategias si lo desean.
 */

public interface RandomGenerator {
    /**
     * Genera un número decimal aleatorio entre 0.0 y 1.0.
     * @return Número decimal aleatorio
     */
    double nextDouble();

    /**
     * Reinicia el generador a su estado inicial con la seed original.
     */
    void reset();

}
