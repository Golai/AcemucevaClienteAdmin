package persistence;

import java.io.*;
 /**
  * Novedad Value Object.
  * This class is value object representing database table acemuceva
  * This class is intented to be used together with associated Dao object.
  */

 /**
  * This sourcecode has been generated by FREE DaoGen generator version 2.4.1.
  * The usage of generated code is restricted to OpenSource software projects
  * only. DaoGen is available in http://titaniclinux.net/daogen/
  * It has been programmed by Tuomo Lukka, Tuomo.Lukka@iki.fi
  *
  * DaoGen license: The following DaoGen generated source code is licensed
  * under the terms of GNU GPL license. The full text for license is available
  * in GNU project's pages: http://www.gnu.org/copyleft/gpl.html
  *
  * If you wish to use the DaoGen generator to produce code for closed-source
  * commercial applications, you must pay the lisence fee. The price is
  * 5 USD or 5 Eur for each database table, you are generating code for.
  * (That includes unlimited amount of iterations with all supported languages
  * for each database table you are paying for.) Send mail to
  * "Tuomo.Lukka@iki.fi" for more information. Thank you!
  */



public class Novedad implements Cloneable, Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int id_novedades;
    private String titulo;
    private int id_encargado;
    private String descripcion;
    private String tipo_novedad;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public Novedad () {

    }

    public Novedad (int id_novedadesIn) {

          this.id_novedades = id_novedadesIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getId_novedades() {
          return this.id_novedades;
    }
    public void setId_novedades(int id_novedadesIn) {
          this.id_novedades = id_novedadesIn;
    }

    public String getTitulo() {
          return this.titulo;
    }
    public void setTitulo(String tituloIn) {
          this.titulo = tituloIn;
    }

    public int getId_encargado() {
          return this.id_encargado;
    }
    public void setId_encargado(int id_encargadoIn) {
          this.id_encargado = id_encargadoIn;
    }

    public String getDescripcion() {
          return this.descripcion;
    }
    public void setDescripcion(String descripcionIn) {
          this.descripcion = descripcionIn;
    }

    public String getTipo_novedad() {
          return this.tipo_novedad;
    }
    public void setTipo_novedad(String tipo_novedadIn) {
          this.tipo_novedad = tipo_novedadIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int id_novedadesIn,
          int id_encargadoIn,
          String tituloIn,
          String descripcionIn,
          String tipo_novedadIn) {
          this.id_novedades = id_novedadesIn;
          this.titulo = tituloIn;
          this.id_encargado = id_encargadoIn;
          this.descripcion = descripcionIn;
          this.tipo_novedad = tipo_novedadIn;
    }


    /** 
     * hasEqualMapping-method will compare two Novedad instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(Novedad valueObject) {

          if (valueObject.getId_novedades() != this.id_novedades) {
                    return(false);
          }
          if (this.titulo == null) {
                    if (valueObject.getTitulo() != null)
                           return(false);
          } else if (!this.titulo.equals(valueObject.getTitulo())) {
                    return(false);
          }
          if (valueObject.getId_encargado() != this.id_encargado) {
                    return(false);
          }
          if (this.descripcion == null) {
                    if (valueObject.getDescripcion() != null)
                           return(false);
          } else if (!this.descripcion.equals(valueObject.getDescripcion())) {
                    return(false);
          }
          if (this.tipo_novedad == null) {
                    if (valueObject.getTipo_novedad() != null)
                           return(false);
          } else if (!this.tipo_novedad.equals(valueObject.getTipo_novedad())) {
                    return(false);
          }

          return true;
    }



    /**
     * toString will return String object representing the state of this 
     * valueObject. This is useful during application development, and 
     * possibly when application is writing object states in textlog.
     */
    public String toString() {
        StringBuffer out = new StringBuffer(this.getDaogenVersion());
        out.append("\nclass Novedad, mapping to table acemuceva\n");
        out.append("Persistent attributes: \n"); 
        out.append("id_novedades = " + this.id_novedades + "\n"); 
        out.append("titulo = " + this.titulo + "\n"); 
        out.append("id_encargado = " + this.id_encargado + "\n"); 
        out.append("descripcion = " + this.descripcion + "\n"); 
        out.append("tipo_novedad = " + this.tipo_novedad + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        Novedad cloned = new Novedad();

        cloned.setId_novedades(this.id_novedades); 
        if (this.titulo != null)
             cloned.setTitulo(new String(this.titulo)); 
        cloned.setId_encargado(this.id_encargado); 
        if (this.descripcion != null)
             cloned.setDescripcion(new String(this.descripcion)); 
        if (this.tipo_novedad != null)
             cloned.setTipo_novedad(new String(this.tipo_novedad)); 
        return cloned;
    }



    /** 
     * getDaogenVersion will return information about
     * generator which created these sources.
     */
    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

}