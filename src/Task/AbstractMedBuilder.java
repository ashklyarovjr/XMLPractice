package Task;

import Task.Medicine.Medicine;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractMedBuilder {
    List<Medicine> medicines = new ArrayList<>();

    public abstract ArrayList parse();


}
