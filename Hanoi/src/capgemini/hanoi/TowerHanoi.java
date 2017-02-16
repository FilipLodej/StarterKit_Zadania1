package capgemini.hanoi;

import java.util.List;
import java.util.Scanner;

public class TowerHanoi {

	private int liczbaKrazkow;
	private Palik podstawowy;
	private Palik pomocniczy;
	private Palik koncowy;

	public TowerHanoi() {
		podstawowy = new Palik("Podstawowy", liczbaKrazkow);
		pomocniczy = new Palik("Pomocniczy", liczbaKrazkow);
		koncowy = new Palik("Koncowy", liczbaKrazkow);
		wprowadzLiczbaKrazkow();
		podstawowy.wypelnijPalik(liczbaKrazkow);
		graj();
	}

	public int getLiczbaKrazkow() {
		return liczbaKrazkow;
	}

	public void setLiczbaKrazkow(int liczbaKrazkow) {
		this.liczbaKrazkow = liczbaKrazkow;
	}

	public void wprowadzLiczbaKrazkow() {
		Scanner sc = new Scanner(System.in);
		int liczbaKrazkow;
		do {
			System.out.println("Podaj liczbe krazkow na paliku, aby rozpoczac gre.");
			liczbaKrazkow = sc.nextInt(); // wylapac wyjatek
											// InputMismatchException

			if (liczbaKrazkow <= 0) {
				System.out.println("Podano nieprawidlowa liczbe.");
			}
		} while (liczbaKrazkow <= 0);
		setLiczbaKrazkow(liczbaKrazkow);
	}

	public void wyswietlStan() {
		System.out.println(podstawowy.toString() + "    " + pomocniczy.toString() + "    " + koncowy.toString());
	}

	public void przestawKrazek(Palik from, Palik to) {
		List<Krazek> listaKrazkowFrom = from.getListaKrazkow();
		List<Krazek> listaKrazkowTo = to.getListaKrazkow();
		if (listaKrazkowFrom.isEmpty()) {
			System.out.println("Nie ma krazkow na paliku do zabrania.");
		} else {
			Krazek a = listaKrazkowFrom.get(listaKrazkowFrom.size() - 1);
			if (listaKrazkowTo.isEmpty()) {
				listaKrazkowTo.add(a);
				listaKrazkowFrom.remove(a);
			} else {
				Krazek b = listaKrazkowTo.get(listaKrazkowTo.size() - 1);
				if (a.getSrednica() < b.getSrednica()) {
					listaKrazkowTo.add(a);
					listaKrazkowFrom.remove(a);
				} else {
					System.out.println("Nie mozna przneiesc krazka o wiekszej srednicy na mniejszy");
				}
			}
		}
	}

	public void wykonajRuch() {
		Scanner sc = new Scanner(System.in);
		int palikFrom;
		int palikTo;
		System.out.println(
				"Wprowadz numer palika z ktorego chcesz zabrac krazek? (1 - Podstawowy ; 2 - Pomocniczy; 3 - Koncowy)");
		palikFrom = sc.nextInt();
		System.out.println(
				"Wprowadz numer palika na ktory chcesz przeniesc krazek?(1 - Podstawowy ; 2 - Pomocniczy; 3 - Koncowy)");
		palikTo = sc.nextInt(); // wylapac wyjatek InputMismatchException
		if (palikFrom == 1 && palikTo == 2) {
			przestawKrazek(podstawowy, pomocniczy);
		} else if (palikFrom == 1 && palikTo == 3) {
			przestawKrazek(podstawowy, koncowy);
		} else if (palikFrom == 2 && palikTo == 3) {
			przestawKrazek(pomocniczy, koncowy);
		} else if (palikFrom == 2 && palikTo == 1) {
			przestawKrazek(pomocniczy, podstawowy);
		} else if (palikFrom == 3 && palikTo == 1) {
			przestawKrazek(koncowy, podstawowy);
		} else if (palikFrom == 3 && palikTo == 2) {
			przestawKrazek(koncowy, pomocniczy);

		} else {
			System.out.println("Podales nieprawidlowy numery palikow. Podaj raz jeszcze.");
		}

	}

	public void graj() {
		do {
			wyswietlStan();
			wykonajRuch();
		} while (!(podstawowy.getListaKrazkow().isEmpty() && pomocniczy.getListaKrazkow().isEmpty()));
		System.out.println("Lamiglowka rozwiazana! Gratulacje!!");
	}
}
