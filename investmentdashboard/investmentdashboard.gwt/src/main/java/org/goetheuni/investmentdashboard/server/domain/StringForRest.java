package org.goetheuni.investmentdashboard.server.domain;

import java.util.Objects;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Objects of this class are test objects for the StringRestService
 * Rest-resource.
 * 
 */
public class StringForRest {

	/**
	 * A test key of the type long.
	 */
	@JsonProperty
	long key;

	/**
	 * A test String value.
	 */
	@JsonProperty
	String value;

	/**
	 * 
	 * @return A test key of the type long.
	 */
	public long getKey() {
		return key;
	}

	/**
	 * @return A test String value.
	 */
	public String getValue() {
		return value;
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
	public StringForRest(long aKey, String aValue) {
		this.key = aKey;
		this.value = Objects.requireNonNull(aValue, "The String value of a test object may not be null");
	}
}
