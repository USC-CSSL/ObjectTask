package edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.decision_making;



public enum AlgorithmicCounterpartDecisionMakingStrategyEnum {
/*	prespecifiedConcederLastOfferFixed,
	prespecifiedConcederFirstOfferFixed,
	prespecifiedNonconcederLastOfferFixed,
	prespecifiedNonconcederFirstOfferFixed;*/
	prespecifiedConceder,
	prespecifiedNonconceder,
	prespecifiedConcederGentleSlope,
	prespecifiedNonconcederSteepSlope,
	randomStrategy2,
	randomStrategy,
	titfortat;

	public String toString() {

		final String result;

		switch (this) {
/*		case prespecifiedConcederFirstOfferFixed:
			result = "Conceder, using its most greedy preprogrammed offers";
			break;*/
		case prespecifiedConceder:
			result = "Conceder, using its least greedy preprogrammed offers";
			break;
		case prespecifiedNonconceder:
			result = "Non-conceder, using its most greedy preprogrammed offers";
			break;
		case prespecifiedConcederGentleSlope:
			result = "Conceder2, using its 2nd least greedy preprogrammed offers";
			break;			
		case prespecifiedNonconcederSteepSlope:
			result = "Non-conceder2, using its 2nd most greedy preprogrammed offers";
			break;
/*		case prespecifiedNonconcederLastOfferFixed:
			result = "Non-conceder, using its least greedy preprogrammed offers.";
			break;*/
		case randomStrategy2:
			result = "Random2: Non-conceder or Conceder";
			break;
		case randomStrategy:
			result = "Random: Non-conceder, Non-conceder2, Conceder or Conceder2";
			break;
		case titfortat:
			result = "Tit for tat";
			break;
		default:
			final IllegalStateException e = new IllegalStateException("Unhandled " + this.getClass().getName() + " in " + this.getClass().getName() + ".toString()");
			throw e;
		};

		return result;
	};


	public ProposalDecisionMakingStrategy getProposalDecisionMakingStrategy(final int negotiationSessionPlyCount) {

/*		final PlyRemainingIndexedProposalGenerator proposalGenerator;		
		switch (this) {
		//case prespecifiedConcederLastOfferFixed:
		case prespecifiedConceder:
			proposalGenerator = new PrespecifiedConceder();
			break;
		//case prespecifiedNonconcederLastOfferFixed:
		case prespecifiedNonconceder:
			proposalGenerator = new PrespecifiedNonconceder();
			break;
		case randomStrategy:
			proposalGenerator = new PrespecifiedNonconceder();
			break;
		case titfortat:
			proposalGenerator = new Titfortat();
			break;
		default:			
			throw new IllegalStateException("Unhandled AlgorithmicCounterpartEmotionalReactionDeterminationStrategyEnum in AlgorithmicCounterpartEmotionalReactionDeterminationStrategyEnum.getProposalDecisionMakingStrategy().");
		};

		final int plyAdjustmentOffset;
		switch (this) {
		//case prespecifiedConcederLastOfferFixed:
		case prespecifiedConceder:
			//plyAdjustmentOffset = 0;
			plyAdjustmentOffset = 24 - negotiationSessionPlyCount;
			break;
		//case prespecifiedConcederFirstOfferFixed:
		case prespecifiedNonconceder:
			plyAdjustmentOffset = 24 - negotiationSessionPlyCount;
			break;
		case titfortat:
			plyAdjustmentOffset = 24 - negotiationSessionPlyCount;
			break;
		default:			
			throw new IllegalStateException("Unhandled AlgorithmicCounterpartEmotionalReactionDeterminationStrategyEnum in AlgorithmicCounterpartEmotionalReactionDeterminationStrategyEnum.getProposalDecisionMakingStrategy().");		
		};*/

		// Added Tit for Tat
		final ProposalDecisionMakingTactic tactic;
		switch (this) {
		case prespecifiedConceder:
			tactic = new PrespecifiedPotentialCounterproposalTactic(new PrespecifiedConceder(), 24 - negotiationSessionPlyCount);
			break;
		case prespecifiedNonconceder:
			tactic = new PrespecifiedPotentialCounterproposalTactic(new PrespecifiedNonconceder(), 24 - negotiationSessionPlyCount);
			break;
		case prespecifiedConcederGentleSlope:
			tactic = new PrespecifiedPotentialCounterproposalTactic(new PrespecifiedConcederGentleSlope(), 24 - negotiationSessionPlyCount);
			break;
		case prespecifiedNonconcederSteepSlope:
			tactic = new PrespecifiedPotentialCounterproposalTactic(new PrespecifiedNonconcederSteepSlope(), 24 - negotiationSessionPlyCount);
			break;
		case titfortat:
			tactic = new TitfortatPotentialCounterproposalTactic();
			break;
		default:			
			throw new IllegalStateException("Unhandled AlgorithmicCounterpartEmotionalReactionDeterminationStrategyEnum in AlgorithmicCounterpartEmotionalReactionDeterminationStrategyEnum.getProposalDecisionMakingStrategy().");		
		}
		
//		final ProposalDecisionMakingTactic tactic = new PrespecifiedPotentialCounterproposalTactic(proposalGenerator, plyAdjustmentOffset);
		final ProposalDecisionMakingStrategy result = new RationalProposalDecisionMakingStrategy(tactic);
		return result;
	};

};
