package org.goetheuni.investmentdashboard.midtier.general;

import java.util.Map;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author brate
 *
 */
@EqualsAndHashCode
@RequiredArgsConstructor
@Getter
public class TestClass {
  private final String testing;

  private final Long foo;

  private final Map<Long, String> datMap;
}
