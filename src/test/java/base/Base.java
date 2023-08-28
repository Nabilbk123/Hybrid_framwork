package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// Cette classe va contenir tous ce qui commun a tout les tests (settup, teardown,..)


public class Base {
	WebDriver driver;
	// On va utiliser la classe predefinie java (Properties)pour manipuler les
	// proprietés commune
	public Properties prop;

	public Base() {
		//Le constructeur de notre classe 'prop'
		prop = new Properties();
		// Utiliser la classe ''File'' qui fait partie de la classe java (I/O) pour
		// manipuler (lire, ecrire) dans le fichier (objet) 'prop'
		// Cette classe permettra de manipuler ce fichier en tant objet Java
		// Mettre le chemin de notre fichier
		// Pour partager le projet avec n'importe quelle personne il faut remplacer le
		// debut du path (local) en utilisant la classeJava (System) et en utilisant
		// l'argument de cette classe : 'getProperty' en y ajoutant l'argument
		// (user.dir)=> L'argument generique pour Afficher l'emplacement actuel de notre
		// projet

		File propFile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\config\\config.properties");
		// Pour lire morceau par morceau a partir d'un fichier donné en utilise la
		// classe java 'FileInputStream'
		try {
			FileInputStream dataFis = new FileInputStream(propFile);
			prop.load(dataFis);
			// Ci dessous la gestion de l'exeption dans le cas ou le fichier n'est pas
			// trouvé
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public WebDriver intialiserNavigateurEtOuvrireUrl(String browserName) throws InterruptedException {
		// On gere ici bas le cas des navigateurs
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("qaUrl"));
		Thread.sleep(5000);
		return driver;

	}
}
