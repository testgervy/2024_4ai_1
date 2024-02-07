
public class Veicolo {
String targa;
String marca;
boolean disabile;
float costovig;

public Veicolo(String t,String m, boolean dis,float cost){
targa=t;
marca=m;
disabile=dis;
costovig=cost;
}

public void setMarca(String mr) {
	marca=mr;
	
}

public float getCostoG() {
	return getCostoG();
	
}

public String toString() {
	String s;
	s="Targa: "+targa+"\n";
	s+="Marca: "+marca+"\n";
	s+="Disabile: ";
	if(disabile)
		s+="Sì\n";
	else
		s+="No\n";
	s+="Spese vigilanza a veicolo: "+costovig+"\n";
	return s;
}

public static void main(String[] args) {
	Veicolo v=new Veicolo("AX054FR","Fiat",false,150);
	System.out.println(v);
	
}


}
