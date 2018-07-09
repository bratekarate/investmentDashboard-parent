package org.goetheuni.investmentdashboard.shared;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Objects of this class are test objects for the StringRestService
 * 
 */
public class StringForRest implements IStringForRest {

	/**
	 * A test key of the type long.
	 */
	String key;

	/**
	 * A test String value.
	 */
	String value;

	/**
	 * 
	 * @return A test key of the type long.
	 */
	public String getKey() {
		return this.key;
	}

	/**
	 * @return A test String value.
	 */
	public String getValue() {
		return this.value;
	}

	/**
	 * Creates a simple object with the JSON representation: {key: aKey, value:
	 * aValue}
	 * 
	 * @param aKey
	 *            any number
	 * @param aValue
	 *            a non-null String
	 */
	@JsonCreator
	public StringForRest(@JsonProperty("key") final String aKey, @JsonProperty("value") final String aValue) {
		this.key = aKey;
		this.value = Objects.requireNonNull(aValue, "The String value of a test object may not be null");
	}

	protected StringForRest() {
		// required by GWT
	}
}
