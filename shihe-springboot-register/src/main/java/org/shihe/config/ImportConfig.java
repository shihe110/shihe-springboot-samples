package org.shihe.config;

import org.shihe.impor.User;
import org.shihe.regsit.RegisUser;
import org.shihe.selector.CustomImportSelector;
import org.shihe.selector.SelectorUser;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @ClassName ImportConfig
 * @Description TODO
 * @Author admin
 * @Date 2020-08-21 22:23
 * @Version 1.0
 */
@Configuration
@Import({User.class, SelectorUser.class, RegisUser.class})
public class ImportConfig {
}
