package org.goetheuni.investmentdashboard.shared.impl;

import java.util.Objects;

import org.goetheuni.investmentdashboard.shared.api.ISecurity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Objects of this class represent a security. It can be contained in a security
 * depot.
 * 
 * JAVADOC DONE
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

	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isin == null) ? 0 : isin.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((shortName == null) ? 0 : shortName.hashCode());
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
		Security other = (Security) obj;
		if (isin == null) {
			if (other.isin != null) {
				return false;
			}
		} else if (!isin.equals(other.isin)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (shortName == null) {
			if (other.shortName != null) {
				return false;
			}
		} else if (!shortName.equals(other.shortName)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Security [isin=" + isin + ", name=" + name + ", shortName=" + shortName + "]";
	}

	/**
	 * Creates an object representing a security. All parameters must not be null.
	 * 
	 * @param isin
	 *            The security's ISIN
	 * @param name
	 *            The security's name
	 * @param shortName
	 *            A short name for the security (A longer given string will be
	 *            reduced to the maximum of 12 letters)
	 */
	@JsonCreator
	public Security(final @JsonProperty("isin") String isin, final @JsonProperty("name") String name,
			final @JsonProperty("shortName") String shortName) {
		// validate input
		this.isin = Objects.requireNonNull(isin, "Cannot create a security with a given isin, that is null.");
		this.name = Objects.requireNonNull(name, "Cannot create a security with a given name that is null.");
		Objects.requireNonNull(shortName, "The given short name must not be null");

		if (shortName.length() <= 12) {
			// this is fine
			this.shortName = shortName;
		} else {
			// short name must be reduced
			this.shortName = shortName.substring(0, 11);
		}
	}

	/**
	 * NOT A PART OF THE API
	 */
	protected Security() {
		// required by GWT
	}

}
