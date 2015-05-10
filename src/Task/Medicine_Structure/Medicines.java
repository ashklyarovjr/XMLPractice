package Task.Medicine_Structure;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Anton on 5/8/2015.
 */
@XmlRootElement(name = "medicines")
public class Medicines {

    private List<Medicine> medicines;

    public Medicines() {
        medicines = new ArrayList<>();
    }

    public Medicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }


    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    public void addMedicine(Medicine medicine){
        getMedicines().add(medicine);
    }

    @Override
    public String toString() {
        return "Medicines: " + "\n" + medicines;
    }

    public Iterator<Medicine>  iterator() {
        return getMedicines().iterator();
    }
}
