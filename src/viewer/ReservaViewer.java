package viewer;

import java.util.Iterator;
import java.util.Scanner;

import controller.ReservaController;
import model.Reserva;

public class ReservaViewer {

	static Reserva[] reserva = new Reserva[10];
	static ReservaController controller;
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		menu: while (true) {
			System.out.println("MENU\n"
					+ "[NOVA RESERVA] - [1]\n[LISTAR RESERVA] - [2]\n[BUSCAR RESERVA] - [3]\n[ORDENAR RESERVAS] - [4]\n[SAIR] - [5]");
			int menu = scanner.nextInt();
			scanner.nextLine();

			switch (menu) {
			case 1:
				cadastrarReserva();
				continue menu;

			case 2:
				for (int i = 0; i < reserva.length; i++) {
					if (reserva[i] != null)
						System.out.println("\n--------------------------------------\n" + (i + 1) + "° " + ":\n"
								+ reserva[i] + "\n--------------------------------------");
				}
				continue menu;

			case 3:
				System.out.print("Qual nome deseja buscar? ");
				String nomeBusca = scanner.nextLine();
				System.out.println("Busca realizada:\n" + controller.buscaPorNome(nomeBusca, reserva));
				System.out.print("\n\n");
				continue menu;

			case 4:
				controller.ordenarPorNumDias(reserva);

				System.out.println("Ordenação de Reservas: ");
				for (int i = 0; i < reserva.length; i++) {
					if (reserva[i] != null)
						System.out.println("\n--------------------------------------\n" + (i + 1) + "° " + ":\n"
								+ reserva[i] + "\n--------------------------------------");
				}
				continue menu;

			case 5:
				break;
			}
			
			if (menu == 5)
				break;
		}
	}

	public static void cadastrarReserva() {

		double[] valorDiariaArray = new double[] { 500.0, 800.0, 1000.0 };
		int contador = 0;

		iniciarReserva: while (contador <= 10 || false) {
			System.out.print("Nome do hospede: ");
			String nome = scanner.nextLine();
			String nomeUpper = nome.toUpperCase();

			double valorDiaria;
			String tipoQuartoUpper;
			novamente: while (true) {
				System.out.print("Tipo de Quarto: ");
				String tipoQuarto = scanner.nextLine();
				tipoQuartoUpper = tipoQuarto.toUpperCase();

				System.out.print("Valor diaria para quarto escolhido: ");
				if (tipoQuartoUpper.equals("STANDART")) {
					valorDiaria = valorDiariaArray[0];
					System.out.println("R$ " + valorDiaria);
					break;
				} else if (tipoQuartoUpper.equals("LUXO")) {
					valorDiaria = valorDiariaArray[1];
					System.out.println("R$ " + valorDiaria);
					break;
				} else if (tipoQuartoUpper.equals("PRESIDENCIAL")) {
					valorDiaria = valorDiariaArray[2];
					System.out.println("R$ " + valorDiaria);
					break;
				} else {
					System.out.println("Tipo de Quarto INVÁLIDO! Entre novamente");
					continue novamente;
				}
			}

			System.out.print("Número de dias de estadia: ");
			int numEstadia = scanner.nextInt();
			scanner.nextLine();

			System.out.print("Deseja salvar? ");
			String resposta = scanner.nextLine();

			if (resposta.toUpperCase().equals("SIM")) {
				reserva[contador] = new Reserva(nomeUpper, tipoQuartoUpper, numEstadia, valorDiaria);
				controller = new ReservaController(reserva[contador], new ReservaViewer());
				System.out.println("Valor Total: " + controller.calcularValorTotal());
				contador++;

				System.out.print("Deseja continuar? ");
				String respostaContinuar = scanner.nextLine();

				if (respostaContinuar.toUpperCase().equals("SIM"))
					continue iniciarReserva;

				break;
			} else if (resposta.toUpperCase().equals("NÃO") || resposta.toUpperCase().equals("NAO")) {
				System.out.print("Deseja continuar? ");
				String respostaContinuar = scanner.nextLine();

				if (respostaContinuar.toUpperCase().equals("SIM"))
					continue iniciarReserva;

				break;
			}
		}
	}

}
