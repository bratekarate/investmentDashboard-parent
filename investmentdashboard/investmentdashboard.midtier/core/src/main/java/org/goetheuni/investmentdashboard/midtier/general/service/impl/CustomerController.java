package org.goetheuni.investmentdashboard.midtier.general.service.impl;

import java.util.Collections;
import java.util.List;

import org.goetheuni.investmentdashboard.shared.impl.CashAccount;
import org.goetheuni.investmentdashboard.shared.impl.CryptoWallet;
import org.goetheuni.investmentdashboard.shared.impl.Customer;
import org.goetheuni.investmentdashboard.shared.impl.SecurityDepot;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

/**
 * Controller for Login-Page.
 */
@Controller
public class CustomerController {

  /**
   * Default URL to redirect to after successfully login.
   */
  public final static String defaultTargetUrl = "/";

  private final RestTemplate restTemplate;

  /**
   * The constructor.
   *
   * @param restTemplate
   */
  public CustomerController(RestTemplate restTemplate) {

    this.restTemplate = restTemplate;
  }

  /**
   * Builds the model for the login page---mainly focusing on the error message handling.
   *
   * @param authentication_failed flag for authentication failed
   * @param invalid_session flag for invalid session
   * @param access_denied flag for access denied
   * @param logout flag for successful logout
   * @return the view model
   */
  @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
  public ResponseEntity<Customer> getKunde(@PathVariable(value = "id") Long kundenId) {

    // final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    // if (!authentication.getPrincipal().equals("anonymousUser")) {
    // return new ModelAndView("redirect:" + defaultTargetUrl);
    // }

    // this is only a dummy and can be removed
    // new SecurityTransaction(3, BigDecimal.valueOf(30), new Security("isin", "name", "shortName"), new Date(500000));
    //
    // ModelAndView model = new ModelAndView();
    // if (authentication_failed) {
    // model.addObject("error", "Authentication failed!");
    // } else if (invalid_session) {
    // model.addObject("error", "You are currently not logged in!");
    // } else if (access_denied) {
    // model.addObject("error", "You have insufficient permissions to access this page!");
    // } else if (logout) {
    // model.addObject("msg", "Logout successful!");
    // }
    //

    // get cash accounts from other service
    List<CashAccount> cashAccounts = this.restTemplate.exchange("http://localhost:8082/cashaccounts/" + kundenId,
        HttpMethod.GET, null, new ParameterizedTypeReference<List<CashAccount>>() {
        }).getBody();

    if (cashAccounts == null || cashAccounts.isEmpty()) {
      throw new RuntimeException("No Data received");
    }

    // TODO: get rest of customer data from external services as well
    List<CryptoWallet> cryptoWallets = Collections.emptyList();
    List<SecurityDepot> securityDepots = Collections.emptyList();

    Customer customer = new Customer(Long.toString(kundenId), "", cashAccounts, cryptoWallets, securityDepots);

    return new ResponseEntity<>(customer, HttpStatus.OK);
  }

}
