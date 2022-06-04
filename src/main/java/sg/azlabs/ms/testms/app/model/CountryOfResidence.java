package sg.azlabs.ms.testms.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"uid", "languageCode", "cor", "order", "publishFlag", "createdDt", "modifiedDt"})
public class CountryOfResidence extends BaseModel{
    @JsonProperty("cor")
    private String cor;

    public CountryOfResidence() {
        //Empty Constructor
    }

    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
}
