package org.goetheuni.investmentdashboard.client.ui;

import java.util.List;

import org.goetheuni.investmentdashboard.client.global.DashBoardWidgets;

public class WidgetCashAccounts extends AbstractCategoryWidget<SelectableCashAccount> {

	public static WidgetCashAccounts generate(List<? extends SelectableCashAccount> cashAccounts) {
		// generate detail widget
		DetailWidgetCashAccount details = new DetailWidgetCashAccount();

		// generate select widget
		SelectWidgetCashAccounts selectWidget = new SelectWidgetCashAccounts(cashAccounts, details);

		String header = "Bargeldkonten";

		// return result
		return new WidgetCashAccounts(header, selectWidget, details);
	}

	protected WidgetCashAccounts(String header, AbstractSelectWidget<SelectableCashAccount> selectWidget,
			AbstractDetailWidget<SelectableCashAccount> detailWidget) {
		super(header, selectWidget, detailWidget);
		DashBoardWidgets.setCashAccounts(this);
	}

}
