package org.relaxng.datatype;

/**
 * signals Datatype related exceptions.
 * 
 * @author <a href="mailto:jjc@jclark.com">James Clark</a>
 * @author <a href="mailto:kohsuke.kawaguchi@eng.sun.com">Kohsuke KAWAGUCHI</a>
 */
public class DatatypeException extends Exception {
	
	public DatatypeException( int index, String msg ) {
		super(msg);
		this.index = index;
	}
	public DatatypeException( String msg ) {
		this(UNKNOWN,msg);
	}
	/**
	 * a constructor for those datatype libraries which don't support any
	 * diagnostic information at all.
	 */
	public DatatypeException() {
		this(UNKNOWN,null);
	}
	
	
	private final int index;
	
	public static final int UNKNOWN = -1;

	/**
	 * gets the index of the content where the error occured.
	 * UNKNOWN can be returned to indicate that no index information is available.
	 */
	public int getIndex() {
		return index;
	}
}
