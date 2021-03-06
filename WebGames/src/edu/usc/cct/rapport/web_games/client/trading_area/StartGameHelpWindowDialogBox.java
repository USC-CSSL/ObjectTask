package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextArea;

import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;

public class StartGameHelpWindowDialogBox extends DialogBox implements ClickHandler {
//public class StartGameHelpWindowDialogBox extends DialogBox {

	@SuppressWarnings("unused")
	final private EventBus eventBus;

	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);
	
//	public StartGameHelpWindowDialogBox(final EventBus eventBus, final int temp) {
	public StartGameHelpWindowDialogBox(final EventBus eventBus, final int temp, final ExperimentConditions experimentConditions) {
		
		
		super(false, true);
		this.eventBus = eventBus;

		String titleDiscription = constants.help_Window_Title();
		this.setText(titleDiscription);
//		final FlowPanel flowPanelDialogBoxContents = new FlowPanel();
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setSize("650px", "400px");
		
	//	final TextArea dialogBoxTextArea = new TextArea();
		RichTextArea dialogBoxTextArea = new RichTextArea();
//		dialogBoxTextArea.setSize("450px", "500px");
		dialogBoxTextArea.setSize("640px", "355px");
		//dialogBoxTextArea.setCharacterWidth(75);
		//dialogBoxTextArea.setVisibleLines(10);

		String helpStartofGame = constants.help_start_of_game();
		final StringBuilder builder = new StringBuilder();
		builder.append(helpStartofGame);
		final String result = builder.toString();
		
		dialogBoxTextArea.setHTML(result);
//		flowPanelDialogBoxContents.add(dialogBoxTextArea);
		absolutePanel.add(dialogBoxTextArea , 0, 0);

		String okButtonString = constants.ok_button();
		final Button button = new Button(okButtonString, this);
//		flowPanelDialogBoxContents.add(okButton);
//		this.setWidget(flowPanelDialogBoxContents);
						
		absolutePanel.add(button, 540, 365);
		button.setSize("101px", "26px");
		this.setWidget(absolutePanel);

	};

	@Override
	public void onClick(final ClickEvent event) {
		hide();
	//	eventBus.fireEvent(new NegotiationConclusionAcknowledgedEvent());
	};
};
