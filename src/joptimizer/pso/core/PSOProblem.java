package joptimizer.pso.core;

/**
 * Description of the optimization problem (needs javadoc complementation)
 *
 * @author José R. M. Júnior
 */
public class PSOProblem {

    /**
     * Particle's position upper bound
     */
    private final double maxPosition;

    /**
     * Particle's position lower bound
     */
    private final double minPosition;

    /**
     * Particle's velocity upper bound
     */
    private final double maxVelocity;

    /**
     * Particle's velocity lower bound
     */
    private final double minVelocity;

    /**
     * Dimension of the search space
     */
    private final int dimension;

    /**
     * Number of particles in the swarm
     */
    private final int populationSize;

    /**
     * Iterations limit
     */
    private final int maxIterations;

    /**
     * Minimum acceptable difference between two subsequent bestcosts
     */
    private final int minError;

    /**
     * Function that will be optimized
     */
    private final IObjectiveFunction costFunction;

    /**
     * Swarm's topology
     */
    private final PSOTopologyType topologyType;

    /**
     * Generates a instance of the class' builder
     *
     * @return Instance of the class' builder
     */
    public static PSOProblemBuilder builder() {
        return new PSOProblemBuilder();
    }

    private PSOProblem(
            double maxPosition,
            double minPosition,
            double maxVelocity,
            double minVelocity,
            int dimension,
            int populationSize,
            int maxIterations,
            int minError,
            IObjectiveFunction costFunction,
            PSOTopologyType topologyType) {
        this.maxPosition = maxPosition;
        this.minPosition = minPosition;
        this.maxVelocity = maxVelocity;
        this.minVelocity = minVelocity;
        this.dimension = dimension;
        this.populationSize = populationSize;
        this.maxIterations = maxIterations;
        this.minError = minError;
        this.costFunction = costFunction;
        this.topologyType = topologyType;
    }

    public static class PSOProblemBuilder {

        private double maxPosition;
        private double minPosition;
        private double maxVelocity;
        private double minVelocity;
        private int dimension;
        private int populationSize;
        private int maxIterations;
        private int minError;
        private IObjectiveFunction costFunction;
        private PSOTopologyType topologyType;

        public PSOProblemBuilder maxPosition(double maxPosition) {
            this.maxPosition = maxPosition;
            return this;
        }

        public PSOProblemBuilder minPosition(double minPosition) {
            this.minPosition = minPosition;
            return this;
        }

        public PSOProblemBuilder maxVelocity(double maxVelocity) {
            this.maxVelocity = maxVelocity;
            return this;
        }

        public PSOProblemBuilder minVelocity(double minVelocity) {
            this.minVelocity = minVelocity;
            return this;
        }

        public PSOProblemBuilder dimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public PSOProblemBuilder populationSize(int populationSize) {
            this.populationSize = populationSize;
            return this;
        }

        public PSOProblemBuilder maxIterations(int maxIterations) {
            this.maxIterations = maxIterations;
            return this;
        }

        public PSOProblemBuilder minError(int minError) {
            this.minError = minError;
            return this;
        }

        public PSOProblemBuilder costFunction(IObjectiveFunction costFunction) {
            this.costFunction = costFunction;
            return this;
        }

        public PSOProblemBuilder topologyType(PSOTopologyType topologyType) {
            this.topologyType = topologyType;
            return this;
        }

        public PSOProblem build() {
            return new PSOProblem(
                    maxPosition,
                    minPosition,
                    maxVelocity,
                    minVelocity,
                    dimension,
                    populationSize,
                    maxIterations,
                    minError,
                    costFunction,
                    topologyType);
        }
    }

    public double getMaxPosition() {
        return maxPosition;
    }

    public double getMinPosition() {
        return minPosition;
    }

    public double getMaxVelocity() {
        return maxVelocity;
    }

    public double getMinVelocity() {
        return minVelocity;
    }

    public int getDimension() {
        return dimension;
    }

    public int getPopulationSize() {
        return populationSize;
    }

    public int getMaxIterations() {
        return maxIterations;
    }

    public int getMinError() {
        return minError;
    }

    public IObjectiveFunction getCostFunction() {
        return costFunction;
    }

    public PSOTopologyType getTopologyType() {
        return topologyType;
    }
}
