package org.goetheuni.investmentdashboard.shared.impl;

import java.util.Objects;

import org.goetheuni.investmentdashboard.shared.api.IPersonalCustomerData;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Objects of this class represent a customer's personal data.
 * 
 * JAVADOC DONE
 */
public class PersonalCustomerData implements IPersonalCustomerData {

	/**
	 * A string that will be used to address the customer. It should be chosen
	 * appropriately.
	 */
	protected String nameForAddress;

	/**
	 * @return the nameForAddress
	 */
	public String getNameForAddress() {
		return nameForAddress;
	}

	/**
	 * @param nameForAddress
	 *            the nameForAddress to set
	 */
	public void setNameForAddress(String nameForAddress) {
		this.nameForAddress = nameForAddress;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nameForAddress == null) ? 0 : nameForAddress.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		PersonalCustomerData other = (PersonalCustomerData) obj;
		if (nameForAddress == null) {
			if (other.nameForAddress != null) {
				return false;
			}
		} else if (!nameForAddress.equals(other.nameForAddress)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PersonalCustomerData [nameForAddress=" + nameForAddress + "]";
	}

	@JsonCreator
	public PersonalCustomerData(final @JsonProperty("nameForAddress") String nameForAddress) {
		this.nameForAddress = Objects.requireNonNull(nameForAddress, "The given name must not be null");
	}

	/**
	 * NOT A PART OF THE API
	 */
	protected PersonalCustomerData() {
		// required by GWT
	}

}
