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
	private ArrayList<Pasajero> losPasajerosVuelo = new ArrayList<Pasajero>();
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
												this.losPasajerosVuelo = losPasajerosVuelo;
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

	public ArrayList<Pasajero> getLosPasajerosVuelo() {
		return losPasajerosVuelo;
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
	
	
	
	

}
