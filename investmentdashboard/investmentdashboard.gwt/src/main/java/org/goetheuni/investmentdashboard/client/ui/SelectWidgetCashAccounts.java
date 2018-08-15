package org.goetheuni.investmentdashboard.client.ui;

import java.util.LinkedList;
import java.util.List;

/**
 * Objects of this class are selct widgets for cash accounts.
 * 
 * JAVADOC DONE
 */
public class SelectWidgetCashAccounts extends AbstractSelectWidget<SelectableCashAccount> {

	/**
	 * @param accounts
	 *            The cash account to represent
	 * @return The buttons of the select widget (without click-handlers)
	 */
	private static List<AbstractSelectButton<SelectableCashAccount>> createButtons(
			List<? extends SelectableCashAccount> accounts) {
		List<AbstractSelectButton<SelectableCashAccount>> buttons = new LinkedList<>();

		// create buttons
		for (SelectableCashAccount account : accounts) {
			buttons.add(new SelectButtonCashAccount(account));
		}

		return buttons;
	}

	/**
	 * Creates a select widget for cash accounts
	 * 
	 * @param accounts
	 *            The cash account struct to represent
	 * @param detailWidget
	 *            The corresponding detail widget
	 */
	public SelectWidgetCashAccounts(List<? extends SelectableCashAccount> accounts,
			DetailWidgetCashAccount detailWidget) {
		this(createButtons(accounts), detailWidget);
	}

	/**
	 * NOT A PART OF THE API
	 * 
	 * @param someSelectButtons
	 * @param detailWidget
	 */
	protected SelectWidgetCashAccounts(List<AbstractSelectButton<SelectableCashAccount>> someSelectButtons,
			AbstractDetailWidget<SelectableCashAccount> detailWidget) {
		super(someSelectButtons, detailWidget);
	}

}
