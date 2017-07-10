package org.tests.external;

/**
 * Created by GArlington on 09/02/2016.
 */
public interface MovieService {
    String getParentalControlLevel(String movieId) throws TitleNotFoundException, TechnicalFailureException;
}
