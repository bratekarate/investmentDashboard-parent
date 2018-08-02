/**
 * 
 */
package org.goetheuni.investmentdashboard.client.ui;

import java.math.BigDecimal;

/**
 *
 */
public interface SelectableSecurityDepot extends Selectable {

	public BigDecimal getReferenceValue();

	public BigDecimal getAmount();

	boolean isEmpty();

}
