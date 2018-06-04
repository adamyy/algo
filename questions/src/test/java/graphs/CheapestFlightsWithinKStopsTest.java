package graphs;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class CheapestFlightsWithinKStopsTest {

  @Test
  public void findCheapestPrice() {
    int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
    assertThat(
        CheapestFlightsWithinKStops.findCheapestPrice(3, flights, 0, 2, 1)
    ).isEqualTo(200);
    assertThat(
        CheapestFlightsWithinKStops.findCheapestPrice(3, flights, 0, 2, 0)
    ).isEqualTo(500);
    int[][] someOtherFlights = {{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}};
    assertThat(
        CheapestFlightsWithinKStops.findCheapestPrice(4, someOtherFlights, 0, 3, 1)
    ).isEqualTo(6);
  }
}