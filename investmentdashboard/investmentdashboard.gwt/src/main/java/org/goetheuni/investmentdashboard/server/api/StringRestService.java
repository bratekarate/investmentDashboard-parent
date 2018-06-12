package org.goetheuni.investmentdashboard.server.api;

import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.goetheuni.investmentdashboard.shared.domain.api.IStringForRest;
import org.goetheuni.investmentdashboard.shared.domain.impl.StringForRest;

/**
 * 
 * This class represents a simple Rest-Resource resource. A JSON representation
 * of an object holding a String will be returned. It is used to become familiar
 * with making Rest-call from the GWT client.
 */
@Path(ServicePaths.STRING_TEST_SERVICE)
public class StringRestService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	/**
	 * Constitutes a Rest-API returning a random (number, String) shaped object.
	 * 
	 * @return a random (number, String) object
	 */
	public StringForRest getStringObject() {
		return StringRestService.generateRandomStringObject();
	}



	/**
	 * generates a random object holding a number and a string
	 * 
	 * @return a random (number, String) object
	 */
	private static StringForRest generateRandomStringObject() {
		int randomKey = new Random().nextInt(4);
		String[] possibleValues = { "AAA", "BBB", "CCC", "DDD", "EEE" };
		return new StringForRest(String.valueOf(randomKey), possibleValues[randomKey]);
	}
}
