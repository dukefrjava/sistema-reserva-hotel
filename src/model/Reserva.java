package model;

import controller.ReservaController;

public class Reserva {
	protected String nomeHospede;
	protected String tipoQuarto;
	protected int diasHospedagem;
	protected double valorDiaria;
	
	public Reserva(String nomeHospede, String tipoQuarto, int diasHospedagem, double valorDiaria) {
        this.nomeHospede = nomeHospede;
        this.tipoQuarto = tipoQuarto;
        this.diasHospedagem = diasHospedagem;
        this.valorDiaria = valorDiaria;
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public void setNomeHospede(String nomeHospede) {
        this.nomeHospede = nomeHospede;
    }
    
    public String getTipoQuarto() {
		return tipoQuarto;
	}

	public void setTipoQuarto(String tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}

	public int getDiasHospedagem() {
        return diasHospedagem;
    }

    public void setDiasHospedagem(int diasHospedagem) {
        this.diasHospedagem = diasHospedagem;
    }
    
    public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	
	@Override
	public String toString() {
		return "\n\nReserva {\n" + "Nome Hospede = " + nomeHospede + "\nTipo de Quarto = " + tipoQuarto
				+ "\nDias Hospedagem = " + diasHospedagem + "\nValor Total = " + ReservaController.calcularValorTotal() + '\n' + '}';
	}
}
