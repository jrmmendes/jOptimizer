package joptimizer.pso.core;

/**
 * Description of the pso parameters
 *
 * @author José R. M. Júnior
 */
public class PSOParameters {

    /**
     * Personal acceleration/learning coefficient
     */
    private final double personalAcceleration;

    /**
     * Social acceleration/learning coefficient
     */
    private final double socialAcceleration;

    /**
     * Inertial weight
     */
    private final double inertialWeight;

    /**
     * Damping ratio
     */
    private final double dampingRatio;

    private PSOParameters(
            double personalAcceleration,
            double socialAcceleration,
            double inertiaWeight,
            double dampingRatio) {
        this.personalAcceleration = personalAcceleration;
        this.socialAcceleration = socialAcceleration;
        this.inertialWeight = inertiaWeight;
        this.dampingRatio = dampingRatio;
    }

    /**
     * Generates a instance of the class' builder
     *
     * @return Instance of the class' builder
     */
    public static PSOParametersBuilder builder() {
        return new PSOParametersBuilder();
    }

    /**
     * Builder of the class
     */
    public static class PSOParametersBuilder {

        private double personalAcceleration = 2.05;
        private double socialAcceleration = 2.05;
        private double inertiaWeight = 1.0;
        private double dampingRatio = 1.0;
        private final double PHI = personalAcceleration + socialAcceleration;

        private boolean useConstriction = false;

        public PSOParametersBuilder personalAcceleration(double personalAcceleration) {
            this.personalAcceleration = personalAcceleration;
            return this;
        }

        public PSOParametersBuilder socialAcceleration(double socialAcceleration) {
            this.socialAcceleration = socialAcceleration;
            return this;
        }

        public PSOParametersBuilder inertiaWeight(double inertiaWeight) {
            this.inertiaWeight = inertiaWeight;
            return this;
        }

        public PSOParametersBuilder dampingRate(double dampingRate) {
            this.dampingRatio = dampingRate;
            return this;
        }

        public PSOParametersBuilder useConstriction() {
            this.useConstriction = true;
            return this;
        }

        public PSOParameters build() {

            if (this.useConstriction) {
                double phi = personalAcceleration + socialAcceleration;
                double chi = 2 / (phi - 2 + Math.sqrt(Math.pow(phi, 2) - 4 * phi));
                inertiaWeight = chi;
                personalAcceleration *= chi;
                socialAcceleration *= chi;
                dampingRatio = 1.0;
            }

            return new PSOParameters(
                    personalAcceleration,
                    socialAcceleration,
                    inertiaWeight,
                    dampingRatio);
        }

    }

    /**
     * Method to get the personal acceleration/learning coefficient
     *
     * @return personal acceleration coefficient
     */
    public double getPersonalAcceleration() {
        return personalAcceleration;
    }

    /**
     * Method to get the social/global acceleration/learning coefficient
     *
     * @return social acceleration coefficient
     */
    public double getSocialAcceleration() {
        return socialAcceleration;
    }

    /**
     * Method to get the inertial weight
     *
     * @return inertial weight
     */
    public double getInertialWeight() {
        return inertialWeight;
    }

    /**
     * Method to get the damping ratio of the inertial weight
     *
     * @return damping ratio
     */
    public double getDampingRatio() {
        return dampingRatio;
    }
}
