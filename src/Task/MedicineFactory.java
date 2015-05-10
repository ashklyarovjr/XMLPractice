package Task;

import Task.Parsers.DOMParser;
import Task.Parsers.JDOMParser;
import Task.Parsers.SAXParser;


public class MedicineFactory  {
    private enum ParseByType {
        SAX, DOM, JDOM
    }

    public AbstractMedBuilder medsParser(String parserType) {
        ParseByType  type  = ParseByType.valueOf(parserType.toUpperCase());
        switch (type) {
            case DOM:
                return new DOMParser();
            case JDOM:
                return new JDOMParser();
            case SAX:
                return new SAXParser();
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }
    }
}
