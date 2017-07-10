package org.tests;

import org.tests.external.MovieService;
import org.tests.external.ParentalControlLevel;
import org.tests.external.TechnicalFailureException;
import org.tests.external.TitleNotFoundException;

/**
 * Created by GArlington on 09/02/2016.
 */
public class ParentalControlService {
    public static final String OK = "OK";
    public static final String PARENTAL_CONTROL_LEVEL_EXCEEDED = "Movie is not suitable due to client's Parental Control Settings";

    private MovieService movieService;

    public ParentalControlService() {
    }

    public ParentalControlService(MovieService movieService) {
        this.movieService = movieService;
    }

    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    public String getMovieUnavailableReason(String clientParentalControlLevel, String movieId) {
        String reason = OK;
        try {
            if (!isMovieAvailable(clientParentalControlLevel, movieId))
                return PARENTAL_CONTROL_LEVEL_EXCEEDED;
        } catch (TechnicalFailureException | TitleNotFoundException e) {
            reason = e.getMessage();
        }
        return reason;
    }

    public boolean isMovieAvailable(String clientParentalControlLevel, String movieId) throws TechnicalFailureException, TitleNotFoundException {
        return isMovieAvailable(ParentalControlLevel.valueOf(clientParentalControlLevel), movieId);
    }

    public boolean isMovieAvailable(ParentalControlLevel clientParentalControlLevel, String movieId) throws TechnicalFailureException, TitleNotFoundException {
        return (clientParentalControlLevel.compareTo(ParentalControlLevel.valueOf(getParentalControlLevel(movieId))) >= 0);
    }

    private String getParentalControlLevel(String movieId) throws TitleNotFoundException, TechnicalFailureException {
        return movieService.getParentalControlLevel(movieId);
    }
}
