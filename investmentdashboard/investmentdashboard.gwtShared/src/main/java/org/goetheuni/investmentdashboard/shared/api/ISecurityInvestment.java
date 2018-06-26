package org.goetheuni.investmentdashboard.shared.api;

import org.goetheuni.investmentdashboard.shared.impl.Security;

/**
 * An object with this interface represents an investment in one security. It
 * knows its number of instances of that security.
 */
public interface ISecurityInvestment {

	/**
	 * @return the security
	 */
	public Security getSecurity();

	/**
	 * @return the quantity
	 */
	public long getQuantity();
	
	/**
	 * Maps an object's values to a number in a deterministic way.
	 * 
	 * @return the number 
	 */
	public int hashCode();


	/**
	 * Returns true if the objects values are equal to the given object.
	 * Otherwise false.
	 * @param obj The object for comparison.
	 * @return	True if the object's values are equal otherwise false.
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
