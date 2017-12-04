package code;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@Embeddable
@RequiredArgsConstructor
public class UnitInfo {

    private final String runningId;
    private String bandMake;
    private String customerName;
    private String unitNumber;

    @SuppressWarnings("unused")
    public UnitInfo() {
        this.runningId = "";
    }

}