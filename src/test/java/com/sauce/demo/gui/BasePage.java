package com.sauce.demo.gui;

import com.sauce.demo.gui.pages.blocks.Footer;
import com.sauce.demo.gui.pages.blocks.Header;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@NoArgsConstructor
@Component
@Scope("prototype")
public class BasePage {

    @Autowired
    Header header;

    @Autowired
    Footer footer;

    public void validateFooter(){
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(getFooter().getFooterData().isPresent())
                    .describedAs("Footer data is displayed")
                    .isTrue();
            softly.assertThat(getFooter().getLinkedinButton().isPresent())
                    .describedAs("LinkedIn Button is displayed")
                    .isTrue();
            softly.assertThat(getFooter().getFacebookButton().isPresent())
                    .describedAs("Facebook Button is displayed")
                    .isTrue();
            softly.assertThat(getFooter().getTwitterButton().isPresent())
                    .describedAs("Twitter Button is displayed")
                    .isTrue();
        });
    }

    public void validateHeader(){
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(getHeader().getAppLogo().isPresent())
                    .describedAs("App logo is displayed")
                    .isTrue();
            softly.assertThat(getHeader().getShoppingCart().isPresent())
                    .describedAs("Shopping cart is displayed")
                    .isTrue();
            softly.assertThat(getHeader().getMenuButton().isPresent())
                    .describedAs("Menu button is displayed")
                    .isTrue();
        });
    }
}
