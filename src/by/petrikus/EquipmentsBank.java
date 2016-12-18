package by.petrikus;

/**
 * Created by user on 10.12.2016.
 */
public class EquipmentsBank {
    private int value;
    private boolean wear;
    private String type;
    private String effect;
    private String name;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isWear() {
        return wear;
    }

    public void setWear(boolean wear) {
        this.wear = wear;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
