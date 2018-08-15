package org.goetheuni.investmentdashboard.client.ui;

import java.util.List;

import org.goetheuni.investmentdashboard.client.global.DashBoardWidgets;

/**
 * Objects of this class represent category widgets for the category cash.
 * 
 * JAVADOC DONE
 */
public class WidgetCashAccounts extends AbstractCategoryWidget<SelectableCashAccount> {

	/**
	 * Creates a categroy widget for the category cash.
	 * 
	 * @param cashAccounts
	 *            The customer's cash accounts
	 * @return a categroy widget for the category cash
	 */
	public static WidgetCashAccounts generate(List<? extends SelectableCashAccount> cashAccounts) {
		// generate detail widget
		DetailWidgetCashAccount details = new DetailWidgetCashAccount();

		// generate select widget
		SelectWidgetCashAccounts selectWidget = new SelectWidgetCashAccounts(cashAccounts, details);

		String header = "Bargeldkonten";

		// return result
		return new WidgetCashAccounts(header, selectWidget, details);
	}

	/**
	 * NOT A PART OF THE API
	 * 
	 * @param header
	 *            please see the superclass constructor
	 * @param selectWidget
	 *            please see the superclass constructor
	 * @param detailWidget
	 *            please see the superclass constructor
	 */
	protected WidgetCashAccounts(String header, AbstractSelectWidget<SelectableCashAccount> selectWidget,
			AbstractDetailWidget<SelectableCashAccount> detailWidget) {
		super(header, selectWidget, detailWidget);
		DashBoardWidgets.setCashAccounts(this);
	}

}
