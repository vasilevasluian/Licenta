package com.sauce.demo.gui;

import com.sauce.demo.gui.pages.blocks.Header;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
}
