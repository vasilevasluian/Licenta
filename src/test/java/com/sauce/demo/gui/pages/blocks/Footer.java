package com.sauce.demo.gui.pages.blocks;

import com.sauce.demo.common.LocatorType;
import com.sauce.demo.gui.components.PageElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@NoArgsConstructor
@Component
@Scope("prototype")
public class Footer {
    private PageElement twitterButton= PageElement.locate(LocatorType.CSS_SELECTOR, ".social_twitter");
    private PageElement facebookButton= PageElement.locate(LocatorType.CSS_SELECTOR, ".social_facebook");
    private PageElement linkedinButton= PageElement.locate(LocatorType.CSS_SELECTOR, ".social_linkedin");
    private PageElement footerData= PageElement.locate(LocatorType.CSS_SELECTOR, ".footer_copy");

}
