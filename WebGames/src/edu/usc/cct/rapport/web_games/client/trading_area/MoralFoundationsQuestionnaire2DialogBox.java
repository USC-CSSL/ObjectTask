package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Label;

import edu.usc.cct.rapport.web_games.client.specify_experiment_conditions.ExperimentConditions;


public class MoralFoundationsQuestionnaire2DialogBox extends DialogBox {

	final int maxQuestionNo = 8;
	final int maxAnswerNo 	= 6;
	private int currentMaxQuestionNo	= 2;
	private FlexTable flexTable = new FlexTable();
	private int userAnswer[] = new int [maxQuestionNo];
	private ArrayList<Label> questions_label = new ArrayList<Label>();
	AbsolutePanel absolutePanel = new AbsolutePanel();

	final private EventBus eventBus;

	static final private HelpWindowInternationalizationConstants constants = (HelpWindowInternationalizationConstants) (GWT.isClient() ? GWT.create(HelpWindowInternationalizationConstants.class) : null);
	
	
	public MoralFoundationsQuestionnaire2DialogBox(final EventBus eventBus, final ExperimentConditions experimentConditions) {
		super(false, true);
		this.eventBus = eventBus;
		setHTML("Questionnaire");
		
		String localName = com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().getLocaleName();
		setWidget(absolutePanel);
		Label explanation = new Label();
	    
		if (localName == "en" || localName == "ko"){			
			explanation = new Label(constants.mfq_explanation_part1());
			explanation.setStylePrimaryName("Explanation-style");

			questions_label.add(new Label(constants.mfq09()));
			questions_label.add(new Label(constants.mfq10()));
			questions_label.add(new Label(constants.mfq11()));
			questions_label.add(new Label(constants.mfq12()));
			questions_label.add(new Label(constants.mfq13()));
			questions_label.add(new Label(constants.mfq14()));
			questions_label.add(new Label(constants.mfq15()));
			questions_label.add(new Label(constants.mfq16()));

			for(int i=0; i<questions_label.size(); i++)
				questions_label.get(i).setStylePrimaryName("Label-style");
			
			// initialize
			flexTable.setText(0, 1, constants.mfq_explanation_part1_zero());
			flexTable.setText(0, 2, constants.mfq_explanation_part1_one());
			flexTable.setText(0, 3, constants.mfq_explanation_part1_two());
			flexTable.setText(0, 4, constants.mfq_explanation_part1_three());
			flexTable.setText(0, 5, constants.mfq_explanation_part1_four());
			flexTable.setText(0, 6, constants.mfq_explanation_part1_five());
			flexTable.getFlexCellFormatter().setRowSpan(0, 0, 2);
			flexTable.setText(1, 0, constants.zero());
			flexTable.setText(1, 1, constants.one());
			flexTable.setText(1, 2, constants.two());
			flexTable.setText(1, 3, constants.three());
			flexTable.setText(1, 4, constants.four());
			flexTable.setText(1, 5, constants.five());

			for(int i=0; i<maxQuestionNo; i++) {
				for(int j=0; j<maxAnswerNo; j++) {
					flexTable.setText(2+i, 1+j, " ");
					flexTable.getCellFormatter().setWidth(2+i, 0, "350px");
					flexTable.getCellFormatter().setHeight(2+i, 0, "40px");
				}
			}

			for(int i=0; i<maxAnswerNo; i++) {
				flexTable.getCellFormatter().setHorizontalAlignment(0, i+1, HasHorizontalAlignment.ALIGN_CENTER);
				flexTable.getCellFormatter().setHorizontalAlignment(1, i, HasHorizontalAlignment.ALIGN_CENTER);
				flexTable.getCellFormatter().setWidth(2, i+1, "60px");
			}
			
			setQuestion(0, experimentConditions);
		}

		applyDataRowStyles();
		absolutePanel.add(explanation, 10, 10);
		absolutePanel.add(flexTable, 10, 60);
		absolutePanel.setSize("750px", "550px");
	}
	
	private void applyDataRowStyles() {
		flexTable.setStyleName("FlexTable");
		HTMLTable.RowFormatter rf = flexTable.getRowFormatter();
		
		rf.addStyleName(0, "FlexTable-ColumnLabel");
		rf.addStyleName(1, "FlexTable-ColumnChoice");
		
		for(int row=2; row<flexTable.getRowCount(); ++row) {
			if(row%2 != 0)
				rf.addStyleName(row, "FlexTable-OddRow");
			else
				rf.addStyleName(row, "FlexTable-EvenRow");
		}
	}
	
	public void applyDataRowStylesAgain(int row) {
		for(int col=1; col<=maxAnswerNo; col++) {
			if(row%2 != 0)
				flexTable.getCellFormatter().setStyleName(row, col, "FlexTable-OddRow");
			else
				flexTable.getCellFormatter().setStyleName(row, col, "FlexTable-EvenRow");
		}
	}
	
	public void setQuestion(final int currentQuestionNo, final ExperimentConditions experimentConditions) {
		flexTable.setWidget(2+currentQuestionNo, 0, questions_label.get(currentQuestionNo));
		
		for(int i=0; i<maxAnswerNo; i++) {
			final RadioButton radioButton = new RadioButton("Q"+currentQuestionNo);
			radioButton.setTabIndex(i);
			flexTable.getCellFormatter().setHorizontalAlignment(2+currentQuestionNo, i+1, HasHorizontalAlignment.ALIGN_CENTER);
			flexTable.setWidget(2+currentQuestionNo, i+1, radioButton);

			radioButton.addClickHandler(new ClickHandler(){
				public void onClick(ClickEvent event) {
					userAnswer[currentQuestionNo] = radioButton.getTabIndex();
					applyDataRowStylesAgain(2+currentQuestionNo);
					flexTable.getCellFormatter().setStyleName(2+currentQuestionNo, radioButton.getTabIndex()+1, "FlexTable-SelectedCell");

					if(currentQuestionNo < maxQuestionNo-1 && currentQuestionNo+1 == currentMaxQuestionNo-1) {
						currentMaxQuestionNo = currentMaxQuestionNo+1;
						setQuestion(currentQuestionNo+1, experimentConditions);
					} else if(currentQuestionNo < maxQuestionNo-1) {
						// do nothing
					} else {
						submit(experimentConditions);
					}
				}
			});
		}
	}
	
	public void submit(final ExperimentConditions experimentConditions) {
		Button btnSubmit = new Button(constants.ok_button());
		btnSubmit.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				hide();
				experimentConditions.setMFQ_09(userAnswer[0]);
				experimentConditions.setMFQ_10(userAnswer[1]);
				experimentConditions.setMFQ_11(userAnswer[2]);
				experimentConditions.setMFQ_12(userAnswer[3]);
				experimentConditions.setMFQ_13(userAnswer[4]);
				experimentConditions.setMFQ_14(userAnswer[5]);
				experimentConditions.setMFQ_15(userAnswer[6]);
				experimentConditions.setMFQ_16(userAnswer[7]);
	
				final MoralFoundationsQuestionnaire3DialogBox dialogBox = new MoralFoundationsQuestionnaire3DialogBox (eventBus, experimentConditions);
				dialogBox.center();
			}
		});

		btnSubmit.setSize("250px", "33px");
		absolutePanel.add(btnSubmit, 250, 500);
	}	
}

