package joptimizer.pso.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Describes the solution of PSO
 *
 * @author José R. M. Júnior
 */
public class PSOSolution {

    /**
     * Best cost
     */
    private double bestCost;

    /**
     * Best position
     */
    private List<Double> bestPostion;

    /**
     * Historic of best cost through the optimization preocess
     */
    private List<Double> history;

    /**
     * Constructs a empty pso solution
     */
    public PSOSolution() {
        history = new ArrayList<>();
    }

    /**
     * Constructs a pso solution with informed data
     *
     * @param bestCost
     * @param bestPostion
     * @param history
     */
    public PSOSolution(double bestCost, List<Double> bestPostion, List<Double> history) {
        this.bestCost = bestCost;
        this.bestPostion = bestPostion;
        this.history = history;
    }

    /**
     * Method to get the best cost
     *
     * @return best cost
     */
    public double getBestCost() {
        return bestCost;
    }

    /**
     * Method to set the best cost
     *
     * @param bestCost cost to set
     */
    public void setBestCost(double bestCost) {
        this.bestCost = bestCost;
    }

    /**
     * Method to get the best position
     *
     * @return best position
     */
    public List<Double> getBestPostion() {
        return bestPostion;
    }

    /**
     * Method to set the best position
     *
     * @param bestPostion position to set
     */
    public void setBestPostion(List<Double> bestPostion) {
        this.bestPostion = bestPostion;
    }

    /**
     * Method to get the history of best costs
     *
     * @return history of costs
     */
    public List<Double> getHistory() {
        return history;
    }

    /**
     * Method to add a cost to the history
     *
     * @param cost cost to add
     */
    public void addToHistory(double cost) {
        this.history.add(cost);
    }

    /**
     * Method to set a history of costs
     *
     * @param history history to set
     */
    public void setHistory(List<Double> history) {
        this.history = history;
    }

}
