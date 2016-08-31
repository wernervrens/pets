package leverno.pets;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author vern
 */
@XmlRootElement
public class Pet {
    
    public String type;
    public Double price;
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
    
}
