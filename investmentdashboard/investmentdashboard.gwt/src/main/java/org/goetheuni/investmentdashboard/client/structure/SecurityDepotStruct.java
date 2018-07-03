package org.goetheuni.investmentdashboard.client.structure;

import java.math.BigDecimal;
import java.util.Objects;

import org.goetheuni.investmentdashboard.shared.impl.CryptoMarketData;
import org.goetheuni.investmentdashboard.shared.impl.SecurityDepot;
import org.goetheuni.investmentdashboard.shared.impl.SecurityInvestment;
import org.goetheuni.investmentdashboard.shared.impl.SecurityMarketData;

/**
 * Objects of this class represent security depots in the logical structure of the dash board page. 
 */
public class SecurityDepotStruct implements EURComputable{

	/**
	 * The data of this security depot
	 */
	protected SecurityDepot data; 
	
	/* (non-Javadoc)
	 * @see org.goetheuni.investmentdashboard.client.structure.EURComputable#computeBalanceInEUR(org.goetheuni.investmentdashboard.shared.impl.SecurityMarketData, org.goetheuni.investmentdashboard.shared.impl.CryptoMarketData)
	 */
	@Override
	public BigDecimal computeBalanceInEUR(SecurityMarketData secMarket, CryptoMarketData cryptoMarket) {
		// validate input
		Objects.requireNonNull(secMarket, "Cannot compute the balance because the given security market data was null");
		
		// compute the value of all investments
		BigDecimal result = BigDecimal.valueOf(0);
				
		for(SecurityInvestment investment : this.data.getPortfolio()) {
			// try to get the prize from the prize list
			BigDecimal prize = secMarket.getMarketPrizes().get(investment.getSecurity().getIsin());
			
			if(prize != null) {
				// a prize for the ISIN is know -> this is fine
				// add prize * quantity
				result = result.add(prize.multiply(BigDecimal.valueOf(investment.getQuantity())));
			}else {
				throw new RuntimeException("The prize for the following ISIN was unkown: "+investment.getSecurity().getIsin()+" , the prize list was: " + secMarket.getMarketPrizes().toString());
			}
		}
		
		return result;
	}

	protected SecurityDepotStruct(SecurityDepot depotData) {
		this.data = Objects.requireNonNull(depotData, "The given SecurityDepot data object must not be null.");
	}
}
