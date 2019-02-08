package design;

/**
 * Airlines often give customers who fly frequently with them a "status".
 * This status allows them early boarding, more baggage, upgrades to executive class, etc.
 * Typically, status is a function of miles flown in the past twelve months.
 * People who travel frequently by air sometimes want to take a round trip flight simply to maintain their status.
 * The destination is immaterial—the goal is to minimize the cost-per-mile (cpm), i.e., the ratio of dollars spent to miles flown.
 *
 * Design a system that will help its users find mileage runs.
 *
 * Hint: Partition the implied features into independent tasks.
 *
 * Two aspects: user-facing portion and the server backend that gets flight-price-distance information
 * and combines it with user input to generate the alerts
 *
 * User-facing portion
 *    login page
 *        single-sign-on login service such as Google and Facebook
 *    manage alert page
 *        present login information, a list of alerts, and the ability to create an alert
 *    create an alert page
 *    result page
 *        show flights satisfying the constraints
 *
 * Alert Model
 *    origin city
 *    target cpm
 *    date/range-of-date
 *
 * Other formulations
 *    how frequently to check for flights
 *    a set of destinations
 *    a set of origins
 *
 * Backend web-app
 *    gathering flight data
 *        scrape or subscribe to a flight data service
 *    matching user-generated alerts to the data
 *    persisting data and alerts
 *    respond to browser initiated requests
 *
 */
public class MileageRun {
}
