package org.relaxng.datatype;

/**
 * An interface that must be implemented by caller to
 * provide context information that is necessary to 
 * perform validation of some Datatypes.
 * 
 * @author <a href="mailto:jjc@jclark.com">James Clark</a>
 * @author <a href="mailto:kohsuke.kawaguchi@sun.com">Kohsuke KAWAGUCHI</a>
 */
public interface ValidationContext {
	
	/**
	 * Resolves a namespace prefix to the corresponding namespace URI.
	 * 
	 * This method is used for validating QName, for example.
	 *
	 * <p>
	 * If the prefix is "" (empty string), it indicates
	 * unprefixed value. The callee
	 * should resolved it as if it sees an unprefixed
	 * element, rather than unprefixed attribute.
	 * 
	 * <p>
	 * If the prefix is "xml", then the callee must resolve
	 * this prefix into "http://www.w3.org/XML/1998/namespace",
	 * as defined in the XML Namespace rec.
	 * 
	 * @return
	 *		namespace URI of this prefix.
	 *		If the specified prefix is not declared,
	 *		the implementation must return null.
	 */
	String resolveNamespacePrefix( String prefix );

	/**
	 * checks if an unparsed entity is declared with the
	 * specified name.
	 * 
	 * @return
	 *  true
	 *		if DTD has an unparsed entity declaration for
	 *		the specified name.
	 *	false
	 *		if otherwise.
	 */
	boolean isUnparsedEntity( String entityName );

	/**
	 * checks if a notation is declared with the
	 * specified name.
	 * 
	 * @return
	 *  true
	 *		if DTD has a notation declaration with the specified name.
	 *	false
	 *		if otherwise.
	 */
	boolean isNotation( String notationName );
}
