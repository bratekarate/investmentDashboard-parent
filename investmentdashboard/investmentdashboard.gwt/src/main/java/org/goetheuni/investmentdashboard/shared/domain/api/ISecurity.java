package org.goetheuni.investmentdashboard.shared.domain.api;

/**
 * Objects with this interface represent a security. It can be contained in a
 * security depot. As GWT is based on source code mapping, these interface can
 * only be used in the server-side code.
 */
public interface ISecurity {

	/**
	 * @return the isin
	 */
	public String getIsin();

	/**
	 * @return the name
	 */
	public String getName();

	/**
	 * @return the shortName
	 */
	public String getShortName();

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString();

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode();

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj);

}
