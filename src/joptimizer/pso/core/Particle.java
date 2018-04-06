package joptimizer.pso.core;

import java.util.List;
import java.util.Random;

/**
 * Class that describes the particle of PSO
 *
 * @author José R. M. Júnior
 */
public class Particle {

    Random rand = new Random();

    /**
     * Actual position of the particle in the search space
     */
    private final List<Double> position;

    /**
     * Velocity of the particle
     */
    private final List<Double> velocity;

    /**
     * Value of the objective function at the position of particle
     */
    private double cost;

    /**
     * Best position that the particle has experienced
     */
    private List<Double> bestPosition;

    /**
     * Value of the objective function at the best position of particle
     */
    private double bestCost;

    /**
     * Constructor of the class
     *
     * @param position initial position
     * @param velocity initial velocity
     * @param cost initial cost
     */
    public Particle(List<Double> position, List<Double> velocity, double cost) {
        this.position = position;
        this.velocity = velocity;
        this.cost = cost;
    }

    /**
     * Method to update the velocity of particle
     *
     * @param globalBestPosition position of the best particle on the whole
     * swarm
     * @param params parameters of the pso
     * @param max velocity upper bound
     * @param min velocity lower bound
     */
    public void updateVelocity(List<Double> globalBestPosition, PSOParameters params, double max, double min, int it) {
        if (position == null || position.isEmpty()) {
            throw new Error("The position is invalid on 'updateVelocity' method.");
        }

        if (velocity == null || velocity.isEmpty()) {
            throw new Error("The velocity is invalid  on 'updateVelocity' method.");
        }

        if (bestPosition == null || bestPosition.isEmpty()) {
            throw new Error("The best position is invalid  on 'updateVelocity' method.");
        }

        // updating the velocity
        for (int i = 0; i < velocity.size(); i++) {
            double v = params.getInertialWeight() * Math.pow(params.getDampingRatio(), it) * velocity.get(i)
                    + rand.nextDouble() * params.getPersonalAcceleration() * (bestPosition.get(i) - position.get(i))
                    + rand.nextDouble() * params.getSocialAcceleration() * (globalBestPosition.get(i) - position.get(i));

            velocity.set(i, Double.min(v, max));
            velocity.set(i, Double.max(v, min));

        }

    }

    /**
     * Method to update the position of particle
     *
     * @param max position upper bound
     * @param min position lower bound
     */
    public void updatePosition(double max, double min) {

        if (position == null || position.isEmpty()) {
            throw new Error("The position is invalid on 'updatePosition' method.");
        }

        if (velocity == null || velocity.isEmpty()) {
            throw new Error("The velocity is invalid on 'updatePosition' method.");
        }

        // updating the position
        for (int i = 0; i < position.size(); i++) {
            position.set(i, Double.min(position.get(i) + velocity.get(i), max));
            position.set(i, Double.max(position.get(i) + velocity.get(i), min));
        }
    }

    /**
     * Method to get the position
     *
     * @return Position
     */
    public List<Double> getPosition() {
        return position;
    }

    /**
     * Method to get the cost
     *
     * @return Cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * Method to get the best position
     *
     * @return Best Position
     */
    public List<Double> getBestPosition() {
        return bestPosition;
    }

    /**
     * Method to get the best cost
     *
     * @return Best Cost
     */
    public double getBestCost() {
        return bestCost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setBestPosition(List<Double> bestPosition) {
        this.bestPosition = bestPosition;
    }

    public void setBestCost(double bestCost) {
        this.bestCost = bestCost;
    }

}
