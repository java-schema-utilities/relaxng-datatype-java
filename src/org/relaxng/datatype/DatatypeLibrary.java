package org.relaxng.datatype;

/**
 * A Datatype library
 * 
 * @author <a href="mailto:jjc@jclark.com">James Clark</a>
 * @author <a href="mailto:kohsuke.kawaguchi@eng.sun.com">Kohsuke KAWAGUCHI</a>
 */
public interface DatatypeLibrary {
	
	/**
	 * creates a new instance of DatatypeBuilder.
	 * 
	 * The callee should throw a DatatypeException in case of an error.
	 * If an error is because of the undefined baseTypeLocalName, then
	 * it can return null instead of throwing an exception.
	 * 
	 * @param baseTypeLocalName
	 *		The local name of the base type.
	 * 
	 * @return null
	 *		The callee can return null if baseTypeLocalName is an undefined name.
	 */
	DatatypeBuilder createDatatypeBuilder( String baseTypeLocalName )
		throws DatatypeException;
	
	/**
	 * gets or creates a pre-defined type.
	 * 
	 * This is just a short-cut of createDatatypeBuilder(name).createDatatype();
	 * 
	 * The callee should throw a DatatypeException in case of an error.
	 * If the error is because of the undefined baseTypeLocalName, then
	 * it can return null instead of throwing an exception.
	 * 
	 * @return null
	 *		The callee can return null if localTypeName is an undefined name.
	 */
	Datatype createDatatype( String localTypeName ) throws DatatypeException;
}
