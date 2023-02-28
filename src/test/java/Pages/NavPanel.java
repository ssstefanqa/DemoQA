package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NavPanel extends BaseTest {

    public NavPanel() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = ".btn.btn-light")
    public List<WebElement> NavPanelList;

    // -----

    public void clickOnNavPanelTab(String tabName) {
        for (int i = 0; i < NavPanelList.size(); i++) {
            if (NavPanelList.get(i).getText().equals(tabName)) {
                scrollIntoView(NavPanelList.get(i));
                NavPanelList.get(i).click();
                break;
            }
        }
    }


}



