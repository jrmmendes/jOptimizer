
import java.util.List;
import joptimizer.pso.core.IObjectiveFunction;
import joptimizer.pso.core.PSOParameters;
import joptimizer.pso.core.PSOProblem;
import joptimizer.pso.core.PSOProcess;
import joptimizer.pso.core.PSOSolution;
import joptimizer.pso.core.PSOTopologyType;

/**
 *
 * @author jrmmendes
 */
class Sphere implements IObjectiveFunction {

    @Override
    public double evaluate(List<Double> position) {
        double sum = 0;

        for (Double d : position) {
            sum += d * d;
        }

        return sum;
    }
}

public class TestJPSO {

    public static void main(String[] args) {
        PSOParameters parameters = PSOParameters
                .builder()
                .dampingRate(0.5)
                .inertiaWeight(1.0)
                .personalAcceleration(2.0)
                .socialAcceleration(2.0)
                .build();
        System.out.println("Starting...");

        PSOProblem problem = PSOProblem
                .builder()
                .costFunction(new Sphere())
                .dimension(10)
                .maxIterations(1000)
                .maxPosition(10.0)
                .minPosition(-10.0)
                .maxVelocity(10.0)
                .minVelocity(-10.0)
                .populationSize(30)
                .topologyType(PSOTopologyType.GBEST)
                .build();

        PSOProcess process = new PSOProcess();

        PSOSolution solution = process.execute(parameters, problem);
        System.out.println("---- results ----");
        System.out.println("best cost: " + solution.getBestCost());
        System.out.println("best position: " + solution.getBestPostion());
    }
}
