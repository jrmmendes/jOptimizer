package joptimizer.pso.core;

import java.util.List;

/**
 * Interface to the functions that can be optimized using PSO
 *
 * @author José R. M. Júnior
 */
public interface IObjectiveFunction {

    public double evaluate(List<Double> position);
}
