package joptimizer.pso.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class that describes the swarm
 *
 * @author José R. M. Júnior
 */
public class Swarm {

    Random rand = new Random(System.currentTimeMillis());
    /**
     * Particles of the swarm
     */
    private final List<Particle> particles;

    /**
     * Global best particle's position
     */
    private List<Double> gBestPosition;

    /**
     * Global best particle's cost
     */
    private double gBestCost;

    /**
     * Constructor of the class
     *
     * @param problem problem definition
     */
    public Swarm(PSOProblem problem) {
        particles = new ArrayList<>();
        gBestCost = Double.POSITIVE_INFINITY;

        for (int i = 0; i < problem.getPopulationSize(); i++) {

            // create the position and velocity vectors
            List<Double> position = new ArrayList<>(problem.getDimension());
            List<Double> velocity = new ArrayList<>(problem.getDimension());

            for (int j = 0; j < problem.getDimension(); j++) {
                position.add(problem.getMinVelocity() + rand.nextDouble()
                        * 2 * problem.getMaxVelocity());

                velocity.add(0.0);
            }

            // create the new particle
            Particle particle = new Particle(position, velocity,
                    problem.getCostFunction().evaluate(position));

            // set the best position and cost to the particle
            particle.setBestCost(particle.getCost());
            particle.setBestPosition(particle.getPosition());

            // update global best
            if (particle.getBestCost() < gBestCost) {
                gBestCost = particle.getBestCost();
                gBestPosition = particle.getPosition();
            }

            // add particle to the swarm
            particles.add(particle);
        }
    }

    /**
     * Method to get the best position on the swarm
     *
     * @return global best position
     */
    public List<Double> getGlobalBestPosition() {
        return this.gBestPosition;
    }

    /**
     * Method to get best position's cost
     *
     * @return global best cost
     */
    public double getGlobalBestCost() {
        return this.gBestCost;
    }

    /**
     * Method to get the particles
     *
     * @return particles list
     */
    public List<Particle> getParticles() {
        return particles;
    }

    /**
     * Method to set the best position of swarm
     *
     * @param gBestPosition position to set
     */
    public void setgBestPosition(List<Double> gBestPosition) {
        this.gBestPosition = gBestPosition;
    }

    /**
     * Method to set best position's cost
     *
     * @param gBestCost cost to set
     */
    public void setgBestCost(double gBestCost) {
        this.gBestCost = gBestCost;
    }

}
