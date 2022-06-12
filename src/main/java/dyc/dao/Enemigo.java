package dyc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import dyc.db.ConexionBD;
import dyc.exception.EnemigoException;

/**
 * Clase dedicada a crear enemigos y generarlos ede manera aleatoria, primero
 * les damos sus stats
 * 
 * @author victorml
 *
 */

public class Enemigo {
	/**
	 * Variable para el nombre del enemigo
	 */
	private String nombre;
	/**
	 * Variable para la vida del enemigo
	 */
	private int vida;
	/**
	 * Variable para el ataque del enemigo
	 */
	private int ataque;
	/**
	 * Variable para la defensa del personaje
	 */
	private int defensa;

	/**
	 * Metodo sin argumentos del que sacamos todas las estadisticas del enemigo
	 * 
	 * @throws SQLException     Exception por defecto de SQL
	 * @throws EnemigoException Exception lanzada por no existir Enemigos en la BD
	 */

	public Enemigo() throws SQLException, EnemigoException {
		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("select * from enemigo ORDER BY RAND() LIMIT 1");

		if (cursor.next()) {
			this.nombre = cursor.getString("nombre");
			this.vida = cursor.getInt("vida");
			this.ataque = cursor.getInt("ataque");
			this.defensa = cursor.getInt("defensa");
		} else {
			throw new EnemigoException("No hay enemigos en la base de datos");
		}

		ConexionBD.desconectar();
	}

	/**
	 * Con este metodo generamos de manera aleatoria enemigos, en este caso con un
	 * 50% de probabilidad de que haya un enemigo en una zona
	 * 
	 * @return Devuelve Enemigo en el caso de true, sino, null en el lugar
	 * @throws SQLException     Exception por defecto de sQL
	 * @throws EnemigoException Exception lanzada por no existir un Enemigo en la
	 *                          BBDD
	 */
	public static Enemigo generaEnemigo() throws SQLException, EnemigoException {
		Enemigo enemigo;
		Random random = new Random();

		if (random.nextBoolean() == true) {
			enemigo = new Enemigo();
		} else {
			enemigo = null;
		}

		return enemigo;
	}

	/**
	 * Obtenemos la vida establecida en el enemigo
	 * @return devuelve la cantidad de vida del enemigo
	 */
	public int getVida() {
		return vida;
	}

	/**
	 * Establecemos la vida del enemigo
	 * 
	 * @param vida cantidad de vida del enemigo
	 */
	public void setVida(int vida) {
		this.vida = vida;
	}

	/**
	 * Obtenemos el ataque establecido en el enemigo
	 * @return devuelve el numero de daño del enemigo
	 */
	public int getAtaque() {
		return ataque;
	}

	/**
	 * Establecemos el daño del enemigo
	 * @param ataque entero de daño del enemigo
	 */
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	/**
	 * Obtenemos la defensa del enemigo
	 * @return devuelve int de cantidad de defensa
	 */
	public int getDefensa() {
		return defensa;
	}

	/**
	 * Establecemos la defensa del enemigo
	 * @param defensa entero que da valor a la defensa del enemigo
	 */
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	/**
	 * Obtenemos el nombre del enemigo
	 * @return devuelve el nombre del enemigo
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establecemos el nombre del enemigo
	 * @param nombre String que da nombre al enemigo
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo usado para restar la vida del enemigo en cada situacion de combate que tenga que recibir daño
	 * @param vida la cantidad de vida
	 */
	public void restaVida(int vida) {
		this.vida -= vida;
	}

	@Override
	public String toString() {
		return nombre + " con salud de: " + vida + " Ataque: " + ataque + " Defensa: " + defensa;
	}
	
	/**
	 * Metodo booleano para devolver true o false, de esta manera sabemos si el enemigo esta vivo o muert
	 * @return devuelve el estado del enemigo, muerto o vivo
	 */
	public boolean estaVivo() {
		return vida > 0; 
	}

}
