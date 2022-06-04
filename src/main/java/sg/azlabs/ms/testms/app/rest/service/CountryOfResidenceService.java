package sg.azlabs.ms.testms.app.rest.service;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sg.azlabs.ms.testms.app.model.CountryOfResidence;

import sg.azlabs.ms.testms.app.rest.model.CountryOfResidenceListResponse;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "countriesOfResidence", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Validated
public class CountryOfResidenceService extends BaseService{

    public CountryOfResidenceService() {
        log = getLogger(this.getClass());
    }

    @GetMapping
    public CountryOfResidenceListResponse list(
            @RequestParam("version") @Pattern(regexp = "^(DRAFT|PUBLISHED)$",
                    message = "Allowed Values : DRAFT, PUBLISHED") String version,
            @RequestParam("languageCode") @NotNull String languageCode) {
        final String methodName = "list";
        start(methodName);

        // Language Code
        List<String> languageList = getLanguageList(languageCode);

        System.out.println("THIS IS FOR MAIN BRANCH");
        
        System.out.println("Version: " + version);
        for (String language : languageList) {
            System.out.println("Language Code: " + language);
        }

        CountryOfResidence cor = new CountryOfResidence();
        cor.setCor("CUBA");
        cor.setUid("1");
        cor.setLanguageCode("EN");
        cor.setPublishFlag(true);
        cor.setOrder(1);

        List<CountryOfResidence> list = new ArrayList<>();
        list.add(cor);

        CountryOfResidenceListResponse response = new CountryOfResidenceListResponse(list);

        completed(methodName);
        return response;
    }
}
