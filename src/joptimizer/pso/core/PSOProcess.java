package joptimizer.pso.core;

/**
 * Class that describes the optimization process
 *
 * @author José R. M. Júnior
 */
public class PSOProcess {

    public PSOSolution execute(PSOParameters params, PSOProblem problem) {
        PSOSolution solution = new PSOSolution();

        Swarm swarm = new Swarm(problem);

        for (int i = 0; i < problem.getMaxIterations(); i++) {

            for (Particle particle : swarm.getParticles()) {

                // update the velocity and position
                particle.updateVelocity(swarm.getGlobalBestPosition(), params, problem.getMaxVelocity(), problem.getMinVelocity(), i);
                particle.updatePosition(problem.getMaxPosition(), problem.getMinPosition());
                particle.setCost(problem.getCostFunction().evaluate(particle.getPosition()));

                if (particle.getCost() < particle.getBestCost()) {
                    particle.setBestPosition(particle.getPosition());
                    particle.setBestCost(particle.getCost());

                    if (particle.getBestCost() < swarm.getGlobalBestCost()) {
                        swarm.setgBestCost(particle.getBestCost());
                        swarm.setgBestPosition(particle.getBestPosition());
                    }
                }
                solution.addToHistory(swarm.getGlobalBestCost());
                System.out.println("Iteration " + i + ": best cost = " + swarm.getGlobalBestCost());
            }

        }
        solution.setBestCost(swarm.getGlobalBestCost());
        solution.setBestPostion(swarm.getGlobalBestPosition());

        return solution;
    }
}
