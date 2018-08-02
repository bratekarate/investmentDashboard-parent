package org.goetheuni.investmentdashboard.shared.api;

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

	/**
	 * Maps an object's values to a number in a deterministic way.
	 * 
	 * @return the number
	 */
	public int hashCode();

	/**
	 * Returns true if the objects values are equal to the given object. Otherwise
	 * false.
	 * 
	 * @param obj
	 *            The object for comparison.
	 * @return True if the object's values are equal otherwise false.
	 */
	public boolean equals(Object obj);

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString();

}
