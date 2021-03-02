package m2i.formation;

import m2i.formation.dao.IAdresseDao;
import m2i.formation.dao.IMatiereDao;
import m2i.formation.dao.IPersonneDao;
import m2i.formation.daoFile.AdresseDaoFile;
import m2i.formation.daoFile.MatiereDaoFile;
import m2i.formation.daoFile.PersonneDaoFile;

public class Application {
	private static Application instance = null;

	private final IAdresseDao adresseDao = new AdresseDaoFile();
	private final IMatiereDao matiereDao = new MatiereDaoFile();
	private final IPersonneDao personneDao = new PersonneDaoFile();

	private Application() {
		
	}
	
	public static Application getInstance() {
		if (instance == null) {
			instance = new Application();
		}

		return instance;
	}

	public IAdresseDao getAdresseDao() {
		return adresseDao;
	}

	public IMatiereDao getMatiereDao() {
		return matiereDao;
	}

	public IPersonneDao getPersonneDao() {
		return personneDao;
	}
	
}