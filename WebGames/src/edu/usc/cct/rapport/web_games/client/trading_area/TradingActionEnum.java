package edu.usc.cct.rapport.web_games.client.trading_area;

import com.google.gwt.core.client.GWT;

public enum TradingActionEnum {
	makeInitialProposal,
	acceptProposal,
	makeCounterproposal,
	claimBATNAValue;
//	reviewScenario;


	static final private TradingActionsInternationalizationConstants constants = GWT.create(TradingActionsInternationalizationConstants.class);


	String getButtonDescription() {

		String result;

		switch (this) {
		case makeInitialProposal:
			result = constants.makeInitialProposal();
			break;
		case acceptProposal:
			result = constants.acceptProposal();
			break;
		case makeCounterproposal:
			result = constants.makeCounterproposal();
			break;
		case claimBATNAValue:
			result = constants.claimBATNAScore();
			break;
//		case reviewScenario:
//			result = constants.reviewScenario();
//			break;
		default:
			throw new IllegalStateException("Unhandled TradingActionEnum in TradingActionEnum.getDescription().");
		};

		return result;
	};


	String getDialogBoxDescription() {

		String result;

		switch (this) {
		case acceptProposal:
			result = constants.agreementReached();
			break;
		case claimBATNAValue:
			result = constants.agreementNotReached();
			break;
//		case reviewScenario:
//			result = constants.reviewScenario();
//			break;
		case makeInitialProposal:
		case makeCounterproposal:
			final IllegalStateException iseNegotiationSessionCannotFinishWithProposalOffer = new IllegalStateException("The negotiation session should not have ended with a proposal being offered.");
			throw iseNegotiationSessionCannotFinishWithProposalOffer;
		default:
			final IllegalStateException iseUnhandledTradingActionEnum = new IllegalStateException("Unhandled TradingActionEnum in TradingActionEnum.getDescription().");
			throw iseUnhandledTradingActionEnum;
		};

		return result;
	};

};
