package m2i.formation.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import m2i.formation.model.Adresse;
import m2i.formation.model.Civilite;
import m2i.formation.model.Difficulte;
import m2i.formation.model.Formateur;
import m2i.formation.model.Matiere;
import m2i.formation.model.Stagiaire;

public class FormationMain1 {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Formateur eric = new Formateur(Civilite.M, "SULTAN", "Eric", "eric@gmail.com", sdf.parse("01/07/2015"), 22,
				false);

		Formateur benoit = new Formateur(Civilite.M, "ROUTIER", "Benoit", "benoit@gmail.com", sdf.parse("01/07/2011"),
				15, true);

		Stagiaire romain = new Stagiaire(Civilite.M, "VASSEUR", "Romain", "romain@gmail.com", sdf.parse("25/12/1983"));

		Stagiaire alexandre = new Stagiaire(Civilite.M, "WOLNY", "Alexandre", "alexandre@gmail.com", sdf.parse("05/05/1985"));
		
		Stagiaire cyril = new Stagiaire(Civilite.M, "ROMANO", "Cyril", "cyril@gmail.com", sdf.parse("05/05/1982"));
		
		Adresse ericAdresse = new Adresse("1 rue de la Paix", "", "75008", "Paris", "France");
		eric.setAdresse(ericAdresse);

		Adresse benoitAdresse = new Adresse("1 place du centre", "", "59000", "Lille", "France");
		benoit.setAdresse(benoitAdresse);
		
		Adresse romainAdresse = new Adresse("1 rue Sainte Catherine", "", "33000", "Bordeaux", "France");
		romain.setAdresse(romainAdresse);
		
		Adresse alexandreAdresse = new Adresse("1 place du Capitole", "", "86000", "Poitiers", "France");
		alexandre.setAdresse(alexandreAdresse);
		
		Adresse cyrilAdresse = new Adresse("1 plaza de milano", "", "445211", "Parme", "Italie");
		cyril.setAdresse(cyrilAdresse);
		
		Matiere html = new Matiere("HTML", 2, Difficulte.FACILE);
		Matiere javascript = new Matiere("Javascript", 3, Difficulte.MOYEN);
		
		Matiere java = new Matiere("JAVA", 5, Difficulte.FACILE);
		Matiere springCore = new Matiere("Spring Core", 3, Difficulte.MOYEN);
		Matiere angular = new Matiere("Angular", 5, Difficulte.DIFFICILE);
		
		
		eric.getCompetences().add(java);
		eric.getCompetences().add(springCore);
		
		benoit.getCompetences().add(java);
		benoit.getCompetences().add(html);
		benoit.getCompetences().add(javascript);
		benoit.getCompetences().add(angular);
		
		java.getFormateurs().add(eric);
		java.getFormateurs().add(benoit);
		springCore.getFormateurs().add(eric);
		html.getFormateurs().add(benoit);
		javascript.getFormateurs().add(benoit);
		angular.getFormateurs().add(benoit);
		
		romain.setFormateur(eric);
		cyril.setFormateur(eric);
		alexandre.setFormateur(benoit);
		
		eric.getStagiaires().add(romain);
		eric.getStagiaires().add(cyril);
		benoit.getStagiaires().add(alexandre);
		
	}

}
