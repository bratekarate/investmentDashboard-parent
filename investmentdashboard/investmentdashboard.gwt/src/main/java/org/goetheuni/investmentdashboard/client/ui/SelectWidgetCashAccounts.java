package org.goetheuni.investmentdashboard.client.ui;

import java.util.LinkedList;
import java.util.List;

public class SelectWidgetCashAccounts extends AbstractSelectWidget<SelectableCashAccount> {

	private static List<AbstractSelectButton<SelectableCashAccount>> createButtons(
			List<? extends SelectableCashAccount> accounts) {
		List<AbstractSelectButton<SelectableCashAccount>> buttons = new LinkedList<>();

		// create buttons
		for (SelectableCashAccount account : accounts) {
			buttons.add(new SelectButtonCashAccount(account));
		}

		return buttons;
	}

	public SelectWidgetCashAccounts(List<? extends SelectableCashAccount> accounts,
			DetailWidgetCashAccount detailWidget) {
		this(createButtons(accounts), detailWidget);
	}

	protected SelectWidgetCashAccounts(List<AbstractSelectButton<SelectableCashAccount>> someSelectButtons,
			AbstractDetailWidget<SelectableCashAccount> detailWidget) {
		super(someSelectButtons, detailWidget);
	}

}
