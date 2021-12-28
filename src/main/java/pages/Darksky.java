package pages;

import org.openqa.selenium.By;

import java.util.ArrayList;

public class Darksky extends Base {

    By currentTemp = By.xpath("//span[@class='summary swap']");
    By timeLineTemp = By.xpath("//span[@class='first']//span");
    By timeListRaw = By.xpath("//span[@class='hour']/span");

    public ArrayList<Integer> getTimeListInt()
    {
        ArrayList<Integer> timeList = new ArrayList<>();
        ArrayList<String> timeListStr=getElementTextList(timeListRaw);
        System.out.println(timeListStr);
        //[11pm, 1am, 3am, 5am, 7am, 9am, 11am, 1pm, 3pm, 5pm, 7pm]

        for (int i=0;i<timeListStr.size();i++)
        {
            String tempTime = timeListStr.get(i); // "11pm" or "3am"
            int l = tempTime.length();
            String timeStr = tempTime.substring(0,l-2); // "11" or "3"

            int time = Integer.parseInt(timeStr);
            timeList.add(time);
        }

        // [11, 1, 3, 5, 7, 9, 11, 1, 3, 5, 7]
        return timeList;
    }



    public String getCurrentTemp()
    {
        return getTextFromElement(currentTemp).split("˚")[0]; //60˚ Mostly Cloudy.
    }

    public String getTimeLineTemp()
    {
       return getTextFromElement(timeLineTemp).split("°")[0]; // 60°
    }
}
