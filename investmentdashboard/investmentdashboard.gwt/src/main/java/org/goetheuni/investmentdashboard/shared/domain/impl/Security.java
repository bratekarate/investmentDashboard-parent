package org.goetheuni.investmentdashboard.shared.domain.impl;

import org.goetheuni.investmentdashboard.shared.domain.api.ISecurity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Objects of this class represent a security. It can be contained in a security
 * depot.
 */
public class Security implements ISecurity {

	/**
	 * The security's ISIN, which is a global ID for securities.
	 */
	protected String isin;

	/**
	 * The security's name.
	 */
	protected String name;

	/**
	 * A short name for the security. It will be used in the UI.
	 */
	protected String shortName;

	/**
	 * @return the isin
	 */
	@Override
	public String getIsin() {
		return isin;
	}

	/**
	 * @return the name
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * @return the shortName
	 */
	@Override
	public String getShortName() {
		return shortName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Security [isin=" + isin + ", name=" + name + ", shortName=" + shortName + "]";
	}

	/**
	 * Creates a Security. All parameters must not be null.
	 * 
	 * @param isin
	 * @param name
	 * @param shortName
	 */
	@JsonCreator
	public Security(final @JsonProperty("isin") String isin, final @JsonProperty("name") String name,
			final @JsonProperty("shortName") String shortName) {
		this.isin = isin;
		this.name = name;
		this.shortName = shortName;
	}

	protected Security() {
		// required by GWT
	}

}
