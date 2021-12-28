package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.Darksky;

import java.util.ArrayList;

import static stepdefinition.SharedSD.getDriver;

public class DarkskySD {

    Darksky darksky = new Darksky();


    @Given("^I am on Darksky Home Page$")
    public void i_am_on_darksky_home_page() throws Throwable {

        Assert.assertEquals("This is not the darksky home page",
                "Dark Sky - Sansad Marg, New Delhi, Delhi",
                getDriver().getTitle()

                );
    }

    @Then("^I verify current temp is equal to Temperature from Daily Timeline$")
    public void i_verify_current_temp_is_equal_to_temperature_from_daily_timeline()
    {

        String expected = darksky.getCurrentTemp();
        String actual = darksky.getTimeLineTemp();

        System.out.println("Expected = "+expected);
        System.out.println("Actual = "+actual);

        Assert.assertEquals("different temp",expected,actual);
    }

    @Then("I verify timeline is displayed with two hours incremented")
    public void iVerifyTimelineIsDisplayedWithTwoHoursIncremented() {

        ArrayList<Integer> timeList = darksky.getTimeListInt();
        System.out.println(timeList);
        //[11, 1, 3, 5, 7, 9, 11, 1, 3, 5, 7]

        ArrayList<Integer> timeDiffList = new ArrayList<>();
        for(int i =0;i<timeList.size()-1;i++) // 11
        {
            int time1 = timeList.get(i);
            int time2 = timeList.get(i+1);
            int timeDiff = 0;

            if(time2>time1)
                timeDiff = time2-time1;
            if(time2<time1)
                timeDiff = (time2 + 12)-time1;

            timeDiffList.add(timeDiff);
        }
        System.out.println(timeDiffList);

        // [2, 2, 2, 2, 2, 2, 2, 2, 2, 2]
    }
}
