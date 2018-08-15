/**
 * 
 */
package org.goetheuni.investmentdashboard.client.ui;

/**
 * Objects with this interface can be used as objects of select buttons and
 * detail widgets.
 * 
 * JAVADOC DONE
 */
public interface Selectable extends Comparable<Selectable> {

	/**
	 * @return The name of the account, depot or wallet to be displayed in the UI.
	 */
	String getName();

	/**
	 * @return The ID of the account, depot or wallet to be displayed in the UI.
	 */
	String getID();

	/**
	 * @return formatted balance of the account, depot or wallet to be displayed in
	 *         the UI.
	 */
	String getFormattedAmountInEUR();

	/**
	 * This method triggers a computation of the balance using the market data
	 * currently stored at this client.
	 */
	void refreshComputations();

	/**
	 * Allows to compare selectables. It assumes that (name, id) identifies a
	 * selectable Should not be used to compare selectables of different
	 * sub-interfaces though.
	 */
	@Override
	default int compareTo(Selectable o) {
		int name = this.getName().compareTo(o.getName());
		if (name != 0) {
			return name;
		} else {
			int id = this.getID().compareTo(o.getID());
			return id;

		}
	}

}
