package org.relaxng.datatype;

/**
 * Datatype streaming validator.
 * 
 * The streaming validator is an optional feature that is useful for
 * certain Datatypes. It allows the caller to incrementally provide
 * the literal.
 * 
 * @author <a href="mailto:jjc@jclark.com">James Clark</a>
 * @author <a href="mailto:kohsuke.kawaguchi@eng.sun.com">Kohsuke KAWAGUCHI</a>
 */
public interface DatatypeStreamingValidator {
	
	/**
	 * let a streaming validator process additional literal fragment.
	 * 
	 * <p>
	 * The application can call this method several times, then call
	 * the isValid method (or the checkValid method) to check the validity
	 * of the accumulated characters.
	 */
	void addCharacters( char[] buf, int start, int len );
	
	/**
	 * gets if the accumulated literal is valid with respect to
	 * the underlying Datatype.
	 * 
	 * @return
	 *		True if it is valid. False if otherwise.
	 */
	boolean isValid();
	
	/**
	 * similar to the isValid method, but this method throws
	 * Exception (with possibly diagnostic information), instead of
	 * returning false.
	 * 
	 * @exception DatatypeException
	 *		If the callee supports the diagnosis and the accumulated literal is invalid,
	 *		then this exception that possibly contains diagnosis information is thrown.
	 * 
	 */
	void checkValid() throws DatatypeException;
}
