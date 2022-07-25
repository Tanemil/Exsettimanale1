package Main;

import java.util.Scanner;

public class mainClass {
	
	private abstract class ElementoMultimediale{
		
		protected String title;
		protected int durata;
		
		public ElementoMultimediale() {
			this.title = "default";
			this.durata = 0;
		}
		
		public ElementoMultimediale(String stringaInput, int interoInput) {
			this.title = stringaInput;
			this.durata = interoInput;
		}
		
		public ElementoMultimediale(String stringaInput) {
			this.title = stringaInput;
			this.durata = 0;
		}
		
		public ElementoMultimediale(int interoInput) {
			this.title = "default";
			this.durata = interoInput;
		}
		
		public abstract void riproduci();
		
	}
	
	public class RegistrazioneAudio extends ElementoMultimediale {
		
		protected int volume;
		
		public RegistrazioneAudio() {
			super();
			volume = 0;
		}
		
		public RegistrazioneAudio(String stringa, int intero) {
			super(stringa, intero);
			volume = 0;
		}
		
		public RegistrazioneAudio(int intero) {
			super(intero);
			volume = 0;
		}
		
		public RegistrazioneAudio(String stringa) {
			super(stringa);
			volume = 0;
		}
		
		public void riproduci() {
			play();
		};
		
		public void abbassaVolume() {volume--;};
		
		public void alzaVolume() {volume++;};
		
		public void play() {
			String showVolume = "";
			for (int i = 0; i < volume; i++) {
				showVolume+="!";
			}
			for (int i = 0; i < durata; i++) {
				System.out.println(title + showVolume);
			}
		};
		
	}
	
	public class RegistrazioneVideo extends RegistrazioneAudio {
		
		protected int luminosita;
		
		public RegistrazioneVideo() {
			super();
		}
		
		public RegistrazioneVideo(String stringa, int intero) {
			super(stringa, intero);
			luminosita = 0;
		}
		
		public RegistrazioneVideo(int intero) {
			super(intero);
			luminosita = 0;
		}
		
		public RegistrazioneVideo(String stringa) {
			super(stringa);
			luminosita = 0;
		}
		
		public void play() {
			String showVolume = "";
			String showLuminosita = "";
			for (int i = 0; i < volume; i++) {
				showVolume+="!";
			}
			for (int i = 0; i < volume; i++) {
				showLuminosita+="*";
			}
			for (int i = 0; i < durata; i++) {
				System.out.println(title + " " + showVolume + " " + showLuminosita);
			}
		};
		
		public void riproduci() {
			play();
		};
		
		public void abbassaVolume() {volume--;};
		
		public void alzaVolume() {volume++;};
		
		public void aumentaLuminosita() {
			luminosita++;
		}
		
		public void diminuisciLuminosita() {
			luminosita--;
		}
		
	}
	
	public class MostaImmagine extends ElementoMultimediale {
		protected int luminosita;
		
		public MostaImmagine() {
			super();
			luminosita = 0;
		}
		
		public MostaImmagine(String stringa, int intero) {
			super(stringa, intero);
			luminosita = 0;
		}
		
		public MostaImmagine(int intero) {
			super(intero);
			luminosita = 0;
		}
		
		public MostaImmagine(String stringa) {
			super(stringa);
			luminosita = 0;
		}
		
		public void riproduci() {
			play();
		};
		
		public void play() {
			String showLuminosita = "";
			for (int i = 0; i < luminosita; i++) {
				showLuminosita+="*";
			}
			System.out.println(title + " " + showLuminosita);
		};
		
		public void aumentaLuminosita() {
			luminosita++;
		}
		
		public void diminuisciLuminosita() {
			luminosita--;
		}
	}
	
	public class LettoreMultimediale {
		private ElementoMultimediale[] arrayElementiMultimediali;
		
		public LettoreMultimediale(ElementoMultimediale elementoMultimediale1,
								   ElementoMultimediale elementoMultimediale2,
								   ElementoMultimediale elementoMultimediale3,
								   ElementoMultimediale elementoMultimediale4,
								   ElementoMultimediale elementoMultimediale5) {
			arrayElementiMultimediali = new ElementoMultimediale[5];
			arrayElementiMultimediali[0] = elementoMultimediale1;
			arrayElementiMultimediali[1] = elementoMultimediale2;
			arrayElementiMultimediali[2] = elementoMultimediale3;
			arrayElementiMultimediali[3] = elementoMultimediale4;
			arrayElementiMultimediali[4] = elementoMultimediale5;
		}
		
		public void showElementoMultimediale(int index) {
			if (index == 0) {
				System.out.println("riproduzione terminata");
				return;
			}
			arrayElementiMultimediali[index-1].riproduci();
		}
	}
	
	public static void main(String[] args) {
		
		mainClass b = new mainClass();
		
		RegistrazioneAudio elem1 = b.new RegistrazioneAudio("titolo 1",3);
		elem1.alzaVolume();
		elem1.alzaVolume();
		RegistrazioneAudio elem2 = b.new RegistrazioneAudio("titolo 2",2);
		elem2.alzaVolume();
		RegistrazioneVideo elem3 = b.new RegistrazioneVideo("titolo 3",2);
		elem3.alzaVolume();
		elem3.alzaVolume();
		elem3.alzaVolume();
		elem3.aumentaLuminosita();
		RegistrazioneVideo elem4 = b.new RegistrazioneVideo("titolo 4",3);
		elem4.alzaVolume();
		elem4.alzaVolume();
		elem4.alzaVolume();
		elem4.alzaVolume();
		elem4.aumentaLuminosita();
		elem4.aumentaLuminosita();
		MostaImmagine elem5 = b.new MostaImmagine("titolo 5");
		elem5.aumentaLuminosita();
		elem5.aumentaLuminosita();
		elem5.aumentaLuminosita();
		elem5.aumentaLuminosita();
		elem5.aumentaLuminosita();
		
		LettoreMultimediale lettore = b.new LettoreMultimediale(
					elem1,elem2,elem3,elem4,elem5
				);
		
		System.out.println("input a number between 0 and 5, with 0 being the exit");
		Scanner a = new Scanner(System.in) ;
		int placeholder = a.nextInt();
		while (placeholder <= 5 && placeholder != 0) {
			lettore.showElementoMultimediale(placeholder);
			System.out.println("input a number between 0 and 5, with 0 being the exit");
			a = new Scanner(System.in);
			placeholder = a.nextInt();
		}
		lettore.showElementoMultimediale(placeholder);
	}

}
