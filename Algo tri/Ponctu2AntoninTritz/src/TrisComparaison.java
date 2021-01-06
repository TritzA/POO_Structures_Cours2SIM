import java.util.Arrays;

import javax.swing.JOptionPane;

/*
 * Chronométrage des différentes méthodes de tri
 * Structures de données 420-SCB
 */

public class TrisComparaison {

		public static void main(String[] args) {
			long t1,t2;
			int nbElements = Integer.parseInt(JOptionPane.showInputDialog("Entrez le nombre d'éléments désirés dans la table"));
			int table[] = new int[nbElements];
			int copieDeTable[] = new int[nbElements];
			int tSelec, tBulle, tEnu, tInser;
			
			for (int k = 0; k < nbElements; k++) {
				table[k] = (int) (Math.random() * 100);
				copieDeTable[k] = table[k]; //on mémorise le contenu initial du tableau
			}
			
			//SELECTION
			trierSelection(table);

			t1 = System.currentTimeMillis();
			trierSelection(table);
			t2 = System.currentTimeMillis();
			tSelec=(int) (t2-t1);
			
			if (nbElements <= 20) System.out.println("Après tri par sélection: " + Arrays.toString(table));
			
			//ENUMERATION
			// on reprend les mêmes valeurs pour le prochain test
			System.arraycopy(copieDeTable, 0, table, 0, table.length);
			
			t1 = System.currentTimeMillis();
			int nouv[]=trierEnumeration(table);
			t2 = System.currentTimeMillis();
			tEnu=(int) (t2-t1);
			
			if (nbElements <= 20) System.out.println("Après tri par énumération: " + Arrays.toString(nouv));
			
			//BULLE
			// on reprend les mêmes valeurs pour le prochain test
			System.arraycopy(copieDeTable, 0, table, 0, table.length);

			t1 = System.currentTimeMillis();
			trierBulle(table);
			t2 = System.currentTimeMillis();
			tBulle=(int) (t2-t1);
			
			if (nbElements <= 20) System.out.println("Après tri par bulle: " + Arrays.toString(table));
			
			//INSERTION
			// on reprend les mêmes valeurs pour le prochain test
			System.arraycopy(copieDeTable, 0, table, 0, table.length);
			trierInsertion(table);
			t1 = System.currentTimeMillis();
			trierInsertion(table);
			t2 = System.currentTimeMillis();
			tInser=(int) (t2-t1);
			
			if (nbElements <= 20) System.out.println("Après tri par insertion: " + Arrays.toString(table));
			
			System.out.println("Temps en mili sec SELECTION : "+tSelec);
			System.out.println("Temps en mili sec ENUMERATION : "+tEnu);
			System.out.println("Temps en mili sec BULLE : "+tBulle);
			System.out.println("Temps en mili sec INSERTION : "+tInser);
		} // fin main
		
		/*
		 * Tri par sélection
		 */
		public static void trierSelection(int table[]) {
			
			int min = Integer.MAX_VALUE;
			int minPos = 0;

			for (int j = 0; j < table.length; j++) {
				min = Integer.MAX_VALUE;
				for (int k = j; k < table.length; k++) {
					if (table[k] <= min) {
						min = table[k];

						minPos = k;
					}
				}

				int change = table[j];
				table[j] = min;
				table[minPos] = change;
			}
			
		} // fin tri par sélection
		
	
		/*
		 * Tri par énumération
		 */
		public static int[] trierEnumeration(int table[]) {
			
			int pts[] = new int[table.length];
			int fin[] = new int[table.length];

			for (int i = 0; i < pts.length; i++) {
				pts[i] = 0;
			}

			for (int pos = 0; pos < table.length; pos++) {
				for (int compa = 0; compa < table.length; compa++) {
					if (table[pos] > table[compa]) {
						pts[pos] = pts[pos] + 1;
					}
				}
			} // a la fin de ce tableau, tout les points ont ete stocke, dans des positions
				// aleatoire,

			for (int k = 0; k < table.length; k++) {
				fin[pts[k]] = table[k];
			}

			
			return fin;
		} // fin tri par énumération (comptage)
		
		public static void trierBulle(int table[]) {
			
			int j;

			for (int i = 0; i < table.length; i++) {// rouler un nb suffisant de fois

				for (int k = 0; k < table.length - 1; k++) {// passer a travers tt
					if (table[k] > table[k + 1]) {
						j = table[k];
						table[k] = table[k + 1];
						table[k + 1] = j;
					}
				}

			}

		}
		
		public static void trierInsertion(int table[]) {
			
			int j, tmp;

			for (int i = 0; i < table.length; i++) {// rouler un nb suffisant de fois

				tmp = table[i];
				j = i;

				while (j > 0 && table[j - 1] > tmp) {
					table[j] = table[j - 1];
					j = j - 1;
				}
				table[j] = tmp;
			}

		}
		
} // fin classe

