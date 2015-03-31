package it.unibz.db.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Stellt Methoden zur Konvertierung von einem String in ein java.util.Date
 * sowie java.sql.Date-Objekt bereit. Weiters wird durch Methoden die
 * umgekehrte Konvertierung in einen String realisiert
 * @author 07scasas
 */
public class Datum
{
	/**
	 * Kontrolliert ob der übergebene String ein korrektes Datum in der Form
	 * "dd.MM.yyyy" ist. Weiters wird kontrolliert, ob das übergebene Datum
	 * existiert
	 * @param s der zu kontrollierende String
	 * @return true, falls der String ein korrektes Datum enthält
	 */
	public static boolean isDate(String s) {
		boolean ret = false;
		//Kontrolle, ob übergebener String ungleich null ist:
		if(s != null && s.length() != 0){
			//FormatierungsMuster für die Umkonvertierung:
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
			//Dadurch wird verhindert, dass ungültige Daten verarbeitet werden:
			sdf.setLenient(false);
			try{
				//Es wird probiert zu parsen; bei misslungenem Parsen wird Exception
				//geworfen + false zurückgeschickt:
				sdf.parse(s);
				ret = true;
			}catch(ParseException e){
				e.printStackTrace();
				return ret;
			}
		}
		return ret;
	}
	
	/**
	 * Konvertiert den übergebenen String in ein util-Date-Objekt. Dabei wird
	 * kontrolliert, ob der String überhaupt ein gültiges Datum enthält
	 * @param s der zu konvertierende String
	 * @return das util-Date-Objekt
	 * @throws ParseException wenn der übergebene String kein gültiges
	 * Datum ist
	 */
	public static java.util.Date toUtilDate(String s) throws ParseException {
		java.util.Date ret = null;
		//FormatierungsMuster für die Umkonvertierung:
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		//Dadurch wird verhindert, dass ungültige Daten verarbeitet werden:
		sdf.setLenient(false);
		try{
			//String wird zu Date geparst:
			ret = sdf.parse(s);
		}catch(ParseException e){
			e.printStackTrace();
		}
		return ret;
	}
	
	/**
	 * Konvertiert den übergebenen String in ein SQL-Date-Objekt. Dabei wird
	 * kontrolliert, ob der String überhaupt ein gültiges Datum enthält
	 * @param s der zu konvertierende String
	 * @return das SQL-Date-Objekt
	 * @throws ParseException wenn der übergebene String kein gültiges
	 * Datum ist
	 */
	public static java.sql.Date toSqlDate(String s) throws ParseException {
		java.sql.Date ret = null;
		//FormatierungsMuster für die Umkonvertierung:		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		//Dadurch wird verhindert, dass ungültige Daten verarbeitet werden:
		sdf.setLenient(false);
		try{
			//Parsen des Strings in einem Datum:
			java.util.Date d1 = sdf.parse(s);
			//Zur Datenbank ist nur ein SQL-Date Objekt gültig:
			ret = new Date(d1.getTime());
		}catch(ParseException e){
			e.printStackTrace();
		}
		return ret;
	}
	
	/**
	 * Konvertiert ein java.util.Date oder java.sql.Date Objekt in einen String
	 * und zwar in der Form dd.MM.yyyy
	 * @param d das zu konvertierende Date-Objekt
	 * @return der String der das Datum im Objekt repräsentiert
	 */
	public static String toString(java.util.Date d) {
		String ret = null;
		//Instanziierung des Formatierungs-Objekt nach oben genannten FormatierungsMuster
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		ret = sdf.format(d);
	
	return ret;
	}
	
	/**
	 * Testprogramm
	 * @param args
	 */
	public static void main(String[] args) {
		String dString = "22.11.2008";
		try {
			java.util.Date uDate = toUtilDate(dString);
			System.out.println(toString(uDate));
			java.sql.Date sDate = toSqlDate(dString);
			System.out.println(toString(sDate));
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
	}
}