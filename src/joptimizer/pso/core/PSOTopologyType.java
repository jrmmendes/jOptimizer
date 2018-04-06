package joptimizer.pso.core;

/**
 * Enum with the supported swarm topologies
 *
 * @author José R. M. Júnior
 * @version 1.0
 */
public enum PSOTopologyType {
    /**
     * Global best
     *
     * @since 1.0
     */
    GBEST(1, "Earch particle knows directly the position of the best particle on the whole swarm");

    /**
     * Code of the topology
     */
    private final int code;

    /**
     * Docstring of the topology
     */
    private final String description;

    private PSOTopologyType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * Method to get the code of topology
     *
     * @return code
     */
    public int getCode() {
        return code;
    }

    /**
     * Method to get the description of the topology
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }
}
