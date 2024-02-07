/**
 * versione 5
 */
public class Parcheggio {

	private String indirizzo;
	private int maxCap;
	private int nVeicoli;
	private Veicolo[] veicoli;

	public Parcheggio(String ind, int mxC) {
		indirizzo = ind;
		maxCap = mxC;
		nVeicoli = 0;
		veicoli= new Veicolo[maxCap];

	}

	public boolean addVeicolo(Veicolo v) {
		if (nVeicoli<veicoli.length) {
			veicoli[nVeicoli++] = v;
			return true;

		} 
			return false;
	}

	public boolean removeVeicolo(String t) {
		for (int i = 0; i < nVeicoli; i++) {
			if(veicoli[i]!=null)
			if (t.equalsIgnoreCase(veicoli[i].targa)) {
				veicoli[i] = null;
				return true;

			}
		}

		return false;
	}

	public boolean modMarca(String t, String nM) {
		for (int i = 0; i < nVeicoli; i++) {
			if(veicoli[i]!=null)
			if (t.equalsIgnoreCase(veicoli[i].targa)) {
				veicoli[i].setMarca(nM);
				return true;
			}
		}
		return false;
	}

	public float visGuadagno() {
		float contat = 0;
		for (int i = 0; i < nVeicoli; i++)
			if (veicoli[i] != null) {
				contat += veicoli[i].getCostoG();
			}
		return contat;
	}

	public Veicolo[] visMotoSup() {
		int contamot = 0;
		for (int i = 0; i < nVeicoli; i++)
			if (veicoli[i] != null)
				if (veicoli[i] instanceof Moto) {
					Moto moto = (Moto) veicoli[i];
					if (moto.getNRuote() > 2)
						contamot++;
				}

		Veicolo[] motopiuruote = new Veicolo[contamot];
		int id=0;
		for (int i = 0; i < nVeicoli; i++)
			if (veicoli[i] != null)
				if (veicoli[i] instanceof Moto) {
					Moto moto = (Moto) veicoli[i];
					if (moto.getNRuote() > 2)
						motopiuruote[id++] = veicoli[i];

				}

		return motopiuruote;

	}
	
	public String toString() {
		String s="Parcheggio in via: "+indirizzo+"\n";
		s+="Capienza massima: "+maxCap+"\n";
		s+="Veicoli presenti: "+"\n";
		for(int i=0;i<nVeicoli;i++)
			if(veicoli[i]!=null)
				s+=veicoli[i]+"\n";
		return s;
	}

	public static void main(String[] args) {
		Parcheggio p=new Parcheggio("Via Taranto,59",10);
		

		Auto a=new Auto("FA903AZ","Nissan",true,45,"Utilitaria");

		Moto m=new Moto("AY0231AB","KTM",false,15,2);
		
		Auto ab=new Auto("FA903AZa","AUTO2",false,45,"SUV");

		Moto m1=new Moto("AY0231AB","SC",false,15,4);
		System.out.println(p.addVeicolo(m));
		System.out.println(p.addVeicolo(a));
		System.out.println(p.addVeicolo(m1));
		System.out.println(p.addVeicolo(ab));
		
		System.out.println(p);
		
		System.out.println("Guadagno giornaliero affitto: "+p.visGuadagno()+"\n");
		
		
		System.out.println(p.removeVeicolo("FA903AZ"));
		System.out.println(p.modMarca("AY0231AB", "MERCEDES"));
		
		System.out.println(p);

		System.out.println("Guadagno giornaliero affitto: "+p.visGuadagno()+"\n");
		
		Veicolo[] motopiur=p.visMotoSup();
		
		System.out.println("Moto con numero di ruote maggiore di 2: \n");
		 for (Veicolo moto : motopiur) {
	            System.out.println(moto);
	        }
	
		
	}

}





