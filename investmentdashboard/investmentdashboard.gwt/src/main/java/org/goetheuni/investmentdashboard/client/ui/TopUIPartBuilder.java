package org.goetheuni.investmentdashboard.client.ui;

import java.math.BigDecimal;

import com.google.gwt.dom.client.Style;
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
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * This class provides a method that builds the top part of the UI. 
 */
public class TopUIPartBuilder {

	protected static void buildUI(BigDecimal totalBalance, VerticalPanel rootLayout) {
		Label labelTotalBalanceText = new Label();
		Label labelTotalBalance = new Label();
		Label infobox = new Label();
		
		Button infoButton = new Button();
		// the accurate Position in x/y can be defined in absolutePanel
		HorizontalPanel panelLinks = new HorizontalPanel();
		HorizontalPanel panelTotalBalance = new HorizontalPanel();
		HorizontalPanel panelAds = new HorizontalPanel();
		

		// for the beauty
		DecoratorPanel dpanelLinks = new DecoratorPanel();
		DecoratorPanel dpanelBalance = new DecoratorPanel();
		DecoratorPanel dpanelAds = new DecoratorPanel();
		

		// the main widget of this site is the given VerticalPanel
		rootLayout.setSpacing(8);

		// dummy label for  links
		Label linkActions = new Label("<links zu Kontoaktionen>");
		Label linkContact = new Label("<andere links(Post, Kontakt)>");
		
		linkActions.getElement().getStyle().setFontSize(FontConstants.CATEGORYCONTENT, FontConstants.UNIT);
		linkContact.getElement().getStyle().setFontSize(FontConstants.CATEGORYCONTENT, FontConstants.UNIT);

		panelLinks.setWidth("90vw");
		panelTotalBalance.setWidth("90vw");
		panelAds.setWidth("90vw");

		// add links to their panel
		panelLinks.add(linkActions);
		panelLinks.add(linkContact);
		
		// row 2
		// get total balance

		labelTotalBalanceText.setText("Gesamtsaldo");
		labelTotalBalanceText.getElement().getStyle().setFontSize(FontConstants.CATEGORYHEADER, FontConstants.UNIT); // setFont, unit with pixel
		labelTotalBalance.setText(totalBalance.toString() + "€");
		labelTotalBalance.getElement().getStyle().setFontSize(FontConstants.CATEGORYCONTENT, FontConstants.UNIT);
		labelTotalBalance.getElement().getStyle().setColor("black");
		panelTotalBalance.add(labelTotalBalanceText);
		panelTotalBalance.add(labelTotalBalance);

		// row 3
		infoButton.setText("Mehr Infos");
		infoButton.getElement().getStyle().setFontSize(FontConstants.CATEGORYCONTENT, FontConstants.UNIT);
		infobox.setText("<Infobox für Werbung für Produkte der Bank> : Ganz einfach global inverstieren mit Capgemini-Bank AG");
		infobox.getElement().getStyle().setFontSize(FontConstants.CATEGORYCONTENT, FontConstants.UNIT);
	
		panelAds.add(infobox);
		panelAds.add(infoButton);
		

		// after all of the widgets are defined, set them in different DecoratePanel
		dpanelLinks.setWidget(panelLinks);
		dpanelBalance.setWidget(panelTotalBalance);
		dpanelAds.setWidget(panelAds);
		
		// specify alignment
		panelLinks.setCellHorizontalAlignment(linkContact, HasHorizontalAlignment.ALIGN_LOCALE_END);
		panelTotalBalance.setCellHorizontalAlignment(labelTotalBalance, HasHorizontalAlignment.ALIGN_LOCALE_END);
		panelTotalBalance.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		panelAds.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		
		// set the panel's background color to white
		panelLinks.getElement().getStyle().setBackgroundColor(StyleConstants.WIDGET_BACKGROUND_COLOR);
		panelTotalBalance.getElement().getStyle().setBackgroundColor(StyleConstants.WIDGET_BACKGROUND_COLOR);
		panelAds.getElement().getStyle().setBackgroundColor(StyleConstants.WIDGET_BACKGROUND_COLOR);
		
		// make the border bigger
		panelLinks.getElement().getStyle().setBorderWidth(StyleConstants.TOP_WIDGT_BORDER_WIDTH, Unit.PX);
		panelLinks.getElement().getStyle().setBorderStyle(Style.BorderStyle.SOLID);
		panelLinks.getElement().getStyle().setBorderColor(StyleConstants.WIDGET_BACKGROUND_COLOR);
		
		panelTotalBalance.getElement().getStyle().setBorderWidth(StyleConstants.TOP_WIDGT_BORDER_WIDTH, Unit.PX);
		panelTotalBalance.getElement().getStyle().setBorderStyle(Style.BorderStyle.SOLID);
		panelTotalBalance.getElement().getStyle().setBorderColor(StyleConstants.WIDGET_BACKGROUND_COLOR);
		
		panelAds.getElement().getStyle().setBorderWidth(StyleConstants.TOP_WIDGT_BORDER_WIDTH, Unit.PX);
		panelAds.getElement().getStyle().setBorderStyle(Style.BorderStyle.SOLID);
		panelAds.getElement().getStyle().setBorderColor(StyleConstants.WIDGET_BACKGROUND_COLOR);
		
		
		// add to the root layout
		Label topLabel = new Label("Meine Konten");
		topLabel.getElement().getStyle().setColor("black");
		topLabel.getElement().getStyle().setFontSize(FontConstants.CATEGORYHEADER, FontConstants.UNIT);
		rootLayout.add(topLabel);
		rootLayout.add(panelLinks);
		rootLayout.add(panelTotalBalance);
		rootLayout.add(panelAds);

		
		// Create the dialog box
		final DialogBox dialogBox = TopUIPartBuilder.createDialogBox();
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
		dialogContents.setSpacing(0);
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

		// set font size
		dialogBox.getElement().getStyle().setFontSize(FontConstants.CATEGORYCONTENT, FontConstants.UNIT);
		// Return the dialog box
		return dialogBox;
	}
}
