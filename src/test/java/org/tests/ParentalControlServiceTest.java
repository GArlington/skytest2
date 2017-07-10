package org.tests;

import org.junit.Before;
import org.junit.Test;
import org.tests.external.MovieService;
import org.tests.external.ParentalControlLevel;
import org.tests.external.TechnicalFailureException;
import org.tests.external.TitleNotFoundException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by GArlington on 09/02/2016.
 */
public class ParentalControlServiceTest {
    private ParentalControlService victim;
    private MovieService movieService;

    @Before
    public void setUp() {
        movieService = mock(MovieService.class);
        victim = new ParentalControlService(movieService);
    }

    @Test
    public void testIsMovieAvailable() throws Exception {
        String validMovieId = "validMovieId";
        String clientParentalControlLevel = ParentalControlLevel.Level_U.name();
        String movieParentalControlLevel = ParentalControlLevel.Level_U.name();
        when(movieService.getParentalControlLevel(validMovieId)).thenReturn(movieParentalControlLevel);
        boolean result = victim.isMovieAvailable(clientParentalControlLevel, validMovieId);
        assertTrue(result);
        String expected = ParentalControlService.OK;
        String reason = victim.getMovieUnavailableReason(clientParentalControlLevel, validMovieId);
        assertEquals(expected, reason);
    }

    @Test
    public void testGetMovieAvailableReason() throws Exception {
        String validMovieId = "validMovieId";
        String clientParentalControlLevel = ParentalControlLevel.Level_U.name();
        String movieParentalControlLevel = ParentalControlLevel.Level_U.name();
        when(movieService.getParentalControlLevel(validMovieId)).thenReturn(movieParentalControlLevel);
        String expected = ParentalControlService.OK;
        String result = victim.getMovieUnavailableReason(clientParentalControlLevel, validMovieId);
        assertEquals(expected, result);
    }

    @Test(expected = TitleNotFoundException.class)
    public void testIsMovieUnAvailable1() throws Exception {
        String invalidMovieId = "invalidMovieId";
        String clientParentalControlLevel = ParentalControlLevel.Level_U.name();
        String movieParentalControlLevel = ParentalControlLevel.Level_U.name();
        Exception exception = new TitleNotFoundException("TitleNotFoundException");
        when(movieService.getParentalControlLevel(invalidMovieId)).thenThrow(exception);
        boolean result = victim.isMovieAvailable(clientParentalControlLevel, invalidMovieId);
        String expected = exception.getMessage();
        String reason = victim.getMovieUnavailableReason(clientParentalControlLevel, invalidMovieId);
        assertEquals(expected, reason);
    }

    @Test
    public void testGetMovieUnavailableReason1() throws Exception {
        String invalidMovieId = "invalidMovieId";
        String clientParentalControlLevel = ParentalControlLevel.Level_U.name();
        String movieParentalControlLevel = ParentalControlLevel.Level_U.name();
        Exception exception = new TitleNotFoundException("TitleNotFoundException");
        when(movieService.getParentalControlLevel(invalidMovieId)).thenThrow(exception);
        String expected = exception.getMessage();
        String result = victim.getMovieUnavailableReason(clientParentalControlLevel, invalidMovieId);
        assertEquals(expected, result);
    }

    @Test(expected = TechnicalFailureException.class)
    public void testIsMovieUnAvailable2() throws Exception {
        String validMovieId = "validMovieId";
        String clientParentalControlLevel = ParentalControlLevel.Level_U.name();
        String movieParentalControlLevel = ParentalControlLevel.Level_U.name();
        Exception exception = new TechnicalFailureException("TechnicalFailureException");
        when(movieService.getParentalControlLevel(validMovieId)).thenThrow(exception);
        boolean result = victim.isMovieAvailable(clientParentalControlLevel, validMovieId);
        String expected = exception.getMessage();
        String reason = victim.getMovieUnavailableReason(clientParentalControlLevel, validMovieId);
        assertEquals(expected, reason);
    }

    @Test
    public void testGetMovieUnavailableReason2() throws Exception {
        String validMovieId = "validMovieId";
        String clientParentalControlLevel = ParentalControlLevel.Level_U.name();
        String movieParentalControlLevel = ParentalControlLevel.Level_U.name();
        Exception exception = new TechnicalFailureException("TechnicalFailureException");
        when(movieService.getParentalControlLevel(validMovieId)).thenThrow(exception);
        String expected = exception.getMessage();
        String result = victim.getMovieUnavailableReason(clientParentalControlLevel, validMovieId);
        assertEquals(expected, result);
    }

    @Test
    public void testIsMovieUnAvailable3() throws Exception {
        String validMovieId = "validMovieId";
        String clientParentalControlLevel = ParentalControlLevel.Level_U.name();
        String movieParentalControlLevel = ParentalControlLevel.Level_PG.name();
        when(movieService.getParentalControlLevel(validMovieId)).thenReturn(movieParentalControlLevel);
        boolean result = victim.isMovieAvailable(clientParentalControlLevel, validMovieId);
        assertFalse(result);
        String expected = ParentalControlService.PARENTAL_CONTROL_LEVEL_EXCEEDED;
        String reason = victim.getMovieUnavailableReason(clientParentalControlLevel, validMovieId);
        assertEquals(expected, reason);
    }

    @Test
    public void testGetMovieUnavailableReason3() throws Exception {
        String validMovieId = "validMovieId";
        String clientParentalControlLevel = ParentalControlLevel.Level_U.name();
        String movieParentalControlLevel = ParentalControlLevel.Level_PG.name();
        when(movieService.getParentalControlLevel(validMovieId)).thenReturn(movieParentalControlLevel);

        String expected = ParentalControlService.PARENTAL_CONTROL_LEVEL_EXCEEDED;
        String reason = victim.getMovieUnavailableReason(clientParentalControlLevel, validMovieId);
        assertEquals(expected, reason);
    }
}