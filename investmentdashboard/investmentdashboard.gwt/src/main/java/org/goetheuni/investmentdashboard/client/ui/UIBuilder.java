package org.goetheuni.investmentdashboard.client.ui;

import java.math.BigDecimal;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class UIBuilder {

	public static void buildUI(BigDecimal totalBalance, RootPanel rootPanel) {
		Label gesamtSaldoTextLabel = new Label();
		Label gesamtSaldoLabel = new Label();
		Label infobox = new Label();
		Label infobox2 = new Label();
		Button infoButton = new Button();
		// the accurate Position in x/y can be defined in absolutePanel
		AbsolutePanel absPanel10 = new AbsolutePanel();
		AbsolutePanel absPanel20 = new AbsolutePanel();
		//
		// for the beauty
		DecoratorPanel panel00 = new DecoratorPanel();
		DecoratorPanel panel01 = new DecoratorPanel();
		DecoratorPanel panel10 = new DecoratorPanel();
		DecoratorPanel panel20 = new DecoratorPanel();

		// the main widget of this site is a FlexTable
		FlexTable flexTable = new FlexTable();

		Hyperlink link0 = new Hyperlink("<links zu Kontoaktionen>", UIBuilder.getHyperLink(0));
		Hyperlink link1 = new Hyperlink("<andere links(Post, Kontakt)>", UIBuilder.getHyperLink(0));

		absPanel10.setSize("500px", "20px");
		absPanel20.setSize("500px", "70px");

		// row 2
		// get total balance

		gesamtSaldoTextLabel.setText("Gesamtsaldo");
		gesamtSaldoTextLabel.getElement().getStyle().setFontSize(15, Unit.PX); // setFont, unit with pixel
		gesamtSaldoLabel.setText(totalBalance.toString() + "€");
		absPanel10.add(gesamtSaldoTextLabel, 30, 0);
		absPanel10.add(gesamtSaldoLabel, 400, 0);

		// row 3
		infoButton.setText("Mehr Infos");
		infobox.setText("<Infobox für Werbung für Produkte der Bank>");
		infobox2.setText("\"Ganz einfach global inverstieren mit Capgemini-Bank AG\"");
		absPanel20.add(infoButton, 400, 0);
		absPanel20.add(infobox, 50, 15);
		absPanel20.add(infobox2, 50, 35);

		// after all of the widgets are defined, set them in different DecoratePanel
		panel00.setWidget(link0);
		panel00.setWidth("300px");
		panel01.setWidget(link1);
		panel10.setWidget(absPanel10);
		panel20.setWidget(absPanel20);

		flexTable.getFlexCellFormatter().setColSpan(1, 0, 2);
		flexTable.getFlexCellFormatter().setColSpan(2, 0, 2);
		flexTable.setCellSpacing(30);
		flexTable.setWidget(0, 0, panel00);
		flexTable.setWidget(0, 1, panel01);
		flexTable.setWidget(1, 0, panel10);
		flexTable.setWidget(2, 0, panel20);

		// element is the id of the main element flexTable
		// id will be defined in css file
		rootPanel.add(flexTable);

		// Create the dialog box
		final DialogBox dialogBox = UIBuilder.createDialogBox();
		dialogBox.setGlassEnabled(true);
		dialogBox.setAnimationEnabled(true);

		// Listen for mouse events on the Add button.
		infoButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				dialogBox.center();
				dialogBox.show();
			}
		});
	}

	private static String getHyperLink(int index) {
		return "\"127.0.0.1\"";
	}

	private static DialogBox createDialogBox() {
		// Create a dialog box and set the caption text
		final DialogBox dialogBox = new DialogBox();
		dialogBox.ensureDebugId("cwDialogBox");
		dialogBox.setText("Im test DialogBox");

		// Create a table to layout the content
		VerticalPanel dialogContents = new VerticalPanel();
		dialogContents.setSpacing(4);
		dialogBox.setWidget(dialogContents);

		// Add some text to the top of the dialog
		HTML details = new HTML("just make a test");
		dialogContents.add(details);
		dialogContents.setCellHorizontalAlignment(details, HasHorizontalAlignment.ALIGN_CENTER);

		// Add a close button at the bottom of the dialog
		Button closeButton = new Button("close", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				dialogBox.hide();
			}
		});
		dialogContents.add(closeButton);
		if (LocaleInfo.getCurrentLocale().isRTL()) {
			dialogContents.setCellHorizontalAlignment(closeButton, HasHorizontalAlignment.ALIGN_LEFT);

		} else {
			dialogContents.setCellHorizontalAlignment(closeButton, HasHorizontalAlignment.ALIGN_CENTER);
		}

		// Return the dialog box
		return dialogBox;
	}
}
