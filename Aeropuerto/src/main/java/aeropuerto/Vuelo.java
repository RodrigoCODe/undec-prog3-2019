package aeropuerto;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Vuelo {
	
	private String codigoVuelo;
	private Aeropuerto salida;
	private Aeropuerto arribo;
	private LocalDateTime fechaHoraSalida;
	private LocalDateTime fechaHoraArribo;
	private Aerolinea laAerolineaVuelo;
	private ArrayList<Piloto> losPilotosVuelo = new ArrayList<Piloto>();
	private ArrayList<Asignacion> losPasajerosAsignados = new ArrayList<Asignacion>();
	private Avion elAvionVuelo;
	
	public Vuelo(String codigoVuelo, Aeropuerto salida, Aeropuerto arribo, LocalDateTime fechaHoraSalida,
			LocalDateTime fechaHoraArribo, Aerolinea laAerolineaVuelo, ArrayList<Piloto> losPilotosVuelo,
			ArrayList<Pasajero> losPasajerosVuelo, Avion elAvionVuelo) 
			throws ObjetoNoEncontradoException, StringNuloException , FechaIncorrectaException{
			
			if(codigoVuelo == "" || codigoVuelo ==null) {
				throw new StringNuloException("El codigo de vuelo no puede ser Nulo");
			}else {
				if(salida == null) {
					throw new ObjetoNoEncontradoException("EL Aeropuerto de Salida no se encuentra");
				}else {
					if(arribo == null) {
						throw new ObjetoNoEncontradoException("EL Aeropuerto de arribo no se encuentra");
					}else {
						if(fechaHoraSalida == null) {
							throw new ObjetoNoEncontradoException("La Fecha de Salida no se encuentra");
						}else { 
							if(fechaHoraSalida.isAfter(fechaHoraArribo)) {
								throw new FechaIncorrectaException("La Fecha de salida y arribo son incorrectas");
							}else {
								if(laAerolineaVuelo == null) {
									throw new ObjetoNoEncontradoException("La Aerolinea no se encuentra");
								}else {
									if(losPilotosVuelo.isEmpty()) {
										throw new ObjetoNoEncontradoException("Los Pilotos del vuelo no se encuentran");
									}else {
										if(losPasajerosVuelo.isEmpty()) {
											throw new ObjetoNoEncontradoException("Los Pasajeros del vuelo no se encuentran");
										}else {
											if(elAvionVuelo == null) {
												throw new ObjetoNoEncontradoException("EL Avion del vuelo no se encuentra");
											}else {
												this.codigoVuelo = codigoVuelo;
												this.salida = salida;
												this.arribo = arribo;
												this.fechaHoraSalida = fechaHoraSalida;
												this.fechaHoraArribo = fechaHoraArribo;
												this.laAerolineaVuelo = laAerolineaVuelo;
												this.losPilotosVuelo = losPilotosVuelo;
												this.losPasajerosAsignados = AsignarPasajerosAsiento(losPasajerosVuelo, elAvionVuelo.getLosAsientos());
												this.elAvionVuelo = elAvionVuelo;
												
											}
										}
									}
								}
							}
						}
					}
				}
			}
		
	}

	public String getCodigoVuelo() {
		return codigoVuelo;
	}

	public Aeropuerto getSalida() {
		return salida;
	}

	public Aeropuerto getArribo() {
		return arribo;
	}

	public LocalDateTime getFechaHoraSalida() {
		return fechaHoraSalida;
	}

	public LocalDateTime getFechaHoraArribo() {
		return fechaHoraArribo;
	}

	public Aerolinea getLaAerolineaVuelo() {
		return laAerolineaVuelo;
	}

	public ArrayList<Piloto> getLosPilotosVuelo() {
		return losPilotosVuelo;
	}

	public ArrayList<Asignacion> getLosPasajerosAsignados() {
		return losPasajerosAsignados;
	}
	
	
	public  ArrayList<Asignacion> AsignarPasajerosAsiento(ArrayList<Pasajero> losPasajerosQueViajan, ArrayList<Asiento> losAsientos) 
			throws ObjetoNoEncontradoException, StringNuloException{
		if(losPasajerosQueViajan.isEmpty()) {
			throw new ObjetoNoEncontradoException("Los Pasajeros No se encontraron");
		}else {
			
			for(Integer i=0; i< losPasajerosQueViajan.size() ;++i ) {
				Asignacion unaAsignacion = new Asignacion(i.toString(), losPasajerosQueViajan.get(i),
						losAsientos.get(i));
				losPasajerosAsignados.add(unaAsignacion);
			}
		}
		return losPasajerosAsignados;
	}
	

	public Avion getElAvionVuelo() {
		return elAvionVuelo; 
	}

	public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}

	public void setFechaHoraArribo(LocalDateTime fechaHoraArribo) {
		this.fechaHoraArribo = fechaHoraArribo;
	}
	
	public Pasajero traerPasajeroPorNumeroDeAsiento(String numeroAsiento) throws StringNuloException,ObjetoNoEncontradoException {
		Pasajero elPasajero=null;
		boolean exito=false;
		if(numeroAsiento == null || numeroAsiento == "") {
			throw new StringNuloException("El Numero de Asiento no es Valido");
		}else {
			for(int i=0;i<losPasajerosAsignados.size();++i) {
				if(losPasajerosAsignados.get(i).getElAsiento().getNumeroAsiento().equals(numeroAsiento)) {
					elPasajero = losPasajerosAsignados.get(i).getElPasajero();
					exito=true;
					break;
				}else{
                    exito=false; 
				}
			}
			if(exito==true){
                return elPasajero;
			}else{
                throw new ObjetoNoEncontradoException("El Pasajero no fue encontrado");
			}
		}
		
	}
	
}
