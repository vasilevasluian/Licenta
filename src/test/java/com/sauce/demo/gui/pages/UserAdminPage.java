package com.sauce.demo.gui.pages;

import com.sauce.demo.gui.components.PageElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@NoArgsConstructor
@Component
@Scope("prototype")
public class UserAdminPage {

    private PageElement searchField = PageElement.locate("//input[@placeholder='Search...']");

    private PageElement showNumberOfUsers = PageElement.locate("//div[@class='dropdown btn-group'][1]");

    private PageElement filterForDisplayUsers = PageElement.locate("//div[@class='dropdown btn-group'][2]");

    private PageElement firstNameColumn = PageElement.locate("//span[text()='First Name']");

    private PageElement lastNameColumn = PageElement.locate("//span[text()='Last Name']");

    private PageElement emailColumn = PageElement.locate("//span[text()='Email']");

    private PageElement roleColumn = PageElement.locate("//span[text()='Role']");

    private PageElement showTenEntriesFilter = PageElement.locate("//li[@value='10']");

    private PageElement showTwentyFiveEntriesFilter = PageElement.locate("//li[@value='25']");

    private PageElement showFiftyEntriesFilter = PageElement.locate("//li[@value='50']");

    private PageElement showAllEntriesFilter = PageElement.locate("//li[@value='0']");

    private PageElement firstNameCheckBox = PageElement.locate("//label[@for='First Name']");

    private PageElement lastNameCheckBox = PageElement.locate("//label[@for='Last Name']");

    private PageElement emailNameCheckBox = PageElement.locate("//label[@for='Email']");

    private PageElement roleNameCheckBox = PageElement.locate("//label[@for='Role']");
}
