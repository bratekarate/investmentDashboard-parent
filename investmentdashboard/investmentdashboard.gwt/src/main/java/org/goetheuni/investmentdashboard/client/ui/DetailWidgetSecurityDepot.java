package org.goetheuni.investmentdashboard.client.ui;

import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.gwt.charts.client.corechart.BarChart;

public class DetailWidgetSecurityDepot extends VerticalPanel implements AbstractDetailWidget<SelectableSecurityDepot> {

	protected DeltaChartWidget topWidget;

	protected HorizontalPanel middle;

	protected TopsSecurityWidget tops;

	protected FlopsSecurityWidget flops;

	protected SecurityTransactionsWidget transactions;

	@Override
	public void update(SelectableSecurityDepot correspondingObject) {
		// TODO Auto-generated method stub

	}

	public DetailWidgetSecurityDepot() {
		// TODO
	}

	protected class DeltaChartWidget extends BarChart {
		// TODO
	}
	
	protected class SecurityTransactionsWidget extends Grid {
		// TODO
	}

	protected class TopsSecurityWidget extends VerticalPanel {
		// TODO
	}

	protected class FlopsSecurityWidget extends VerticalPanel {
		// TODO
	}

}
