package Task;

import Task.Medicine_Structure.Medicine;
import Task.Medicine_Structure.Medicines;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractMedBuilder {
    protected Medicines medicines;

    public AbstractMedBuilder() {
        medicines = new Medicines();
    }

    public AbstractMedBuilder(Medicines medicines) {
        this.medicines = medicines;
    }

    public Medicines getMedicines() {
        return medicines;
    }

    abstract public Medicines parse(String fileName);
}
