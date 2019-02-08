package design;

/**
 * Jingle, a search engine startup, has been very successful at providing a high-quality Internet search service.
 * A large number of customers have approached Jingle and asked it to display paid advertisements
 * for their products and services alongside search results.
 *
 * Design an advertising system for Jingle.
 *
 * Hint: Consider the stakeholders separately.
 *
 * reasonable goals:
 *  - providing users with the most relevant ads
 *  - providing advertisers the best possible return on their investment
 *  - minimizing the cost and maximizing the revenue
 *
 * system components:
 *  - front-facing component: where advertisers use to create advertisements, organize campaigns,
 *    limit when and where ads are shown, set budgets, and create performance reports
 *      - can be a conventional web applications, i.e., a set of web pages, middleware that responds to
 *        user requests, and a database, key features include
 *          - user authentication
 *          - user input
 *          - performance reports
 *          - customer service
 *
 *  - the ad-serving system, which selects which ads to show on the searches
 *      - build a specialized data structure, such as a decision tree, from the ads database
 *      - chooses ads from the database of ads based on their "relevance" to the search
 *      - in addition to keywords, the system can use knowledge of user's search history, advertiser's budget,
 *        date and time, locale, type of browser, etc.
 *
 *
 *
 *
 */
public class OnlineAdvertisingSystem { }
