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
