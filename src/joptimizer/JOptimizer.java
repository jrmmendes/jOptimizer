package joptimizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Sphere {

    public double evaluate(double[] position) {

        double sum = 0;
        for (Double x : position) {
            sum += Math.pow(x, 2);
        }

        return sum;
    }

}

class SParticle {

    public double[] position;
    public double[] velocity;
    public double cost;
    public double[] bestPosition;
    public double bestCost;
}

public class JOptimizer {

    private static Random rand = new Random();

    public static void main(String[] args) {
        // --- Problem definition --- //
        Sphere costFunction = new Sphere();
        int nVar = 5;
        int varMin = -10;
        int varMax = 10;

        // --- Parameters of PSO --- //
        int maxIt = 1000;
        int nPop = 50;
        double w = 0.5;
        double wdamp = 0.2;
        double c1 = 2.0;
        double c2 = 2.0;

        double[] globalBestPosition = new double[nVar];
        double globalBestCost = Double.POSITIVE_INFINITY;

        // --- Initialization --- //
        SParticle[] particles = new SParticle[nPop];

        for (int i = 0; i < nPop; i++) {
            SParticle particle = new SParticle();

            // generate random solution
            particle.position = unifrnd(varMin, varMax, nVar);

            // velocity
            particle.velocity = new double[nVar];

            // evaluation
            particle.cost = costFunction.evaluate(particle.position);

            // update personal best
            particle.bestCost = particle.cost;
            particle.bestPosition = particle.position;

            // update the global best
            if (particle.bestCost < globalBestCost) {
                globalBestPosition = particle.bestPosition;
                globalBestCost = particle.bestCost;
            }

            particles[i] = particle;
        }

        List<Double> bestCosts = new ArrayList<>(maxIt);

        // --- main loop --- //
        for (int it = 0; it < maxIt; it++) { // iteration
            for (int i = 0; i < nPop; i++) { // for each particle

                // update the velocity
                for (int j = 0; j < nVar; j++) { // for each coordinate
                    particles[i].velocity[j] = w * particles[i].velocity[j]
                            + c1 * rand.nextDouble() * (particles[i].bestPosition[j] - particles[i].position[j])
                            + c2 * rand.nextDouble() * (globalBestPosition[j] - particles[i].position[j]);

                }

                // update the position
                for (int j = 0; j < nVar; j++) {
                    particles[i].position[j] += particles[i].velocity[j];
                }

                // evaluation
                particles[i].cost = costFunction.evaluate(particles[i].position);

                // update personal best
                if (particles[i].cost < particles[i].bestCost) {
                    particles[i].bestCost = particles[i].cost;
                    particles[i].bestPosition = particles[i].position;

                    // update global best
                    if (particles[i].bestCost < globalBestCost) {
                        globalBestPosition = particles[i].bestPosition;
                        globalBestCost = particles[i].bestCost;
                    }
                }
            }

            bestCosts.add(globalBestCost);
            System.out.println("Iteration " + it + " best cost: " + globalBestCost);

            // damping of inertial weight
            w *= wdamp;
        }
    }

    public static double[] unifrnd(double varMin, double varMax, int size) {

        double[] vect = new double[size];
        for (int i = 0; i < vect.length; i++) {
            vect[i] = varMin + rand.nextDouble() * 2 * varMax;
        }

        return vect;
    }
}
