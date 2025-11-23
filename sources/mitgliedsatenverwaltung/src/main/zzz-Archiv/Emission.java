package mitgliedsdatenverwaltung;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Emission implements Serializable {
	
	@Id
	private int ID;
	private String land;
    private String landCode;
    Double emission1990;
    Double emission2000;
    Double emission2010;
    Double emission2020;
    Double emission2030;
    Double emission2040;

	public Emission() {
		// Standard-Konstruktor für JPA
	}
	
	public Emission(int ID, String land, String landCode, Double emission1990, Double emission2000, Double emission2010, Double emission2020, Double emission2030, Double emission2040) {
		super(); // Ruft den Konstruktor der Elternklasse auf
		this.ID = ID;
		this.land = land;
		this.landCode = landCode;
		this.emission1990 = emission1990;
		this.emission2000 = emission2000;
		this.emission2010 = emission2010;
		this.emission2020 = emission2020;
		this.emission2030 = emission2030;
		this.emission2040 = emission2040;
	}

// Getter und Setter für alle Attribute
		
	public int getID(){
    	return ID;
    }

    public void setID(int ID){
    	this.ID = ID;
    }
    
	public String getLand(){
    	return land;
    }

    public void setLand(String land){
    	this.land = land;
    }
    
    public String getLandCode(){
    	return landCode;
    }

    public void setLandCode(String landCode){
    	this.landCode = landCode;
    }
    
    public Double getEmission1990(){
    	return emission1990;
    }

    public void setEmission1990(Double emission1990){
    	this.emission1990 = emission1990;
    }
    
    public Double getEmission2000(){
    	return emission2000;
    }

    public void setEmission2000(Double emission2000){
    	this.emission2000 = emission2000;
    }
    
    public Double getEmission2010(){
    	return emission2010;
    }

    public void setEmission2010(Double emission2010){
    	this.emission2010 = emission2010;
    }
    
    public Double getEmission2020(){
    	return emission2020;
    }

    public void setEmission2020(Double emission2020){
    	this.emission2020 = emission2020;
    }
    
    public Double getEmission2030(){
    	return emission2030;
    }

    public void setEmission2030(Double emission2030){
    	this.emission2030 = emission2030;
    }
    
    public Double getEmission2040(){
    	return emission2040;
    }

    public void setEmission2040(Double emission2040){
    	this.emission2040 = emission2040;
    }
}