package net.sf.borg.ui.task;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * User: Viet Hung Nguyen
 * Date: 07/04/13
 * Time: 9:46 PM
 */
public class DateUtil {
    /**
     * determine the number fo days between two dates
     *
     * @param start
     *            the first date
     * @param dd
     *            the later date
     *
     * @return the int
     */
    public static int daysBetween(Date start, Date dd) {

        if (dd == null)
            return 0;
        Calendar startcal = new GregorianCalendar();
        Calendar dcal = new GregorianCalendar();
        dcal.setTime(dd);
        startcal.setTime(start);

        // find days left
        int days = 0;
        if (dcal.get(Calendar.YEAR) == startcal.get(Calendar.YEAR)) {
            days = dcal.get(Calendar.DAY_OF_YEAR)
                    - startcal.get(Calendar.DAY_OF_YEAR);
        } else {
            days = new Long((dd.getTime() - startcal.getTime().getTime())
                    / (1000 * 60 * 60 * 24)).intValue();
        }

        // if due date is past, set days left to 0
        // negative days are silly
        if (days < 0)
            days = 0;
        return days;
    }

    /**
     * return the number of days left before a given date.
     *
     * @param dd
     *            the date
     *
     * @return the number of days left
     */
    public static int daysLeft(Date dd) {

        if (dd == null)
            return 0;
        Calendar today = new GregorianCalendar();
        Calendar dcal = new GregorianCalendar();
        dcal.setTime(dd);

        // find days left
        int days = 0;
        if (dcal.get(Calendar.YEAR) == today.get(Calendar.YEAR)) {
            days = dcal.get(Calendar.DAY_OF_YEAR)
                    - today.get(Calendar.DAY_OF_YEAR);
        } else {
            days = new Long((dd.getTime() - today.getTime().getTime())
                    / (1000 * 60 * 60 * 24)).intValue();
        }

        // if due date is past, set days left to 0
        // negative days are silly
        if (days < 0)
            days = 0;
        return days;
    }
}
