package m2i.formation.test;

import m2i.formation.dao.IAdresseDao;
import m2i.formation.dao.IMatiereDao;
import m2i.formation.daoFile.AdresseDaoFile;
import m2i.formation.daoFile.MatiereDaoFile;
import m2i.formation.model.Adresse;
import m2i.formation.model.Difficulte;
import m2i.formation.model.Matiere;

public class FormationMain2 {

	public static void main(String[] args) {
		IAdresseDao adresseDao = new AdresseDaoFile();
		Adresse a1 = new Adresse("1 rue de la Paix", "", "75008", "Paris", "France");
		Adresse a2 = new Adresse("1 place du centre", "", "59000", "Lille", "France");
		Adresse a3 = new Adresse("1 rue Sainte Catherine", "", "33000", "Bordeaux", "France");
		Adresse a4 = new Adresse("1 place du Capitole", "", "86000", "Poitiers", "France");
		Adresse a5 = new Adresse("1 plaza de milano", "", "445211", "Parme", "Italie");
		adresseDao.create(a1);
		adresseDao.create(a2);
		adresseDao.create(a3);
		adresseDao.create(a4);
		adresseDao.create(a5);
		IMatiereDao matiereDao = new MatiereDaoFile();
		Matiere html = new Matiere("HTML", 2, Difficulte.FACILE);
		Matiere javascript = new Matiere("Javascript", 3, Difficulte.MOYEN);
		Matiere java = new Matiere("JAVA", 5, Difficulte.FACILE);
		Matiere springCore = new Matiere("Spring Core", 3, Difficulte.MOYEN);
		Matiere angular = new Matiere("Angular", 5, Difficulte.DIFFICILE);
		matiereDao.create(html);
		matiereDao.create(javascript);
		matiereDao.create(java);
		matiereDao.create(springCore);
		matiereDao.create(angular);	
	}

}