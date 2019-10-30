package Model;

import java.util.ArrayList;

public class GestorEquipo {
	
	public ArrayList<Equipo> losEquipos= new ArrayList<Equipo>();

	public ArrayList<Equipo> getLosEquipos() {
		return losEquipos;
	}

	public GestorEquipo(ArrayList<Equipo> losEquipos) {
		super();
		this.losEquipos = losEquipos;
	}
	
	

}
