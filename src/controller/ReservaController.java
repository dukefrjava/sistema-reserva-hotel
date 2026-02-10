package controller;

import model.Reserva;
import viewer.ReservaViewer;

public class ReservaController {
	private static Reserva model;
	private ReservaViewer viewer;
	static Reserva[] reserva = new Reserva[10];

	public ReservaController(Reserva model, ReservaViewer viewer) {
		super();
		this.model = model;
		this.viewer = viewer;
	}

	public void setNomeHospede(String nome) {
		model.setNomeHospede(nome);
	}

	public String getNomeHospede() {
		return model.getNomeHospede();
	}

	public void setDiasHospedagem(int diasHospedagem) {
		model.setDiasHospedagem(diasHospedagem);
	}

	public int getDiasHospedagem() {
		return model.getDiasHospedagem();
	}

	public void setValorDiaria(double valorDiaria) {
		model.setValorDiaria(valorDiaria);
	}

	public double getValorDiaria() {
		return model.getValorDiaria();
	}

	public static double calcularValorTotal() {
		return model.getDiasHospedagem() * model.getValorDiaria();
	}

	public static Reserva buscaPorNome(String nome, Reserva[] reserva) {
		String nomeUpper = nome.toUpperCase();
		for (int i = 0; i < 10; i++) {
			if (reserva[i] != null && nomeUpper.equals(reserva[i].getNomeHospede().toUpperCase()))
				return reserva[i];
		}

		return null;
	}

	public static void ordenarPorNumDias(Reserva[] reserva) {
		for (int i = 0; i < reserva.length; i++) {
			for (int j = i; j < reserva.length; j++) {
				if (reserva[i] != null && reserva[j] != null
						&& reserva[j].getDiasHospedagem() > reserva[i].getDiasHospedagem()) {
					Reserva aux = reserva[i];
					reserva[i] = reserva[j];
					reserva[j] = aux;
				}
			}
		}
	}
}
