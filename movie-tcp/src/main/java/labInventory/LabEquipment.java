package labInventory;

import java.io.Serializable;

/**
 * This class represents a piece of equipment in a laboratory.
 * It implements Serializable so RMI can send it through the network.
 *
 * Each equipment has a code, a name, a lab location, and a status (available or not).
 */
public class LabEquipment implements Serializable {

    private String code;
    private String name;
    private String laboratory;
    private boolean available;

    /**
     * Create a new equipment object.
     *
     * @param code the unique code, for example "PC-01"
     * @param name the name of the equipment, for example "Desktop Computer"
     * @param laboratory the lab where it lives, for example "Lab A"
     * @param available true if the equipment is free to use
     */
    public LabEquipment(String code, String name, String laboratory, boolean available) {
        this.code = code;
        this.name = name;
        this.laboratory = laboratory;
        this.available = available;
    }

    public String getCode()        { return code; }
    public String getName()        { return name; }
    public String getLaboratory()  { return laboratory; }
    public boolean isAvailable()   { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    /**
     * Return a readable description of this equipment.
     *
     * @return text with code, name, lab, and status
     */
    @Override
    public String toString() {
        String status = available ? "AVAILABLE" : "RESERVED";
        return code + " | " + name + " | " + laboratory + " | " + status;
    }
}
