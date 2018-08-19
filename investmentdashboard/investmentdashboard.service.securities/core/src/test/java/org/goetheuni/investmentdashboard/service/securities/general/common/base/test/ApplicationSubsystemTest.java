package org.goetheuni.investmentdashboard.service.securities.general.common.base.test;

import io.oasp.module.test.common.base.SubsystemTest;

import org.goetheuni.investmentdashboard.service.securities.SpringBootApp;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

/**
 * Abstract base class for {@link SubsystemTest}s of this application.
 */
@SpringBootTest(classes = { SpringBootApp.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
public abstract class ApplicationSubsystemTest extends SubsystemTest {

}
