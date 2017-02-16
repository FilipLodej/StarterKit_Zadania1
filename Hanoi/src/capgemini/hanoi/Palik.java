package capgemini.hanoi;

import java.util.ArrayList;
import java.util.List;

public class Palik {
	private String nazwa;
	private int liczbaKrazkowPalika;
	private List<Krazek> listaKrazkow = new ArrayList<Krazek>(liczbaKrazkowPalika);

	public List<Krazek> getListaKrazkow() {
		return listaKrazkow;
	}

	public void setListaKrazkow(List<Krazek> listaKrazkow) {
		this.listaKrazkow = listaKrazkow;
	}

	public Palik(String nazwa, int n) {
		this.nazwa = nazwa;
		this.liczbaKrazkowPalika = n;
	}

	public void wypelnijPalik(int n) {
		for (int i = n; i >= 1; i--) {
			Krazek krazek = new Krazek(i);
			listaKrazkow.add(krazek);
		}
	}

	public String toString() {
		return nazwa + listaKrazkow;
	}
}
