package org.goetheuni.investmentdashboard.service.customers.general.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.goetheuni.investmentdashboard.shared.impl.CashAccount;
import org.goetheuni.investmentdashboard.shared.impl.CashPayment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller for Login-Page.
 */
@Controller
public class CashAccountController {

  /**
   * Default URL to redirect to after successfully login.
   */
  public final static String defaultTargetUrl = "/";

  /**
   * Builds the model for the login page---mainly focusing on the error message handling.
   *
   * @param authentication_failed flag for authentication failed
   * @param invalid_session flag for invalid session
   * @param access_denied flag for access denied
   * @param logout flag for successful logout
   * @return the view model
   */
  @RequestMapping(value = "/cashaccounts/{id}", method = RequestMethod.GET)
  public ResponseEntity<List<CashAccount>> getCashAccounts(@PathVariable(value = "id") Long kundenId) {

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

    List<CashPayment> payments = new ArrayList<>();
    List<CashAccount> cashAccounts =
        Arrays.asList(new CashAccount("" + kundenId, "", "", payments, new BigDecimal("0"), "EUR"));

    return new ResponseEntity<>(cashAccounts, HttpStatus.OK);
  }

}
