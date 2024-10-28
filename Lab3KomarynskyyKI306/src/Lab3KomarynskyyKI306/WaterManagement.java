package Lab3KomarynskyyKI306;

/**
 * The WaterManagement interface defines methods for managing water resources
 * and monitoring aquatic ecosystems.
 */
public interface WaterManagement {
    
    /**
     * Controls and assesses the quality of water in a water body.
     * This method should implement checks for various water quality parameters
     * such as pH, dissolved oxygen, contaminants, etc.
     */
    void controlWaterQuality();

    /**
     * Manages the vegetation in and around the water body.
     * This method should handle tasks related to aquatic plant life,
     * such as monitoring growth, controlling invasive species, etc.
     */
    void manageVegetation();

    /**
     * Monitors the overall ecosystem of the water body.
     * This method should implement comprehensive checks on the health and 
     * balance of the aquatic ecosystem, including fauna, flora, and their interactions.
     */
    void monitorEcosystem();
}